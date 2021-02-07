// Write a function that has the functionality of a quiz. 
// There are three sections that contain one question and 2 possible answers. 
// The right answer is only one! 
// When one of the list elements is clicked, the next section must appear (if any…).
// After all three questions have been answered, the result div must appear. (Use 'none' and 'block' to hide and show the 
// question sections)
// If all questions are answered correctly, you should prin the following message: 
// "You are recognized as top JavaScript fan!"
// Otherwise, just print "You have {rightAnswers} right answers".
// The right answers are (onclick, JSON.stringify() and A programming API for HTML and XML documents).

function solve() {
  let sections = document.querySelectorAll('section');

  let ans = ['onclick', 'JSON.stringify()','A programming API for HTML and XML documents'];
  
  sections.forEach( (section, i) => {
                                  section.querySelectorAll('.answer-wrap')
                                          .forEach( li => li.addEventListener('click', e => {
                                    
                                    let index = ans.indexOf(e.target.innerText);
                                    
                                    if (index >= 0) ans.splice(index, 1);
                                    section.style.display = 'none'; 
                                    
                                    if(sections[i+1]  ) {
                                      sections[i+1].style.display = 'block';
                                    } else {
                                      document.getElementById('results').style.display = 'block';
                                      let outputText = '';
                                      ans.length ?  outputText = `You have ${3 - ans.length} right answers`
                                                  : outputText = "You are recognized as top JavaScript fan!" ;

                                      document.querySelector('.results-inner h1').innerText = outputText;  
                                    }

                                  }));
                                });

}
