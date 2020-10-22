// Write a JS function that when called, returns the next Fibonacci number, starting at 0, 1. Use a closure to keep the current number.

function getFibonator(){
    let currnetNum = 0;
    let nextNum = 1;

    function fibonacci(){
        let fibNum = currnetNum + nextNum;
        currnetNum = nextNum;
        nextNum = fibNum;
        
        return currnetNum;
    }
   return fibonacci;
}

function solve(){
    let fib = getFibonator();
    console.log(fib()); // 1
    console.log(fib()); // 1
    console.log(fib()); // 2
    console.log(fib()); // 3
    console.log(fib()); // 5
    console.log(fib()); // 8
    console.log(fib()); // 13
}

solve();
