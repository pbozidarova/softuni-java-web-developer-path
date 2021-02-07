// Extend the previous problem to display a [Delete] link after each list item. Clicking it, should delete the item with no confirmation.

function addItem() {
    let inputElement = document.getElementById('newText');

    let liElement = document.createElement('li');
    liElement.innerHTML = `${inputElement.value}`;

    let delElement = document.createElement('a');
    delElement.setAttribute('href', '#')
    delElement.innerText = '[Delete]';

    liElement.appendChild(delElement);

    delElement.addEventListener('click', function(e) {
        let parentElement = e.target.parentElement;
        parentElement.remove();
    })
    
    document.getElementById('items').appendChild(liElement);
    inputElement.value = '';
}