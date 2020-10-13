// 4.	From JSON to HTML Table
// You’re tasked with creating an HTML table of students and their scores. 
// You will receive a single string representing an array of objects, the table’s headings 
// should be equal to the object’s keys, while each object’s values should be a new 
// entry in the table. Any text values in an object should be escaped, in order to avoid 
// introducing dangerous code into the HTML. 

function solve(input){
    //let jsonData = input.shift();
    let html = '<table>';

    input.forEach(el => {
        student = JSON.parse(el);
        html += `<tr>${Object.keys(student).map(x => `<th>${x}</th>`).join('')}</tr>`;
        html += `<tr>${Object.values(student).map(x => `<td>${x}</td>`).join('')}</tr>`
    });

    html += '</table>'

    console.log(html);
}

solve(['[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]']);
solve(['[{"Name":"Pesho <div>-a","Age":20,"City":"Sofia"},{"Name":"Gosho","Age":18,"City":"Plovdiv"},{"Name":"Angel","Age":18,"City":"Veliko Tarnovo"}]']
);