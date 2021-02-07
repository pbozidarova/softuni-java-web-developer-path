// 6.	Smallest Two Numbers
// Write a function that prints the two smallest elements from an array of numbers.
// The input comes as array of number elements.
// The output is printed on the console on a single line, separated by space.


function solve(input){

    let output = [];
    let n = 0; //the smallest two numbers
    while(n < 2){
        let minNumber = Math.min(...input);
        output.push(minNumber);
        input.splice(input.indexOf(minNumber), 1);
        n++;
    }
    console.log(output.join(' '));
}


solve([30, 15, 50, 5]);
solve([3, 0, 10, 4, 7, 3]);