// 11.	*Spiral Matrix
// Write a JS function that generates a Spirally-filled matrix with numbers, 
// with given dimensions.
// The input comes as 2 numbers that represent the dimension of the matrix. 
// The output is the matrix filled spirally starting from 1. You need to print 
// every row on a new line, with the cells separated by a space. Check the examples below. 


function solve(rows, cols){

    //initialising the needed variables
    let [count, maxCount, minRow, minCol, maxRow, maxCol] = [0, rows * cols, 0, 0, rows-1, cols-1];
    //declaring the matrix and creating empty arrays to fill them up
    let matrix = [];
    for (let r = 0; r < rows; r++) matrix[r] = [];
    //starting a while cycle to break it when the matrix is filled
    while (count < maxCount) {
        //going right
        for (let c = minCol; c <= maxCol && count < maxCount; c++)	matrix[minRow][c] = ++count;
        //marking one less row, so that for the next iteration the cycle will start to fill the matrix from the second row
        minRow++;
        //going down
        for (let r = minRow; r <= maxRow && count < maxCount; r++)	matrix[r][maxCol] = ++count;
        maxCol--;
        //going left
        for (let c = maxCol; c >= minCol && count < maxCount; c--)	matrix[maxRow][c] = ++count;
        maxRow--;
        //going up
        for (let r = maxRow; r >= minRow && count < maxCount; r--)	matrix[r][minCol] = ++count;
        minCol++;
    }

    matrix.forEach(row => {console.log(row.join(' '))});

}

solve(5, 5);

solve(3, 3);
