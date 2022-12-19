const PRODUCT_ENDPOINT = "product"
function saveProduct(event) {
    event.preventDefault();

    const formData = new FormData(event.target);

    const productObject = {

    };
    formData.forEach((value,key)=> {
        productObject[key] = value;
    });

    console.log(productObject);
    // TODO handle image preview
    productObject.image = null;
    const sendData = async (data) => {
        const response = fetch(PRODUCT_ENDPOINT, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/join'
            }
        });
        console.log(response);
        if ((await response).status !== 200) {
            document.getElementById("alert").removeAttribute("hidden")
            document.getElementById("alert").innerText = "Oops something went wrong. Please try again"
        }
    }
    sendData(productObject)
}