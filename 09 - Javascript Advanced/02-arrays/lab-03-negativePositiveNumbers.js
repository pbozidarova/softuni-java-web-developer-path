// 3.	Negative / Positive Numbers
// Write a JS function that processes the elements in an array one by one and produces 
// a new array. Prepend each negative element at the front of the result and append each positive (or 0) 
// element at the end of the result.
// The input comes as array of number elements.
// The output is printed on the console, each element on a new line.

function solve(input){
    
    let output = [];
    input.forEach(el => {
        if(el >= 0){
            output.push(el);
        }else{
            output.unshift(el);
        }

    });

    output.forEach(el => {console.log(el)});
}

solve([7, -2, 8, 9]);
solve([3, -2, 0, -1]);