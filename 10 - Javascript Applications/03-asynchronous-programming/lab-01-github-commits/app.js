// Write a JS program that loads all commit messages and their authors from a github repository using a given HTML. 
// Skeleton will be provided in the Resources folder.
// The loadCommits() function should get the username and repository from the HTML textboxes with IDs "username" and "repo" and make a 
// GET request to the Github API:
// https://api.github.com/repos/<username>/<repository>/commits
// Swap <username> and <repository> with the ones from the HTML:
// •	In case of success, for each entry add a list item (<li>) in the unordered list (<ul>) with id "commits" with text in the following format:
// "<commit.author.name>: <commit.message>" 
// •	In case of an error, add a single list item (<li>) with text in the following format:
// "Error: <error.status> (<error.statusText>)"

function loadCommits() {
    let username = document.getElementById('username').value;
    let repo = document.getElementById('repo').value;
    
    let commitsElement = document.getElementById('commits');

    fetch(`https://api.github.com/repos/${username}/${repo}/commits`)
        .then(res => res.json())
        .then(commitsData => {
            let commits = commitsData
                    .map(x => `<li>${x.commit.author.name}: ${x.commit.message}</li>`)
                    .join('');
            commitsElement.innerHTML = commits;
        })
        .catch(err => {
            commitsElement.innerHTML = `<li>${err.status} (${err.statusText})</li>`
        });        
}