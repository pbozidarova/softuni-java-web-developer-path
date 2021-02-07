// Write a JS program that displays arrival times for all buses by a given bus stop ID when a button is clicked. Use the skeleton from 
// the provided resources.
// When the button with ID 'submit' is clicked, the name of the bus stop appears and the list bellow gets filled with all the buses that 
// are expected and their time of arrival. Take the value of the input field with id 'stopId'. 
// Submit a GET request to https://judgetests.firebaseio.com/businfo/{stopId}.json (replace the highlighted part with the correct value) 
// and parse the response. You will receive a JSON object in the format:
// stopId: {
//   name: stopName,
//   buses: { busId: time, … }
// }
// Place the name property as text inside the div with ID 'stopName' and each bus as a list item with text:
// "Bus {busId} arrives in {time}"
// Replace all highlighted parts with the relevant value from the response. If the request is not successful, or the information is not 
// in the expected format, display "Error" as stopName and nothing in the list. The list should be cleared before every request is sent.


function getInfo() {
    let validBuses = ['1287', '1308', '1327', '2334'];
    let stopId = document.getElementById('stopId');
    let stopInfo = document.getElementById('stopName');
    let buses = document.getElementById('buses');

    if(!validBuses.includes(stopId.value)) {
        stopInfo.textContent = 'Error';
        buses.textContent = '';
        return;
    }

    const url = `https://judgetests.firebaseio.com/businfo/${stopId.value}.json`

    fetch(url).then((response) => response.json())
              .then((data) => {
                  stopInfo.textContent = data.name;
                  
                  Object.keys(data.buses).forEach(key => {
                      let li = document.createElement(`li`);
                      li.textContent = `Bus ${key} arrives in ${data.buses[key]} minutes`;
                      buses.appendChild(li);
                  });
              });
    stopId.value = '';
}