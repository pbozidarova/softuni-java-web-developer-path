// 7.	Magic Matrices
// Write a function that checks if a given matrix of numbers is magical. 
// A matrix is magical if the sums of the cells of every row and every column are equal. 
// The input comes as an array of arrays, containing numbers (number 2D matrix). 
// The input numbers will always be positive.
// The output is a Boolean result indicating whether the matrix is magical or not.

function solve(input){
    let rowSum = 0;
    let prevRowSum = 0;
    let colSum = 0;
    let prevColSum = 0;

    let rowsFlag = true;
    let colsFlag = true;
    
    let count = 0;

    //check if rows sum equals
    input.forEach(row => {
        rowSum = row.reduce((acc, curr) => acc + curr, 0);
        if(count > 0 && rowSum !== prevRowSum){
            rowsFlag = false
        }
        prevRowSum = rowSum;
        count++;
    });

    //check if cols sum equals
    for(let i = 0; i < input[0].length; i++ ){
        colSum = 0;
        for(let j = 0; j < input.length; j++){
            colSum += input[j][i];
        }
        if(i > 0 && colSum !== prevColSum){
            colsFlag = false
        }
        prevColSum = colSum;
    }

    //check if row equals column and print
    console.log(rowsFlag && colsFlag && rowSum === colSum);
}

solve([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
   );

solve([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
   );

solve([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]
   );