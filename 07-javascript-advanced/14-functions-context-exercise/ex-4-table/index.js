// Write the missing JavaScript code to make the Table application work as expected.
// When you click on an item from the table you should change its background color to "#413f5e". 
// If the item you've clicked already has a style property you should remove it. 
// If one of the elements is clicked and you click another the first element's style property should be removed and you should change 
// the background color of the newly clicked item.

// Note: You shouldn't change the head of the table, even if it is clicked.

function solve(){
   let tr = document.getElementsByTagName('tr');
   let lastClicked = tr[1];
   [...tr].slice(1).forEach(row => {
      row.addEventListener('click', (event) => {
         
         let element = event.target.parentNode.style;
         if(element.backgroundColor == '' || element.backgroundColor  == undefined) {
            lastClicked.backgroundColor = element.backgroundColor;
            element.backgroundColor = '#413f5e'; 
                       
         }else{
            element.backgroundColor = '';            
         }   
         
         lastClicked = element;
      });
   });
}
