// Constraints:
// •	Title value from the title input should be a heading 3 element <h3>
// •	Content text from the textarea element should be a paragraph <p>
// •	Both new created elements (h3 and p) should be appended to a new article element <article>
// •	The current article element should be appended to the section which has an id articles (#articles)
// •	You should create new article element only if title and content are not empty
// •	After the button is pressed you must clear the title value and text value

function createArticle() {
	
	let titleInputElement = document.getElementById('createTitle');
	let contentInputElement = document.getElementById('createContent');

	let headingElement = document.createElement('h3');
	headingElement.innerHTML = titleInputElement.value;
	titleInputElement.value = '';

	let contentElement = document.createElement('p');
	contentElement.innerHTML = contentInputElement.value
	contentInputElement.value = '';

	let articleElement = document.createElement('article');
	articleElement.appendChild(headingElement);
	articleElement.appendChild(contentElement);

	let articleSectionElement = document.getElementById('articles');
	articleSectionElement.appendChild(articleElement);

}