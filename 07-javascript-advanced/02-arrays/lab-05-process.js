// 5.	Process Odd Numbers
// You are given an array of numbers. Write a JS function that prints 
// the elements at odd positions from the array, doubled and in reverse order.
// The input comes as array of number elements.
// The output is printed on the console on a single line, separated by space.

function solve(numbers){
    let result = numbers
        .filter((x, i) => i % 2 != 0 )
        .map(x => x*2)
        .reverse()
        .join(' ');

    console.log(result);
}

solve([10, 15, 20, 25]);
solve([3, 0, 10, 4, 7, 3]);