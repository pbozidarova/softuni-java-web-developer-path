// Write a program that keeps a number inside its context and returns new function that adds a given number to the previous one.

function solution(num){
    let number = num;

    return function(secondNum){
        return secondNum + number;
    }
}


let add5 = solution(5);
console.log(add5(2));
console.log(add5(3));
