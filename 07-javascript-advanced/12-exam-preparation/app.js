// When the Add button is clicked, first you need to validate the inputs. If any of the input fields is empty, the function 
// doesn’t make anything. After validating the input fields, you need to add the new task (article) in “Open” section. 
// When the “Delete” button is clicked, the Task (whole article) should be removed from the HTML. 
// After clicking the “Finish” button, the Task will be completed, and you should move the article in the section “Complete”. 
// The buttons with their parent div-element should be removed.

function solve() {
    let [addSection, openSection, progressSection, completeSection] = document.querySelectorAll('section');

    let addButtonElement = document.getElementById('add');

    addButtonElement.addEventListener('click', (event) => {
        event.preventDefault();

        let  [taskElement, dateElement ] = document.querySelectorAll('form > input');
        let descriptionElement = document.getElementById('description');

        if(taskElement.value == '' || descriptionElement.value == '' || dateElement.value == '') {
            return;
        }

        let article = document.createElement('article');
        let h3Element = document.createElement('h3');
        h3Element.innerText = taskElement.value;

        let pDescriptionElement = document.createElement('p');
        pDescriptionElement.innerText = `Description: ${descriptionElement.value}`;
        
        let pDateElement = document.createElement('p');
        pDateElement.innerText = `Due Date: ${dateElement.value}`;
        
        let divElement = document.createElement('div');
        divElement.className = 'flex';

        let buttonStartElement = createButtonElement('green', 'Start')

        let buttonDeleteElement = createButtonElement('red', 'Delete')

        let buttonFinishElement = createButtonElement('orange', 'Finish')

        divElement.appendChild(buttonStartElement);
        divElement.appendChild(buttonDeleteElement);

        article.appendChild(h3Element);
        article.appendChild(pDescriptionElement);
        article.appendChild(pDateElement);
        article.appendChild(divElement);

        openSection.lastElementChild.appendChild(article);

        buttonStartElement.addEventListener('click', (event) => {
            progressSection.lastElementChild.appendChild(article);
                
            article.lastElementChild.children[0].remove();
            article.lastElementChild.appendChild(buttonFinishElement);
        });

        buttonDeleteElement.addEventListener('click', (event) => {
            event.target.parentElement.parentElement.remove();
        });

        buttonFinishElement.addEventListener('click', (event) => {
            article.lastElementChild.remove();
            completeSection.lastElementChild.appendChild(article);
            
        });

        taskElement.value = '';
        descriptionElement.value = '';
        dateElement.value = ''
    });

    function createButtonElement(className, innterText) {
        let buttonElement = document.createElement('button');
        buttonElement.className = className;
        buttonElement.innerText = innterText;

        return buttonElement;
    }
}