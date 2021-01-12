let htmlSelectors = {
    'loadButton': () => document.getElementById('loadStudentsBtn'),
    'studetnsTable': () => document.querySelector('#results tbody'),
    'createStudentButton': () => document.querySelector('#create-student button'),
    'firstName': () => document.getElementById('first-name'),
    'lastName': () => document.getElementById('last-name'),
    'facultyNumber': () => document.getElementById('faculty-number'),
    'averageGrade': () => document.getElementById('avg-grade'),
}

htmlSelectors['loadButton']().addEventListener('click', fetchTheStudents);
htmlSelectors['createStudentButton']().addEventListener('click', createStudents);

function fetchTheStudents() {
    fetch('https://students-13cb7.firebaseio.com/students/.json')
        .then(res => res.json())
        .then(populateTheStudents)
        .catch(errorHandler);
}

function populateTheStudents(students) {
    let studentsTable = htmlSelectors['studetnsTable']();
    
    if(studentsTable.innerHTML != '') {
        studentsTable.innerHTML = '';
    }

    if(students){
        Object.keys(students)
        .forEach(studentId => {
            const {id, firstName, lastName, facultyNumber, averageGrade} = students[studentId];

            const tableRow = createDOMelement('tr', '', {}, {}, 
                                        createDOMelement('td', id, {}, {}),    
                                        createDOMelement('td', firstName, {}, {}),    
                                        createDOMelement('td', lastName, {}, {}),    
                                        createDOMelement('td', facultyNumber, {}, {}),    
                                        createDOMelement('td', averageGrade, {}, {}),    
            )

            studentsTable.appendChild(tableRow);
        })
    }
}

function createStudents(e) {
    e.preventDefault();
    
    let id;

    fetch('https://students-13cb7.firebaseio.com/students/.json')
                .then(res => res.json())
                .then(data => {
                    if(data){
                        id = Object.keys(data).length +1;
                        return id;
                    } else {
                        return id = 1;
                    }
                })
                .then(id => {
                   let initObj = {
                            method: "POST",
                            body: JSON.stringify({
                                "id": id,
                                "firstName": htmlSelectors['firstName']().value,
                                "lastName": htmlSelectors['lastName']().value,
                                "facultyNumber": htmlSelectors['facultyNumber']().value,
                                "averageGrade": htmlSelectors['averageGrade']().value,
                            })
                    }
                    fetch('https://students-13cb7.firebaseio.com/students/.json', initObj)
                        .then(res => {
                                console.log(res)
                                fetchTheStudents();
                                htmlSelectors['firstName']().value = '';
                                htmlSelectors['lastName']().value = '';
                                htmlSelectors['facultyNumber']().value = '';
                                htmlSelectors['averageGrade']().value = '';
                        })
                        .catch(errorHandler); 
                });

}

function errorHandler(err) {
    console.log(err);
}

function createDOMelement(type, text, attributes, events, ...children) {
    let domElement = document.createElement(type);

    if(text !== '') {
        domElement.textContent = text;
    }

    Object.entries(attributes)
                .forEach(([attrKey, attrValue]) => {
                    domElement.setAttribute(attrKey, attrValue);
                });

    Object.entries(events)
                .forEach(([eventName, eventHandler]) => {
                    domElement.addEventListener(eventName, eventHandler);
                });

    children.forEach(child => domElement.appendChild(child));

    return domElement;
}   