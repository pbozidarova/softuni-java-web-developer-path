// Write the missing JavaScript code to make the Dropdown Menu application work as expected.
// When you click on the [Choose your style] button, the elements of the menu should become visible. 
// When you click on one of the items the background color of the box below should be changed to the RGB, 
// which is displayed in the list item
// When the [Choose your style] button is clicked again, you should hide the list items, and the box should be returned to its initial state.

function solve() {
    let dropdownElement = document.getElementById('dropdown-ul');
    let dropdownButtonElement = document.getElementById('dropdown');
    let boxElement = document.getElementById('box');

    dropdownButtonElement.addEventListener('click', e => {
        //toggle menu
        let toggledDisplay = dropdownElement.style.display == 'block'
            ? 'none'
            : 'block';
        if(toggledDisplay == 'none'){
            boxElement.style.backgroundColor = 'black';
            boxElement.style.color = 'white';
        }
        dropdownElement.style.display = toggledDisplay;
    });

    dropdownElement.addEventListener('click', e => {
        boxElement.style.backgroundColor = e.target.textContent;
        boxElement.style.color = 'black';
    });
}