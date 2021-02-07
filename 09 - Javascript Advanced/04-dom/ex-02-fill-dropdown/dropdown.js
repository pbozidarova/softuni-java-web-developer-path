// 2.	Fill Dropdown
// Your task is to take values from input fields with ids "newItemText" and "newItemValue". 
// Then you should create and append an <option> to the <select> with id "menu".

function addItem() {
    let text = document.getElementById('newItemText');
    let data = document.getElementById('newItemValue');
    
    let select = document.getElementById('menu');
    
    //variant 1
    // let option = `<option value=${data}>${text}</option>`
    // select.innerHTML = option;

    // variant 2
    let option2 = document.createElement('option');
    option2.value = data.value;
    option2.innerText = text.value;
    select.appendChild(option2);

    text.value = '';
    data.value = '';
}