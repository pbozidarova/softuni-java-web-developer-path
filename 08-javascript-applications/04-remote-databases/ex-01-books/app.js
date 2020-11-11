const htmlSelectors = {
    'loadBooks': () => document.getElementById('loadBooks'),
    'createBtn': () => document.querySelector('#create-form button'),
    'createTitleInput': () => document.getElementById('create-title'),
    'createAuthorInput': () => document.getElementById('create-author'),
    'createISBNInput': () => document.getElementById('create-isbn'),
    'booksContainer': () => document.querySelector('table > tbody'),
    'errorContainer': () => document.getElementById('error-notification'),

    'editForm': () => document.getElementById('edit-form'),
    'editBtn': () => document.querySelector('#edit-form button'),
    'editTitleInput': () => document.getElementById('edit-title'),
    'editAuthorInput': () => document.getElementById('edit-author'),
    'editIsbnInput': () => document.getElementById('edit-isbn'),

    'deleteForm': () => document.getElementById('delete-form'),
    'deleteBtn': () => document.querySelector('#delete-form button'),
    'deleteTitleInput': () => document.getElementById('delete-title'),
    'deleteAuthorInput': () => document.getElementById('delete-author'),
    'deleteIsbnInput': () => document.getElementById('delete-isbn'),
}

htmlSelectors['loadBooks']().addEventListener('click', fetchAllBooks);
htmlSelectors['createBtn']().addEventListener('click', createBook);
htmlSelectors['editBtn']().addEventListener('click', editBook);
htmlSelectors['deleteBtn']().addEventListener('click', deleteBookById);

function fetchAllBooks(){
    fetch('https://books-76f9b.firebaseio.com/Books/.json')
        .then(res => res.json())
        .then(renderBooks)
        .catch(handleError)
}

function renderBooks(booksData) {
    const booksContainer = htmlSelectors['booksContainer']();

    if(booksContainer.innerHTML != '') {
        booksContainer.innerHTML = '';
    }

    Object.keys(booksData)
        .forEach(bookId => {
            const {title, author, isbn} = booksData[bookId];
            
            const tableRow = createDomElement('tr', '', {}, {},
                                    createDomElement('td', title, {}, {}),
                                    createDomElement('td', author, {}, {}),
                                    createDomElement('td', isbn, {}, {}),
                                    createDomElement('td', '', {}, {}, 
                                        createDomElement('button', 'Edit', { 'data-key': bookId }, { click: loadEditForm }),
                                        createDomElement('button', 'Delete', { 'data-key': bookId }, { click: loadDeleteForm })
                                    )
            );
            booksContainer.appendChild(tableRow);
        });
}

function createBook(e){
    e.preventDefault();
    
    const titleInput = htmlSelectors['createTitleInput']();
    const authorInput = htmlSelectors['createAuthorInput']();
    const isbnInput = htmlSelectors['createISBNInput']();

    if(titleInput.value !== '' && authorInput.value !== '' && isbnInput.value !== ''){
        const initObj = {
            method: 'POST',
            header: {
                'Content Type': 'application/json'
            },
            body: JSON.stringify({title: titleInput.value, 
                                    author: authorInput.value, 
                                    isbn: isbnInput.value})
        }

        fetch('https://books-76f9b.firebaseio.com/Books/.json', initObj)
            .then(fetchAllBooks)
            .catch(handleError);
                    
        titleInput.value = '';
        authorInput.value = '';
        isbnInput.value = '';
    } else {
        const error = { message: ''};
    
        if(titleInput.value === '') error.message += 'Title cannot be empty!';
        if(authorInput.value === '') error.message += 'Author cannot be empty!';
        if(isbnInput.value === '') error.message += 'ISBN cannot be empty!';
        
        handleError(error);
    }
}

function loadEditForm() {
    const id = this.getAttribute('data-key');
    
    fetch(`https://books-76f9b.firebaseio.com/Books/${id}.json`)
        .then(res => res.json())
        .then(({title, author, isbn}) => {
            htmlSelectors['editTitleInput']().value = title;
            htmlSelectors['editAuthorInput']().value = author;
            htmlSelectors['editIsbnInput']().value = isbn;
            htmlSelectors['editForm']().style.display = 'block';
            htmlSelectors['editBtn']().setAttribute('data-key', id);
        })
        .catch(handleError);
}

function loadDeleteForm() {
    const id = this.getAttribute('data-key');
    
    fetch(`https://books-76f9b.firebaseio.com/Books/${id}.json`)
        .then(res => res.json())
        .then(({title, author, isbn}) => {
            

            htmlSelectors['deleteTitleInput']().value = title;
            htmlSelectors['deleteAuthorInput']().value = author;
            htmlSelectors['deleteIsbnInput']().value = isbn;
            htmlSelectors['deleteForm']().style.display = 'block';
            htmlSelectors['deleteBtn']().setAttribute('data-key', id);
        })
        .catch(handleError);
}

function editBook(e) {
    e.preventDefault();

    const titleInput = htmlSelectors['editTitleInput']();
    const authorInput = htmlSelectors['editAuthorInput']();
    const isbnInput = htmlSelectors['editIsbnInput']();

    
    if(titleInput.value !== '' && authorInput.value !== '' && isbnInput.value !== ''){
        
            const id = this.getAttribute('data-key');
            const initObj = {
                method: 'PATCH',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({title:titleInput.value, author: authorInput.value, isbn:isbnInput.value})
            }
            htmlSelectors['editForm']().style.display = 'none';
            fetch(`https://books-76f9b.firebaseio.com/Books/${id}/.json`, initObj)
                .then(fetchAllBooks)
                .catch(handleError);
    } else {
        const error = { message: ''};
    
        if(titleInput.value === '') error.message += 'Title cannot be empty!';
        if(authorInput.value === '') error.message += 'Author cannot be empty!';
        if(isbnInput.value === '') error.message += 'ISBN cannot be empty!';
        
        handleError(error);
    }


}

function deleteBookById(e) {
    e.preventDefault();
    const id = this.getAttribute('data-key');

    const initObj = {
        method: 'DELETE'
    }

    htmlSelectors['deleteForm']().style.display = 'none'
    fetch(`https://books-76f9b.firebaseio.com/Books/${id}/.json`, initObj)
        .then(fetchAllBooks)
        .catch(handleError);
}

function handleError(err){
    let errorContainer = htmlSelectors['errorContainer']();
    errorContainer.style.display = 'block';
    errorContainer.textContent = err.message;
    
    setTimeout(() => {
        errorContainer.style.display = 'none'
    }, 5000);
}


function createDomElement(type, text, attributes, events, ...children){
    const domElement = document.createElement(type);

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
    children.forEach(child => {
        domElement.appendChild(child);
    });

    return domElement;
}