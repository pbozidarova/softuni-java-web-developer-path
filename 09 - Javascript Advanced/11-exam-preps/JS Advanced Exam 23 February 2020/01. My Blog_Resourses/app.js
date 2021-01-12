function solve(){
   const [creatorInputElement, titleInputElement, categoryInputElement] = Array.from(document.querySelectorAll('input'));
   const contentInputElement = document.getElementById('content');

   const createButtonElement = document.querySelector('button.btn');

   const mainSectionElement = document.querySelector('main section');

   createButtonElement.addEventListener('click', e => {
      e.preventDefault();

      // if(!creatorInputElement.value || !titleInputElement.value || !categoryInputElement.value || !contentInputElement.value){
      //    return;
      // }


      let articleElement = document.createElement('article')
      
      let h1Element = document.createElement('h1');
      h1Element.innerText = titleInputElement.value;
      articleElement.appendChild(h1Element);
      
      createAndAppendPElement(`Category: <strong>${categoryInputElement.value}</strong>`, articleElement);
      createAndAppendPElement(`Creator: <strong>${creatorInputElement.value}</strong>`, articleElement);
      createAndAppendPElement(`${contentInputElement.value}`, articleElement);
      
      let divButtonsElement = document.createElement('div');
      divButtonsElement.className = 'buttons';

      let deleteButtonElement = createButtonAndAppendIt('btn delete', 'Delete', divButtonsElement);
      let archiveButtonElement = createButtonAndAppendIt('btn archive', 'Archive', divButtonsElement);

      articleElement.appendChild(divButtonsElement);
      mainSectionElement.appendChild(articleElement);

      deleteButtonElement.addEventListener('click', e => {
         e.currentTarget.parentElement.parentElement.remove();

      });

      archiveButtonElement.addEventListener('click', e => {
         const liElement = document.createElement('li');
         const articleTitle = e.target.parentElement.parentElement.querySelector('h1').innerText;
         
         liElement.innerText = articleTitle;
         const ulElement = document.querySelector('.archive-section ul');
         ulElement.appendChild(liElement);

         
         let sortedLi = Array.from(document.querySelectorAll('.archive-section ul li'))
         .sort((a, b) => a.innerText.localeCompare(b.innerText))
         
         ulElement.innerHTML = '';
         
         sortedLi.forEach(li => ulElement.appendChild(li));  
      
            e.currentTarget.parentElement.parentElement.remove();
         });   


      Array.from(document.querySelectorAll('input')).forEach(el => el.value = '');
      contentInputElement.value = '';
   });

   function createAndAppendPElement(htmlValue, articleElement){
      const pElement = document.createElement('p');
      pElement.innerHTML = htmlValue;

      articleElement.appendChild(pElement);
   }

   function createButtonAndAppendIt(classes, innerText, divButtonsElement){
      const buttonElement = document.createElement('button');
      buttonElement.classList = classes;
      buttonElement.innerText = innerText;

      divButtonsElement.appendChild(buttonElement);

      return buttonElement;
   }
}
