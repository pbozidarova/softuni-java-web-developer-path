// You will receive an array of strings. For each string, create a div with a paragraph with the string in it. 
// Each paragraph is initially hidden (display:none). Add a click event listener to each div that displays the hidden paragraph. 
// Finally, you should append all divs to the element with an id "content".

function create(words) {
   let content = document.getElementById('content');

   words.forEach(word => {
      let div = document.createElement('div');
      let p = document.createElement('p');
      p.textContent = word;
      p.style.display = 'none';

      div.addEventListener('click', () => {
         p.style.display = 'block';
      })

      div.appendChild(p);
      content.appendChild(div)
   });
   
}