const REGISTRATION_ENDPOINT = 'register';
function handleRegister(event) {
    event.preventDefault();

    const formData = new FormData(event.target);

    const userObject = {

    };
    formData.forEach((value,key)=> {
        userObject[key] = value;
    });

    console.log(userObject);
    const messageBlock = document.getElementById("error_message");
    if (userObject.password !== userObject.confirmation) {
        messageBlock.innerText = 'Passwords does not match'
        return;
    }
    const sendData = async (data) => {
        const response = fetch(REGISTRATION_ENDPOINT,{
            method:'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type' : 'application/join'
            }
        });
        console.log(response)
        switch ((await response).status) {
            case 200:
                window.location.href = response.url;
            break;
            case 409:
                messageBlock.innerText = 'Email ' + userObject.email + ' is already exists ';
                document.getElementById('email').style.outline = '1px solid red';
                break;
            default:
                messageBlock.innerText = 'Oops, something went wrong, please try again'
                break;
        }
    }
    sendData(userObject);
}

