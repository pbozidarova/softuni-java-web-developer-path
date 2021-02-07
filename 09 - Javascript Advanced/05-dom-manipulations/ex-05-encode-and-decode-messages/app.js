// In this problem, you should create a JS functonality which encodes and decodes some
// messages which travel to the network.
// This program should contain two functionalities.
// The first one is to encode the given message and send it to the receiver. 
// The second one is to decode the received message and read it (display it).

// When the [Encode and send it] button is clicked, you should get the given message from the first textarea. When you get the current message, 
// you should encode it as follows:
// •	Change the ASCII CODE on every single character in that message when you add 1 to the current ASCII NUMBER, that represent the current 
// character in that message
// •	Clear the sender textarea and append the encoded message to the receiver textarea

// After that, when the [Decode and read it] button is clicked. You need to get the encoded message from the receiver textarea and do the 
// opposite logic from encoding:
// •	Subtract 1 from the current ASCII NUMBER, that represents the current character in that message
// •	Replace the encoded message with the already decoded message in the receiver textrea, to make it readable


function encodeAndDecodeMessages() {
    let encodeBtn = document.querySelectorAll('button')[0];
    let dencodeBtn = document.querySelectorAll('button')[1];
    let messageInput = document.querySelectorAll('textarea')[0];
    let messageOutput = document.querySelectorAll('textarea')[1];

    encodeBtn.addEventListener('click', encodeMessages);
    dencodeBtn.addEventListener('click', decodeMessages);

    function encodeMessages() {
        let theText = messageInput.value;
        let encodedMessage = '';
        for (let i = 0; i < theText.length; i++) {
            encodedMessage += String.fromCharCode(ascii(`${theText[i]}`) + 1);
        }
        messageInput.value = '';
        messageOutput.value = encodedMessage;
    }

    function decodeMessages() {
        let theText = messageOutput.value;
        let decodedMessage = '';
        for (let i = 0; i < theText.length; i++) {
            decodedMessage += String.fromCharCode(ascii(`${theText[i]}`) - 1);
        }
        messageOutput.value = decodedMessage;
    }

    function ascii(a) {
        return a.charCodeAt(0);
    }
}