// Write a function that converts a decimal number to binary and hexadecimal.
// The given number will always be in decimal format. The "From" select menu will only have a
// Decimal option, but the "To" select menu will have two options: Binary and Hexadeicmal. 
// This means that our program should have the functionality to convert decimal to binary and
// decimal to hexadecimal.
// Note that "To" select menu by default is empty. You have to insert the two options ('Binary' and 'Hexadecimal') 
// inside before continue. Also they should have values ('binary' and 'hexadecimal').

function solve() {
  
    let num = document.getElementById('input');
    let result = document.getElementById('result');
    let selectMenu = document.getElementById('selectMenuTo');
    
    let firstOption = document.createElement('option');
    firstOption.value = 'binary';
    firstOption.innerText = 'Binary';
    selectMenu.appendChild(firstOption);

    let secondOption = document.createElement('option');
    secondOption.value = 'hexadecimal';
    secondOption.innerText = 'Hexadecimal';
    selectMenu.appendChild(secondOption);

    document.getElementsByTagName('button')[0].addEventListener('click', convert)
    
    function convert(){
       switch (selectMenu.value){
           case 'binary':
               result.value = Number(num.value).toString(2);
               break;
           case 'hexadecimal':
               result.value = Number(num.value).toString(16).toUpperCase();
               break;
       }
    }

}