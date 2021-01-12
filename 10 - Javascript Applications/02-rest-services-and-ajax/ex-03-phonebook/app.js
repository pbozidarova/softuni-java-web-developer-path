// Write a JS program that can load, create and delete entries from a Phonebook. You will be given an HTML template to which you must bind 
// the needed functionality. 
// Use the skeleton from the provided resources.
// When the [Load] button is clicked, a GET request should be made to the server to get all phonebook entries. Each  received entry 
// should be in a li inside the ul with id="phonebook" in the following format with text "<person>: <phone> " and a [Delete] button attached. 
// Pressing the [Delete] button should send a DELETE request to the server and delete the entry. The received response will be an object in the 
// following format:
// {<key>:{person:<person>, phone:<phone>}, <key2>:{person:<person2>, phone:<phone2>,…} 
    
//     where <key> is an unique key given by the server and <person> and <phone> are the actual values.
// When the [Create] button is clicked, a new POST request should be made to the server with the information from the Person and Phone textboxes,
// the Person and Phone textboxes should be cleared and the Phonebook should be automatically reloaded (like if the [Load] button was pressed).
// The data sent on a POST request should be a valid JSON object, containing properties person and phone. Example format: 
// {
// "person": "<person>",
// "phone": "<phone>"
// }
// The url to which your program should make requests is:
// 'https://phonebook-nakov.firebaseio.com/phonebook'
// GET and POST requests should go to https://phonebook-nakov.firebaseio.com/phonebook.json, while DELETE requests should go to 
// https://phonebook-nakov.firebaseio.com/phonebook/<key>.json , where <key> is the unique key of the entry (you can find out the key 
// from the key property in the GET request)


function attachEvents() {
    const url = 'https://phonebook-nakov.firebaseio.com/phonebook.json'

    let btnLoad = document.getElementById('btnLoad');
    let btnCreate = document.getElementById('btnCreate');
    let ul = document.getElementById('phonebook');

    btnLoad.addEventListener('click', () => {
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                Object.keys(data).forEach(key => {
                    let li = document.createElement('li');
                    li.textContent = `${data[key].person}: ${data[key].phone}`;
                    let deleteBtn = document.createElement('button');
                    
                    deleteBtn.textContent = 'DELETE';
                    
                    deleteBtn.addEventListener('click', () => {del(key)});
                    
                    li.appendChild(deleteBtn);
                    ul.appendChild(li);
                });
            });
    });

    btnCreate.addEventListener('click', create);

    function del(key) {
        let deleteUrl = `https://phonebook-nakov.firebaseio.com/phonebook/${key}.json`
        fetch(deleteUrl, {method: 'DELETE'});

    }

    function create() {
            let person = document.getElementById('person');
            let phone = document.getElementById('phone');
    
            let obj =  {person: person.value, phone: phone.value} ;
    
            fetch(url, {method: 'POST', body: JSON.stringify(obj)});    
    }

}

attachEvents();