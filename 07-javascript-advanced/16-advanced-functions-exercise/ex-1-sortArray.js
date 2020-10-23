// Write a function that sorts an array with numeric values in ascending or descending order, depending on an argument that is passed to it. 
// You will receive a numeric array and a string as arguments to the first function in your code. 
// •	If the second argument is asc, the array should be sorted in ascending order (smallest values first).
// •	If it is desc, the array should be sorted in descending order (largest first).


function solve(input, criteria){

    let sortFunction = {
        asc: function(arr){
            return arr.sort((a,b) => a - b);
        },
        desc: function(arr) {
            return arr.sort((a,b) => b - a);
        }
    }

    let func = sortFunction[criteria];
    return func(input);
}

solve([14, 7, 17, 6, 8], 'asc');
solve([14, 7, 17, 6, 8], 'desc')