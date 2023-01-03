const PRODUCT_ENDPOINT = "product";
const BUCKET_ENDPOINT = 'bucket';
const userId = localStorage.getItem('userId')
const CARDFORPRODUCTS = (product) => {
    return `  <div class="col">
            <div class="card shadow-sm">
                <img src="${product.image}" alt="product" width="250" height="250">
                <div class="card-body">
                    <p class="card-text">${product.name}</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                        <a href="product?id=${product.id}">
                            <button type="button" class="btn btn-sm btn-outline-secondary">View</button>                    
                        </a>
                            <button onclick="addProductToBucket(${product.id})" type="button" class="btn btn-sm btn-outline-secondary">
                                <i class="fa-sharp fa-solid fa-basket-shopping"></i>
                            </button>
                        </div>
                        <span class="text-muted">${product.price}</span>
                    </div>
                </div>
            </div>
        </div>  `;
}

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

function getAllProducts() {
    console.log('!!!!');
    fetch(PRODUCT_ENDPOINT, {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json'
        }
    }).then((response) => {
        console.log(response);
        return response.json();
    }).then((json)=> {
        console.log(json);
        displayCards(json)
    })
}

getAllProducts();

function displayCards(products) {
    const container = document.getElementById('cards')
    for (const product of products) {
        container.innerHTML += CARDFORPRODUCTS(product)
    }
}

function addProductToBucket(productId) {
    if (!userId) {
        window.location.href = 'login.jsp';
        return;
    }
    fetch(BUCKET_ENDPOINT, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            bucketId: userId,
            productId
        })
    }).then((rezult) => {
        alert('Added to bucket')
    })
}