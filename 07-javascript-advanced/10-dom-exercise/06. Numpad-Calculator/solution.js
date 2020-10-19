// Write a function that implements a calculator that has the following functionalities:
// When one of the buttons is clicked, its value should be shown in the "Expression" field (#expressionOutput).
// For instance, if we click on the button with value 9.
// If the current Expression field (#expresisonOutput) contains the whole math expression (left operand, operator and right operand:
// Example: 9 + 2),
// When the equal sign "=" is pressed, the result of that expression should appear in the Result field (#resultOutput)
// Otherwise, if we create an invalid expression such as "99 +" (without second/right operand) and we hit the equal sign "="

// The "Clear" button should clear both Expression and Result fields (#expressionOutput and #resultOutput)

function solve() {
  let expression = document.getElementById("expressionOutput");
  let result = document.getElementById("resultOutput");

  document.querySelector(".keys").addEventListener("click", symbolClicked);
  document.querySelector(".clear").addEventListener("click", clear);

  function clear() {
    expression.textContent = "";
    result.textContent = "";
  }

  function symbolClicked(event) {
    let buttonPressed = event.target.value;
    switch (buttonPressed) {
      case "/":
      case "*":
      case "+":
      case "-":
        expression.textContent += ` ${buttonPressed} `;
        break;
      case "=":
        let [ leftOperand, operator, rightOperand] = expression.textContent.split(" ");
        leftOperand = Number(leftOperand);
        rightOperand = Number(rightOperand);
    
        if (!rightOperand || !operator) {
          result.textContent = "NaN";
        } else {
          result.textContent = calculateResult(leftOperand, rightOperand, operator);
        }
        break;
      default:
        expression.textContent += buttonPressed;
    }
  }

  function calculateResult(leftOperand, rightOperand, operator){
    switch (operator) {
        case "*":
          return leftOperand * rightOperand;
        case "/":
          return leftOperand / rightOperand;
        case "+":
          return leftOperand + rightOperand;
        case "-":
          return leftOperand - rightOperand;
      }
  }
}
