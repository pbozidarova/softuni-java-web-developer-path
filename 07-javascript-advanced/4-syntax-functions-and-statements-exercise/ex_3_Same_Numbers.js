// Write a function that takes an integer number as an input and check if all the digits in a given number are the same or not.
// Print on the console true if all numbers are same and false if not. On the next line print the sum of all digits.
// The input comes as an integer number.
// The output should be printed on the console.

function solve(number){

    let sum = 0;
    let lastDigit = number % 10;
    let isEqual = true;

    while (number / 10 > 0 ) {
        let digit = number % 10;
        sum += digit;

        if(digit !== lastDigit) {
            isEqual = false;
        }
        lastDigit = digit;
        number = Math.floor(number/10);
    }    

    console.log(isEqual)
    console.log(sum)

}

function solve2(number) {

    number = number.toString();
    let flag = true;
    for(let i = 0; i < number.length; i++){
        for(let j = i + 1; j < number.length; j++) {
            if(number[i] != number[j]){
                flag = false;
                break;
            }
        }
    }

    console.log(flag);
    console.log(number.toString()
                        .split('')
                        .map(Number)
                        .reduce((a, b) => a+b, 0));

}

solve(2222222);
solve(1234);

solve2(2222222);
solve2(1234);











