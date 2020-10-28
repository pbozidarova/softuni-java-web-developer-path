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
	titleInputElement.setAttribute('placeholder', 'Ivan Petrov');

	let headingElement = document.createElement('h3');
	headingElement.innerHTML = titleInputElement.value;

	let contentElement = document.createElement('p');
	contentElement.innerHTML = contentInputElement.value	

	let articleElement = document.createElement('article');
	let articleSectionElement = document.getElementById('articles');

	if(titleInputElement.value.length > 0 && contentInputElement.value.length > 0){
		articleElement.appendChild(headingElement);
		articleElement.appendChild(contentElement);
		articleSectionElement.appendChild(articleElement);
	}
	
	titleInputElement.value = '';
	contentInputElement.value = '';

	function deleteArticles(){
		let article = document.getElementById('articles');
		let children = Array.from(articleSectionElement.children);

		children.forEach(x =>{
			if(x.tagName == 'ARTICLE'){
				articleSectionElement.removeChild(x);
			}
		})
	}

}