// 1.	Sum First Last
// Write a function that calculates and prints the sum of the first and the last elements in an array.
// The input comes as array of string elements holding numbers.
// The output is the return value of your function.

function solve(numbers) {
    let firstElement = Number(numbers[0]);
    let lastElement = Number(numbers[numbers.length - 1]);

    console.log(firstElement + lastElement);
}   

solve(['20', '30', '40']);
solve(['5', '10']);