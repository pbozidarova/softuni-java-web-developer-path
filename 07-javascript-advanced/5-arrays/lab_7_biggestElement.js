// 7.	Biggest Element
// Write a function that finds the biggest element inside a matrix.
// The input comes as array of arrays, containing number elements (2D matrix of numbers).
// The output is the return value of your function. Find the biggest element and return it.//

function solve(matrix){
    let maxNumber = Number.MIN_SAFE_INTEGER; 

    matrix.forEach(row => {
        let currentMax = Number.MIN_SAFE_INTEGER;
        row.forEach(num => {
            if(currentMax < num){
                currentMax = num;
            }
        });
        if (maxNumber < currentMax) {
            maxNumber = currentMax;
        }
    });
    console.log(maxNumber);
}

function solve2(matrix){
    let maxNumbers = matrix
            .map(row => Math.max(...row));

    console.log(Math.max(...maxNumbers));
}

solve2([[20, 50, 10],
    [8, 33, 145]]
    );

solve([[3, 5, 7, 12],
        [-1, 4, 33, 2],
        [8, 3, 0, 4]]
       );