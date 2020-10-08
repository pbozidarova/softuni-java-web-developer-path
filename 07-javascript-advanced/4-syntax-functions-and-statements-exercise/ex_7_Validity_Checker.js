// 7.	Validity Checker
// Write a program that receives two points in the format [x1, y1, x2, y2]. Check if the distance between each point and the start of the cartesian coordinate system (0, 0) is valid. A distance between two points is considered valid, if it is an integer value. 
// In case a distance is valid, print"{x1, y1} to {x2, y2} is valid"
// If the distance is invalid, print "{x1, y1} to {x2, y2} is invalid"
// The order of comparisons should always be first {x1, y1} to {0, 0}, then {x2, y2} to {0, 0} and finally {x1, y1} to {x2, y2}. 
// The input consists of two points given as an array of numbers.
// For each comparison print either "{x1, y1} to {x2, y2} is valid" if the distance is valid, or "{x1, y1} to {x2, y2} is invalid" if it is invalid.

function solve(input){
    let x1 = Number(input.shift());
    let y1 = Number(input.shift());
    let x2 = Number(input.shift());
    let y2 = Number(input.shift());

    console.log(`{${x1}, ${y1}} to {0, 0} is ${checkValidity(isValid(x1,y1,0,0))}`);
    console.log(`{${x2}, ${y2}} to {0, 0} is ${checkValidity(isValid(x2,y2,0,0))}`);
    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${checkValidity(isValid(x1,y1,x2,y2))}`);

    function isValid(x1, y1, x2, y2){
        let value = Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2);
        return Number.isInteger(value);
    }

    function checkValidity(validity){
        return validity ? 'valid' : 'invalid';
    }
}




solve([3, 0, 0, 4]);
solve([2, 1, 1, 1]);