// Your task is to test an object named mathEnforcer, which should have the following functionality: 
// •	addFive(num) - A function that accepts a single parameter:
//      o	If the parameter is NOT a number, the funtion should return undefined.
//      o	If the parameter is a number, add 5 to it, and return the result.
// •	subtractTen(num) - A function that accepts a single parameter:
//      o	If the parameter is NOT a number, the function should return undefined.
//      o	If the parameter is a number, subtract 10 from it, and return the result.
// •	sum(num1, num2) - A function that accepts two parameters:
//      o	If any of the 2 parameters is NOT a number, the function should return undefined.
//      o	If both parameters are numbers, the function should return their sum. 

let mathEnforcer = {
    addFive: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num + 5;
    },
    subtractTen: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num - 10;
    },
    sum: function (num1, num2) {
        if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {
            return undefined;
        }
        return num1 + num2;
    }
};

module.exports = mathEnforcer;