// In this problem, you should create a JS functionality which formats the given text into paragraphs.
// When the [Format] button is clicked, you need to format the text inside the paragraph with an id "input". 
// The formatting is done as follows:
// •	You need to create a new paragraph element which holds no more than 3 sentences from the given input.
// •	If the given input contains less or 3 sentences, you need to create only 1 paragraph, fill it with these sentences 
// and append this paragraph to the div with an id "output". 
// Otherwise, when you have more than 3 sentences in that input paragraph, you need to create enough paragraphs to get all 
// sentences from the input text.
// Just remember to restrict the sentences in each paragraph to 3.

function solve() {
  let text = document.getElementById('input').innerText;
  let outputElement = document.getElementById('output');
  

  let sentences = text.split('.');

  while(sentences.length > 0){
      let currentParagraph = sentences.splice(0, 3).join('.') + '.';
      
      let paragraphElement = document.createElement('p');
      paragraphElement.innerText = currentParagraph;

      outputElement.appendChild(paragraphElement);
    }
}