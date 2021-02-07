function solution() {
    const giftInputElement = document.querySelector('input');
    const addGiftButton = document.querySelector('button');

    const [addGiftSE, listOfGiftsSE, sentGiftsSE, discardedGiftsSE] = document.querySelectorAll('section');

    addGiftButton.addEventListener('click', e => {
        const liElement = document.createElement('li');
        liElement.innerText = giftInputElement.value;
        liElement.className = 'gift';

        let sendButtonElement = createButton('sendButton', 'Send', liElement);
        let discardButtonElement = createButton('discardButton', 'Discard', liElement);

        let ulElement = listOfGiftsSE.querySelector('ul');
        ulElement.appendChild(liElement);

        let liElements = listOfGiftsSE.querySelectorAll('.gift');
        let sortedLis = Array.from(liElements)
                                    .sort((a, b) => a.innerText.localeCompare(b.innerText));
        ulElement.innerHTML = '';
        sortedLis.forEach(li => ulElement.appendChild(li));

        sendButtonElement.addEventListener('click', (e) => sendOrDiscard(e, sentGiftsSE));
        discardButtonElement.addEventListener('click', (e) => sendOrDiscard(e, discardedGiftsSE));
        
        giftInputElement.value = '';
    });     

    function sendOrDiscard(e, section){
        let liElementInnerText = e.target.parentElement.innerText;
        liElementInnerText = liElementInnerText.replace('Send', '').replace('Discard', '');
        
        let liElement = document.createElement('li');
        liElement.className = 'gift';
        liElement.innerText = liElementInnerText;

        section.querySelector('ul').appendChild(liElement);

        e.target.parentElement.remove();
    }

    function createButton(id, innerText, parent){
        let buttonElement = document.createElement('button');
        buttonElement.setAttribute('id', id);
        buttonElement.innerText = innerText;
        
        parent.appendChild(buttonElement);

        return buttonElement;
    }
}