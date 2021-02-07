// Write a function that highlights the currently active section of a document. There will be multiple divs with input fields inside them. 
// Set the class of the div that contains the currently focused input field to "focus". When focus is lost (blurred), remove the class from 
// the element.

function focus() {
    let inputs = document.querySelectorAll('input[type="text"]');

    Array.from(inputs).forEach(x => {
        x.addEventListener('focus', function(e){
            let parentDivElement = e.currentTarget.parentElement;
            parentDivElement.classList.add('focused');
        });

        x.addEventListener('blur', function(e){
            let parentDivElement = e.currentTarget.parentElement;
            parentDivElement.classList.remove('focused');
        })
    });
}