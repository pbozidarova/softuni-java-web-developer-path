const elements = {
    input: () => document.querySelector('input#towns'),
    button: () => document.querySelector('button#btnLoadTowns'),
    root: () => document.querySelector('div#root')
}

elements.button().addEventListener('click', fetchCountries);

const BASE_URL = "https://restcountries.eu/rest/v2/all"

function fetchCountries(e){
    fetch(BASE_URL)
        .then(r => r.json())
        .then(appendTowns);
}

function appendTowns(towns) {
    getTemplate()
        .then(templateSource => {
            const template = Handlebars.compile(templateSource);
            const htmlResult = template({ towns });
            elements.root().innerHTML = htmlResult;
        }); 
}   

function getTemplate() {
    return fetch('./templates.hbs')
                .then(r => r.text());

}