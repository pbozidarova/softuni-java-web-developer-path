// Write a JS program that records and displays messages. The user can post a message, supplying a name and content and retrieve all 
// currently recorded messages. Use the skeleton from the provided resources
// Firebase url for the requests - https://rest-messanger.firebaseio.com/messanger.json
// When [Send] button is clicked you should create a new object and send a post request to the firebase url. 
// Use the following message structure:
// {
//   author: authorName,
//   content: msgText,
// }
// The key associated with each message object is not important - when making a POST request with the message object as parameter, 
// Firebase will automatically assign a random key.
 
// If you click over [Refresh] button you should get all messages with GET request and display them into the textarea. 
// Use the following message format:
// "{author}: {message}"

function attachEvents() {
    let url = 'https://rest-messanger.firebaseio.com/messanger.json';

    let refreshButton = document.getElementById('refresh');
    refreshButton.addEventListener('click', () => {
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                let result = Object.values(data).reduce(
                    (messages, message) => 
                                (messages += `${message.author}: ${message.content}\n`), '');
                document.getElementById('messages').textContent = result;
            });
    });

    let submitButton = document.getElementById('submit');
    submitButton.addEventListener('click', () => {
        let author = document.getElementById('author');
        let content = document.getElementById('content');

        fetch(url, {method: 'POST', 
                    body: JSON.stringify({author: author.value, content: content.value})
                });
        author.value = '';
        content.value = '';
    });
    

}

attachEvents();