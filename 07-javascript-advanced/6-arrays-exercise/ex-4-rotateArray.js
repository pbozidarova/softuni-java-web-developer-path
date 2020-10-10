// 4.	Rotate Array
// Write a JS function that rotates an array. The array should be rotated to the right side, 
// meaning that the last element should become the first, upon rotation. 
// The input comes as an array of strings. The last element of the array is the amount 
// of rotation you need to perform.
// The output is the resulted array after the rotations. The elements should be printed 
// on one line, separated by a single space.

function solve(input){
    let count = input.pop();
    for(let i = 0; i < count % input.length ; i++) {
        input.unshift(input.pop());
    }
    console.log(input.join(' '));
}   

solve(['1', '2', '3', '4', '2']);

solve(['Banana', 'Orange', 'Coconut', 'Apple', '15']);