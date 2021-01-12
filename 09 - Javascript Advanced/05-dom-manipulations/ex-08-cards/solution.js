// Write a function which checks cards, shows which one is greater and keeps history of all hands.
// Firstly, add click events to all cards. When one of the cards is clicked, the current background card must 
// be changed with the "whiteCard.jpg" picture (it is given in the skeleton) and the card name should be appended to one of 
// the span elements in the div with id="result". 
// If a card from the top side is clicked, append the card name to the left span (first empty span), otherwise append the 
// card name to the right span (second/last span).
// When cards from both sides are selected, check which one is greater. The greater card should have border "2px solid green" 
// and the lower card - "2px solid red".
// You should clear the span elements which hold the current card names when both are selected, and the winner is selected. 
// After every hand, push the current card names in the history div in the following format:
//  [{top side card name} vs {bottom side card name} ]

function solve() {

   let playerOneCards = document.querySelectorAll('div#player1Div img');
   let playerTwoCards = document.querySelectorAll('div#player2Div img');
   let result = document.querySelectorAll('div#result span');
   let history = document.getElementById('history');

   document.getElementById('player1Div').addEventListener('click', () => {compare(playerOneCards, 0)});
   document.getElementById('player2Div').addEventListener('click', () => {compare(playerTwoCards, 2)});   



   function compare(player, span){
      player.forEach(card => {
         card.addEventListener('click', () => {
            card.src = 'images/whiteCard.jpg'
            result[span].innerText = card.name;
         });
      });

      let firstPlayerCardNumber = Number(result[0].innerText);
      let secondPlayerCardNumber = Number(result[2].innerText);
      const greaterBorder = '2px solid green';
      const lowerBorder = '2px solid red';

      if(firstPlayerCardNumber > 0 && secondPlayerCardNumber > 0){
         if(firstPlayerCardNumber > secondPlayerCardNumber){
            applyBorder(playerOneCards, firstPlayerCardNumber, greaterBorder);
            applyBorder(playerTwoCards, secondPlayerCardNumber, lowerBorder);
         }else{
            applyBorder(playerTwoCards, secondPlayerCardNumber, greaterBorder);
            applyBorder(playerOneCards, firstPlayerCardNumber, lowerBorder);
         }
         
         history.textContent += `[${firstPlayerCardNumber} vs ${secondPlayerCardNumber}] `;

         result[0].innerText = '';    
         result[2].innerText = '';    
      }
   }

   function applyBorder(player, cardName, borderStyle){
      player.forEach(card =>{
         if(card.name == cardName) {
            card.style.border = borderStyle;
         }
      });
   }
}