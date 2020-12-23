// Write a function to create the functionality of a chat room.
// Note: Do not forget to add event listener to the send button!
// The new div element with class message my-message should contain the current message that is about to be send.
// The current div should be appended to the div with an id="chat_messages".
// The input should be cleared on each click of the send button.

function solve() {
   let buttonSend = document.getElementById('send');

   buttonSend.addEventListener('click', function slv(){
      let message = document.getElementById('chat_input');
      let messages = document.getElementById('chat_messages');
   
      let newDiv = document.createElement('div');
      newDiv.classList.add('message');
      newDiv.classList.add('my-message');

      newDiv.innerText = message.value;
      message.value = '';
      
      messages.appendChild(newDiv);
   });

}


