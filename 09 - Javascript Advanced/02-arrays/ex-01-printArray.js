// 1.	Print an Array with a Given Delimiter
// The input comes as an array of strings. The last element of the array is the delimiter.
// The output is the same array, printed on the console, each element separated from 
// the others by the given delimiter.

function solve(input){
    let delimiter = input.pop();

    console.log(input.join(delimiter));
}

solve(['One', 
'Two', 
'Three', 
'Four', 
'Five', 
'-']
);

solve(['How about no?', 
'I',
'will', 
'not', 
'do', 
'it!', 
'_']
);