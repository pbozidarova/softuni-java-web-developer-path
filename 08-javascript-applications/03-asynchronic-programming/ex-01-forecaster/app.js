// Write a program that requests a weather report from a server and displays it to the user.
// Use the skeleton from the provided resources.
// When the user writes the name of a location and clicks “Get Weather”, make a GET request to the server at address 
// https://judgetests.firebaseio.com/locations.json. The response will be an array of objects, with the following structure:
// { 
//   name: locationName,
//   code: locationCode
// }
// Find the object, corresponding to the name that the user submitted in the input field with ID "location" and use its code 
// value to make two more GET requests:
// •	For current conditions, make a request to:
// https://judgetests.firebaseio.com/forecast/today/{code}.json 
// The response from the server will be an object with the following structure:
// { 
//   name: locationName,
//   forecast: { low: temp,
//               high: temp,
//               condition: condition } 
// }
// •	For a 3-day forecast, make a request to: 
// https://judgetests.firebaseio.com/forecast/upcoming/{code}.json
// The response from the server will be an object with the following structure:

// { 
//   name: locationName,
//   forecast: [{ low: temp,
//                high: temp,
//                condition: condition }, … ] 
// }
// Use the information from these two objects to compose a forecast in HTML and insert it inside the page. Note that the 
{/* <div> with ID "forecast" must be set to visible. See the examples for details.  */}
// If an error occurs (the server doesn’t respond or the location name cannot be found) or the data is not in the correct format, 
// display "Error" in the forecast section.
// Use the following codes for weather symbols:
// •	Sunny			&#x2600; // ☀
// •	Partly sunny	             &#x26C5; // ⛅
// •	Overcast		&#x2601; // ☁
// •	Rain			&#x2614; // ☂
// •	Degrees		&#176;   // °

function attachEvents() {
    let weatherButton = document.getElementById('submit');
    let locationName = document.getElementById('location');
    let currentDiv = document.getElementById('current');
    let upcomingDiv = document.getElementById('upcoming');
    let forecastParentDiv = document.getElementById('forecast');


    const locationsURL = 'https://judgetests.firebaseio.com/locations.json';
    const baseURL = 'https://judgetests.firebaseio.com/forecast/';
    
    const symbols = {
                Sunny: "&#x2600;", // ☀
                "Partly sunny": "&#x26C5;", // ⛅
                Overcast: "&#x2601;", // ☁
                Rain: "&#x2614;", // ☂
                degrees: "&#176;",   // °
    }
    
    weatherButton.addEventListener('click', () => {
        fetch(locationsURL)
            .then(response => response.json())
            .then(data => {
                let {code} = data.find(city => city.name === locationName.value);
                
                let current = fetch(baseURL + `today/${code}.json`)
                            .then(response => response.json());

                let upcomign = fetch(baseURL + `upcoming/${code}.json`)
                            .then(response => response.json());

                Promise.all([current, upcomign])
                    .then(showForcast)
                    .catch(e =>console.log(e));
            });
    });

    function createElement(ele, classes, content) {
        let element = document.createElement(ele);
        element.className = classes;
        element.innerHTML = content;

        return element;
    }
    
    function showForcast([currentData, upcomignData]){
        forecastParentDiv.style.display = 'block';

        showCurrent(currentData);
        showUpcoming(upcomignData);
    }

    function showCurrent(currentData) {
        let forecastDiv = createElement('div', 'forecasts', '');

        let currentSymbol = symbols[currentData.forecast.condition];
        let conditionSymbolSpan = createElement('span', 'condition symbol', currentSymbol)
        
        let conditionInfoSpan = createElement('span', 'condition', '');

        let forecastCitySpan = createElement('span', 'forecast-data', currentData.name);

        let highLow = `${currentData.forecast.low}${symbols.degrees}/${currentData.forecast.high}${symbols.degrees}`;
        let forecastInfoSpan = createElement('span', 'forecast-data', highLow);

        let forecastConditionSpan = createElement('span', "forecast-data", currentData.forecast.condition);

        forecastDiv.appendChild(conditionSymbolSpan);
        currentDiv.appendChild(forecastDiv);
        conditionInfoSpan.appendChild(forecastCitySpan);
        conditionInfoSpan.appendChild(forecastInfoSpan);
        conditionInfoSpan.appendChild(forecastConditionSpan);

        forecastDiv.appendChild(conditionInfoSpan);
    }

    function showUpcoming(upcomingData) {
        let upcomingSpan = createElement('span', 'upcoming', "");
        let forecastInfo = createElement('div', 'forecast-info', '');
        
        upcomingData.forecast.forEach(obj => {
            let conditionSymbolSpan = createElement('span','symbol', symbols[obj.condition]);

            let highLow = `${obj.low}${symbols.degrees}/${obj.high}${symbols.degrees}`;
            let forecastInfoSpan = createElement('span', 'forecast-data', highLow);

            let forecastConditionSpan = createElement('span', "forecast-data", obj.condition);


            upcomingSpan.appendChild(conditionSymbolSpan);
            upcomingSpan.appendChild(forecastInfoSpan);
            upcomingSpan.appendChild(forecastConditionSpan);
            forecastInfo.appendChild(upcomingSpan);
        });

        upcomingDiv.appendChild(forecastInfo);
    }
}

attachEvents(); 