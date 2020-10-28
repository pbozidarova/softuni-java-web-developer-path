// 3.	Growing Word
// In this problem, you should create a JS functionality which changes the size and the color of a given paragraph on every click.
// Every time when we click on the [CHANGE] button, the color and the size of the paragraph which contains "Growing Word" should change!
// After every click, the current paragraph font size should be changed to the current font size multiplied by 2. Also, the color of 
// that paragraph should change, depending on the previous color.

function growingWord() {
    let parentElemenet = document.getElementById('exercise');
    let growingWordElement = parentElemenet.lastElementChild;

    let colorElements = document.getElementById('colors');

    if(!growingWordElement.style.fontSize) {
      growingWordElement.style.fontSize = '2px';
    }else{
      growingWordElement.style.fontSize = parseInt(growingWordElement.style.fontSize) * 2 +'px';
    }
    
    let firstColorElement = colorElements.firstElementChild;
    let color = firstColorElement.innerHTML.toLowerCase();
    growingWordElement.style.color = color;

    colorElements.appendChild(firstColorElement)
  }
