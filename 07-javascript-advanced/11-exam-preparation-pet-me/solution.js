function solve() {
    let buttonElement = document.querySelector('#container > button');
    let inputElements = Array.from(document.querySelectorAll('#container input'));
    let [ nameElement, ageElement, kindElement, ownerElement ] = inputElements;
    let adoptionUlElement = document.querySelector('#adoption ul');
    let adoptedUlElement = document.querySelector('#adopted > ul');

    buttonElement.addEventListener('click', e => {
        e.preventDefault()
        
        //Check if all fields has values
        if ( !inputElements.every(x => x.value) ) {
            return;
        }

        //Check if age is number
       if(!Number( ageElement.value )) {
        return;
       }

        //Create list item
       let liElement = document.createElement('li');
       let pElement = document.createElement('p');
       let spanElement = document.createElement('span');
       let petButtonElement = document.createElement('button');
    
       pElement.innerHTML = 
              `<strong>${nameElement.value}</strong> is a <strong>${ageElement.value}</strong> year old <strong>${kindElement.value}</strong>`
       spanElement.textContent = `Owner: ${ownerElement.value}`
       petButtonElement.textContent = `Contact with owner`;
       


       liElement.appendChild(pElement);
       liElement.appendChild(spanElement);
       liElement.appendChild(petButtonElement);
        //Add list item to #adoption
        adoptionUlElement.appendChild(liElement);

        //Clear all input fields
        inputElements.forEach(el => el.value = "");

        //Attach event handler
        petButtonElement.addEventListener('click', petButtonClick)

    });

    function petButtonClick(e){
        let parent = e.currentTarget.parentElement;

        e.currentTarget.remove()
        
        let divElement = document.createElement('div');
        let inputElement = document.createElement('input');
        let takeItButtonElement = document.createElement('button');

        inputElement.setAttribute("placeholder", "Enter your names");
        takeItButtonElement.textContent = "Yes! I take it!"

        divElement.appendChild(inputElement)
        divElement.appendChild(takeItButtonElement)

        parent.appendChild(divElement);

        takeItButtonElement.addEventListener('click', onTakeItButtonClick )
    }

    function onTakeItButtonClick(e) {
        let parentButtonElement = e.currentTarget.parentElement;
        let liElement = e.currentTarget.parentElement.parentElement;
        
        
        let newOwnerInputElement = liElement.querySelector('input');
        let ownerNameSpanElement = liElement.querySelector('span')
        
        let newOwner = newOwnerInputElement.value;
        if(!newOwner){
            return;
        }
        
        ownerNameSpanElement.textContent = `New Owner: ${newOwner}`;
        
        adoptedUlElement.appendChild(liElement);
        
        parentButtonElement.remove();

        let checkedButtonElement = document.createElement('button');
        checkedButtonElement.textContent = 'Checked';

        liElement.appendChild(checkedButtonElement);

        checkedButtonElement.addEventListener('click', e => {
            liElement.remove()});
    }
}

