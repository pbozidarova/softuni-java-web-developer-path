// Write a function that read the text inside an input field and appends the specified text to a list inside an HTML page.

function addItem() {
    let inputElement = document.getElementById('newItemText');

    let liElement = document.createElement('li');
    liElement.innerHTML = inputElement.value;

    document.getElementById('items').appendChild(liElement);
    inputElement.value = '';
}