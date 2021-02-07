// Write a function that orders names alphabetically.
// You will receive a name of a student as an input. When the "Register" button is clicked, you should
// add the given student name in the SoftUni Database, while keeping the alphabetial order.
// For instance, if we register David, his name should appear in the D column.

function solve() {
    let input = document.getElementsByTagName('input')[0];
    let btn = document.getElementsByTagName('button')[0];
    
    let database = {};
    let index = 0;
    for(let symbol = 65; symbol <=90; symbol++, index++){
        let letter = String.fromCharCode(symbol);
        database[letter] = index;
    }

    btn.addEventListener('click', () => {
        let array = document.getElementsByTagName('ol')[0].children;
        let currentName = input.value.toString()[0].toUpperCase() + input.value.slice(1).toLowerCase();
        let capitalLetter = currentName[0];
        
        if(database[capitalLetter] != undefined){
            let currentIndex = database[capitalLetter];
            let currentElement = array[currentIndex];
            
            if(currentElement.textContent){
                currentElement.textContent += ', ';
            } 
            currentElement.textContent += currentName;            
        }
        input.value = '';
    });
}