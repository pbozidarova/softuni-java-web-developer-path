import { MOCK } from "./mock-data.js";

(function(data, document) {
    let keys = Object.keys( data[0] );

    let r = "";

    r += "<table>";
    r += "  <thead>";
    r += "      <tr>";
    r += keys.map(key => `<th>${key}</th>`).join('');
    r += "      </tr>";
    r += "  </thead>";
    r += "  <tbody>";
    r += data.map(row => `<tr>${keys.map(cell => 
                                `<td>${row[cell]}</td>`)
                                .join("")}</tr>`
             )
             .join("");
    r += "  </tbody>";
    r += "</table>";
    
    

    
    document.getElementById('app').innerHTML = r;

}(MOCK, document));


