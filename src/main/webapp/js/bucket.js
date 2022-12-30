function getProducts() {
    fetch('bucket', {
        method:'Get',
        headers: {
            'Content-type' : 'application/json'
        }
    }).then((response) => response.json())
        .then((json) => {
        console.log(json);
    })

}

getProducts();