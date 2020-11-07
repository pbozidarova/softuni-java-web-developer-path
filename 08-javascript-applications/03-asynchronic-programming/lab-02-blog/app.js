// Write a program for reading blog content. It needs to make requests to the server and display all blog posts and their comments.
// Firebase URL - https://blog-apps-c12bf.firebaseio.com/
// Skeleton will be provided in the Resources folder.
// The button with ID "btnLoadPosts" should make a GET request to "/posts". 
// The response from the server will be an Object of objects.
// Each object will be in the following format:
// {
//   body: {postBody},
//   id: {postId},
//   title: {postTitle} 
// }
// Create an <option> for each post using its object key as value and current object title property as text inside the node with ID "posts". 

// When the button with ID "btnViewPost" is clicked, a GET request should be made to:
// •	"/posts/{postId}" to obtain the selected post (from the dropdown menu with ID "posts") - The following request will return a 
// single object as described above.
// •	"/comments - to obtain all comments. The request will return a Object of objects.
 
// Each object will be in the following format: 
// { 
//   	id: {commentId},
//   	postId: {postId},
//   	text: {commentText}
// }
// You have to find this comments that are for the current post (check the postId property)
// Display the post title inside h1 with ID "post-title" and the post content inside ul with ID "post-body". Display each comment as 
// a <li> inside ul with ID "post-comments". Do not forget to clear its content beforehand.

const baseUrl = 'https://blog-apps-c12bf.firebaseio.com/'

function attachEvents() {
    let loadPostsElement = document.getElementById('btnLoadPosts');
    let postsElement = document.getElementById('posts');
    let viewPosts = document.getElementById('btnViewPost');

    loadPostsElement.addEventListener('click', () => {
        fetch(`${baseUrl}/posts.json`)
            .then(res => res.json())
            .then(data => {
                let options = Object.keys(data).map(key => `<option value="${key}">${data[key].title}</option>`).join('');
                    postsElement.innerHTML = options
            }); 
    });

    // viewPosts.addEventListener('click', (e) => {
    //     let postValue = document.querySelector('#posts option:checked').value;
        

    //     console.log(postValue);
    //     console.log(`${baseUrl}/posts.json/${postValue}/`);
    //     fetch(`${baseUrl}/posts.json/${postValue}/`)
    //          .then(res => res.json())
    //          .then(data => {
    //              document.getElementById('post-title').value = data.title;
    //          })
            
    // });

}



attachEvents();