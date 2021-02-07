function solve() {
    const [ nameElement, hallElement, ticketPriceElement, addButtonElement  ] = Array.from(document.getElementById('container').children);
    const [ moviesSE, archiveSE ] = Array.from(document.querySelectorAll('section'));

    
    addButtonElement.addEventListener('click', e => {
        e.preventDefault();

        movieName = nameElement.value;
        hall = hallElement.value;
        ticketPrice = ticketPriceElement.value;

        if(!movieName, !hall, !ticketPrice) {
            return;
        }
    
        if (!Number(ticketPrice)) {
            return;
        }
    
        let liElement = document.createElement('li');
        let liInnerHtml = `<span>${movieName}</span> <strong>Hall: ${hall}</strong>`;
        liElement.innerHTML = liInnerHtml;
        
        let divEl = document.createElement('div');
        divEl.innerHTML = `<strong>${ticketPrice}</strong>`;
        
        let inputEl = document.createElement('input');
        inputEl.setAttribute('placeholder', 'Tickets Sold');
        divEl.appendChild(inputEl);
        
        let archiveBtnElement = createButton('Archive', divEl);
        
        liElement.appendChild(divEl);
    
        moviesSE.querySelector('ul').appendChild(liElement);

        archiveBtnElement.addEventListener('click', (e) => {
            let soldTickets = e.target.parentElement.querySelector('input').value;
            if(!Number(soldTickets)){
                return;
            }

            let liArchiveElement = document.createElement('li');
            let liArchiveInnerHtml = `<span>${this.movieName}</span><strong>Total amount: ${(this.ticketPrice*soldTickets).toFixed(2)}</strong>`;
            
            liArchiveElement.innerHTML = liArchiveInnerHtml;
            
            let deleteButtonEl = createButton('Delete', liArchiveElement);

            archiveSE.querySelector('ul').appendChild(liArchiveElement);

            deleteButtonEl.addEventListener('click', e => {
                e.target.parentElement.remove();
            })

            e.target.parentElement.parentElement.remove();
        });

        archiveSE.querySelector('button').addEventListener('click', e => {
            archiveSE.querySelector('ul').innerHTML = '';
        });
        

        document.querySelectorAll('input').forEach(input => input.value = '');


    });

    function createButton(innerText, parent){
        let buttonElement = document.createElement('button');
        buttonElement.innerText = innerText;
        parent.appendChild(buttonElement);

        return buttonElement;
    }

    
    nameElement.value = 'Avengers: Endgame';
    hallElement.value = 'Main';
    ticketPriceElement.value = 5;
    

}