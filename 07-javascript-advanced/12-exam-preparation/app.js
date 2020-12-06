function solve() {
    let openSection = document.getElementsByTagName('section')[1];
    let progressSection = document.getElementsByTagName('section')[2];
    let completeSection = document.getElementsByTagName('section')[3];

    let addButtonElement = document.getElementById('add');

    addButtonElement.addEventListener('click', (event) => {
        event.preventDefault();

        let [taskElement, dateElement ] = document.querySelectorAll('form > input');
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

        let buttonStartElement = document.createElement('button');
        buttonStartElement.className = 'green';
        buttonStartElement.innerText = 'Start';

        let buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.className = 'red';
        buttonDeleteElement.innerText = 'Delete';

        let buttonFinishElement = document.createElement('button');
        buttonFinishElement.className = 'orange';
        buttonFinishElement.innerText = 'Finish';

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

        divElement.appendChild(buttonStartElement);
        divElement.appendChild(buttonDeleteElement);

        article.appendChild(h3Element);
        article.appendChild(pDescriptionElement);
        article.appendChild(pDateElement);
        article.appendChild(divElement);

        openSection.lastElementChild.appendChild(article);

        taskElement.value = '';
        descriptionElement.value = '';
        dateElement.value = ''
    });
}