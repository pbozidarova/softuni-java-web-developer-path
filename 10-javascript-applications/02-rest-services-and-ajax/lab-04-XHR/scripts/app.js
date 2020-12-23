// Your task is to write a JS function that loads a github repository asynchronously with AJAX. You should create an instance of XmlHttpRequest and attach an 
// onreadystatechange event to it. (An EventHandler that is called whenever the readyState attribute changes). In your event handler, when the readyState attribute 
// reaches a value of 4 (it is ready), replace the text content of a div element with id "res" with the value of the responseText property of the request. 
// Do not format the response in any way.

function loadRepos() {
   
   const url = 'https://api.github.com/users/testnakov/repos';
   const httpRequest = new XMLHttpRequest();
   const resElement = document.getElementById('res');

   httpRequest.addEventListener('loadend', function() {
      let repos = JSON.parse(this.responseText);
      console.log(repos);
      resElement.innerHTML = repos.map(x => `<p><a href="${x.html_url}" target="_blank">${x.name}</a></p>`).join('');
   });

   httpRequest.open('GET', url);
   httpRequest.send();
}