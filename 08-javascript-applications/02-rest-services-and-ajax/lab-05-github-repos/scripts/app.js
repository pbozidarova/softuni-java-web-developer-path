// Your task is to write a JS function that executes an AJAX request with Fetch API and loads all user github repositories by a given username 
// (taken from an input field with id "username") into a list (each repository as a list-item) with id "repos". Use the properties full_name 
// and html_url of the returned objects to create a link to each repo’s GitHub page. If an error occurs (like 404 “Not Found”), append to the 
// list a list-item with text the current instead. Clear the contents of the list before any new content is appended. See the highlighted 
// lines of the skeleton for formatting details of each list item.

function loadRepos() {

	
	const httpRequest = new XMLHttpRequest();
	const userElement = document.getElementById('username');
	const reposElement = document.getElementById('repos');
 
	httpRequest.addEventListener('loadend', function() {
		let repos = JSON.parse(this.responseText);
	   
        reposElement.innerHTML = repos.map(x => `<li><a href="${x.html_url}" target="_blank">${x.name}</a></li>`).join('');
	});

	const url = `https://api.github.com/users/${userElement.value}/repos`;

	httpRequest.open('GET', url);
	httpRequest.send();
	
}