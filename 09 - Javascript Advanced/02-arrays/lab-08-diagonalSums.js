// 8.	Diagonal Sums
// A square matrix of numbers comes as an array of strings, each string holding numbers (space separated). 
// Write a function that finds the sum at the main and at the secondary diagonals.
// The input comes as array of arrays, containing number elements (2D matrix of numbers).
// The output is printed on the console, on a single line separated by space. 
// First print the sum at the main diagonal, then the sum at the secondary diagonal.

function solve(input){
    console.log(mainDiagonalSum(input) + ' ' + secodaryDiagonalSum(input));
    
    function mainDiagonalSum(matrix){
        let sum = 0;
        for(let i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }

    function secodaryDiagonalSum(matrix){
        let sum = 0;
        for(let i = matrix.length-1; i >= 0; i--){
            sum += matrix[i][matrix.length-1-i];
        }
        return sum;
    }
}

solve([[20, 40],
    [10, 60]] );

   solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
   );