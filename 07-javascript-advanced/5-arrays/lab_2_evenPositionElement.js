// 2.	Even Position Element
// Write a function that finds the elements at even positions in an array.
// The input comes as array of string elements.
// The output is the return value of your function. Collect all elements in a string, separated by space.

function solve(numbers){
    let result = [];
    for(let i = 0; i < numbers.length; i++ ) {
        if(i % 2 === 0) {
            result.push(numbers[i]);
        }
    }
    console.log(result.join(' '));
}

solve(['20', '30', '40']);