// Write a function that dynamically validates an email input field when it is changed. If the input is invalid, apply the style "error". 
// Do not validate on every keystroke, as it is annoying for the user, consider only change events.
// A valid email is considered to be in the format: <name>@<domain>.<extension>
// Only lowercase Latin characters are allowed for any of the parts of the email. If the input is valid, clear the style. 

function validate() {
    let inputElement = document.getElementById('email');

    inputElement.addEventListener('change', e => {
        let currentValue = e.currentTarget.value;

        let pattern = /[a-z]+@[a-z]+.[a-z]+/;

        if(pattern.test(currentValue)){
            e.currentTarget.classList.remove('error');
        }else{
            e.currentTarget.classList.add('error');
        }
    });
}