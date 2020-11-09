// Each catch should have:
// •	angler - string representing the name of the person who caught the fish
// •	weight - floating-point number representing the weight of the fish in kilograms
// •	species - string representing the name of the fish species
// •	location - string representing the location where the fish was caught
// •	bait - string representing the bait used to catch the fish
// •	captureTime - integer number representing the time needed to catch the fish in minutes
// HTML Template
// Use the skeleton from the provided resources.
// Attach handlers to the [Load], [Update], [Delete] and [Add] buttons, which make the appropriate GET, PUT, DELETE and POST requests. 
// You are given an example catch in the template to show you where and how to insert the catches. Notice that the div containing the catch has an attribute data-id that should store the _id of the entry given by Kinvey. 
// Create the following REST services to access your data:
// •	List All Catches
//     o	Endpoint - https://fisher-game.firebaseio.com/catches.json
//     o	Method: GET
//     o	Returns (Object of objects)
// •	Create a New Catch
//     o	Endpoint: https://fisher-game.firebaseio.com/catches.json
//     o	Method: POST
//     o	Request body (JSON): {"angler":"…", "weight":…, "species":"…", "location":"…", "bait":"…", "captureTime":…}
// •	Update a Catch
//     o	Endpoint: https://fisher-game.firebaseio.com/catches/{catchId}.json
//     o	Method: PUT
//     o	Request body (JSON): {"angler":"…", "weight":…, "species":"…", "location":"…", "bait":"…", "captureTime":…}
// •	Delete a Catch
//     o	Endpoint: https://fisher-game.firebaseio.com/catches/{catchId}.json
//     o	Method: DELETE
// •	Pressing the [Load] button should list all catches. 
// •	Pressing the [Update] button should send a PUT request, updating the catch in firebase. 
// •	Pressing the [Delete] button should delete the catch both from firebase and from the page. 
// •	Pressing the [Add] button should submit a new catch with the values of the inputs in the fieldset with id="addFrom".


function attachEvents() {
    const addButton = document.querySelector('button.add');
    const loadButton = document.querySelector('button.load');

    let catchesDiv = document.getElementById('catches');

    const baseURL = 'https://fisher-game.firebaseio.com/catches.json';
    const updateDeleteUrl = 'https://fisher-game.firebaseio.com/catches/';

    addButton.addEventListener('click', addCatch);
    
    loadButton.addEventListener('click', () => {
        fetch(baseURL)
            .then(response => response.json())
            .then(data => {
                Object.keys(data).forEach(key => appendCatch(key, data));
            });
    });
    
    function appendCatch(key, data){
        let objNeededOrder = {angler: data[key].angler, 
                              weight: data[key].weight, 
                              species: data[key].species, 
                              location: data[key].location, 
                              bait: data[key].bait, 
                              captureTime: data[key].captureTime };
        
        let catchDiv = createElement('div', 'catch', "");
        catchDiv.setAttribute('data-id', key);
        
        let catchArr = [];

        Object.entries(objNeededOrder).forEach(([catchKey, catchValue]) => {
            
            let labelTitle = catchKey == 'captureTime' ? 'Capture Time' : catchKey

            catchArr.push(createElement('label', '', labelTitle.charAt(0).toUpperCase() + labelTitle.slice(1)));
            let elementType = catchKey == 'weight' || catchKey == 'captureTime' ? 'number' : 'text';
            catchArr.push(createElement('input', catchKey, catchValue, elementType));
            catchArr.push(document.createElement('hr'));
        });              
        
        let updateButton = createElement('button', 'update', 'UPDATE');
        let deleteButton = createElement('button', 'delete', 'DELETE');

        deleteButton.addEventListener('click', () => {
            fetch(updateDeleteUrl + `${key}.json`, {method: 'DELETE'})
                .then(response => response.json())
                .then(response => {console.log(response);});
        });
        updateButton.addEventListener('click', () => {
            
            let obj = JSON.stringify({
                angler: anglerInput.value,
                weight: weightInput.value,
                species: speciesInput.value,
                location: locationInput.value,
                bait: baitInput.value,
                captureTime: captureTimeInput.value,
            });

            fetch(updateDeleteUrl + `${key}.json`, {method: 'PUT', body: obj});
        })
        catchArr.push(updateButton, deleteButton);
        
        catchArr.forEach(el => catchDiv.appendChild(el));
        catchesDiv.appendChild(catchDiv);
    }

    function addCatch() {
        let angler = document.querySelector('#addForm input.angler');
        let weight = document.querySelector('#addForm input.weight');
        let species = document.querySelector('#addForm input.species');
        let location = document.querySelector('#addForm input.location');
        let bait = document.querySelector('#addForm input.bait');
        let captureTime = document.querySelector('#addForm input.captureTime');

        let obj = JSON.stringify({
                    angler: angler.value,
                    weight: weight.value,
                    species: species.value,
                    location: location.value,
                    bait: bait.value,
                    captureTime: captureTime.value,
                });

        fetch(baseURL, {method: "POST", body: obj})
                .then(response => response.json())
        //clear input fields        
        angler.value = '';
        weight.value = '';
        species.value = '';
        location.value = '';
        bait.value = '';
        captureTime.value = '';
    }

    function createElement(ele, classes, content, type){
        let element = document.createElement(ele);
        if(ele === 'input'){
            element.type = type;
            element.value = content;
        }else{
            element.innerHTML = content;
        }

        element.className = classes;
        return element
    }
}

attachEvents();

