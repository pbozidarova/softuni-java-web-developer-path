// Write a program that takes an e-mail from an input field and deletes the matching row from a table. If no entry is found, an error should be displayed 
// in a <div> with ID "results". The error should be "Not found." Submit only the deleteByEmail() function in judge. 

function deleteByEmail() {
    let inputElement = document.querySelector('input[name="email"]');
    let enteredEmail = inputElement.value;

    let customerEmails = document.querySelectorAll('#customers td:nth-of-type(2)');
    let isDeleted = false;
    for (const customerElement of customerEmails) {
        if(customerElement.textContent === enteredEmail) {
            customerElement.parentElement.remove();
            isDeleted = true;
        }
    }

    if(!isDeleted){
        let resultsElement = document.getElementById('result');
        resultsElement.innerHTML = 'Not found.'
    }

    enteredEmail = '';
}