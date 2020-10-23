// Write a JS program that sequentially displays articles on a web page when the user clicks a button. You will receive an array of strings 
// that will initialize the program. You need to return a function that keeps the initial array in its closure and every time it’s called, it
// takes the first element from the array and displays it on the web page, inside a div with ID "content". If there are no more elements left, 
// your function should do nothing.
// HTML and JavaScript Code
// You are given the HTML code.
// Your function will be called automatically, there is no need to attach any event listeners.


function getArticleGenerator(articles){
    let content = document.getElementById('content');

    function showNext(){
        if(articles.length > 0){
            let div = document.createElement('article');
            div.textContent = articles.shift();

            content.appendChild(div);
        }
    }

    return showNext;
}
