const BUCKET_ENDPOINT = "bucket"
const BUCKET_CARD = (product) => `<div class="bucket-item">
    <div class="bucket-image">
      <img width="150" height="150" alt="product" src="${product.image}">
    </div>

  <div class="content">
    <h3>${product.name}</h3>
    <p>
      ${product.description}
    </p>
  </div>

  <div class="buttons">
    <button class="btn btn-danger">Remove</button>
  </div>
  </div>`
function getProducts() {
    fetch(BUCKET_ENDPOINT, {
        method:'Get',
        headers: {
            'Content-type' : 'application/json'
        }
    }).then((response) => response.json())
        .then((json) => {
        console.log(json);
        displayitems(json)
    })

}
function displayitems(items) {
    let bucket = document.getElementById("bucket");
    for (const item of items) {
        bucket.innerHTML +=BUCKET_CARD(item)
    }
}
function removeItem(id) {

}
getProducts();