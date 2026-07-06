
const GATEWAY_URL = "http://localhost:8080/gateway";


function getUsers() {
    fetchFromGateway("/users");
}


function getProducts() {
    fetchFromGateway("/products");
}

s
function fetchFromGateway(path) {

    const outputBox = document.getElementById("output");
    outputBox.innerText = "Loading, please wait...";

    fetch(GATEWAY_URL + "?path=" + path)
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
   
            outputBox.innerText = JSON.stringify(data, null, 2);
        })
        .catch(function (error) {
            outputBox.innerText = "Something went wrong: " + error;
        });
}
