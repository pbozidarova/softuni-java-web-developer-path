// 9.	Equal Neighbors
// Write a function that finds the number of equal neighbor pairs inside a matrix of variable size and type 
// (numbers or strings).
// The input comes as array of arrays, containing string elements (2D matrix of strings).
// The output is return value of your function. Save the number of equal pairs you find and return it.

function solve(matrix){
    let countEqualPairs = 0;
    for(let i = 0; i < matrix.length; i++){
        for(j = 0; j < matrix[i].length;j++){

            if(i < matrix.length-1){
                if(matrix[i][j] === matrix[i+1][j]){
                    countEqualPairs++;
                }
            }
            
            if( matrix[i][j] === matrix[i][j+1]){
                countEqualPairs++;
            }
           
        }
    }
    console.log(countEqualPairs);
}


solve([['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']]
);

solve([['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']]
)