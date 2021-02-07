// 4.	Last K Numbers Sequence
// You are given two integers n and k. Write a JS function that generates and 
// prints the following sequence:
// •	The first element is 1
// •	Every following element equals the sum of the previous k elements
// •	The length of the sequence is n elements
// The input comes as two number arguments. The first element represents the number n, 
// and the second – the number k.
// The output is printed on the console on a single line, separated by space.

// Explanation
// The 2nd element (1) is the sum of the 3 elements before it, but there is only 1, 
// so we take that. The third element is the sum of the first 2 (1 and 1) and the 4th – 
// the sum of 1, 1 and 2. The 5th element is the sum of the 2nd, 3rd and 4th (1, 2 and 4) 
// and so on.


function solve(n, k){
    let resultArr = [1];
    while (resultArr.length < n && k > 0){
        let element = 0;
        for(j = 0; j < k; j++){
            if (resultArr.length-j-1 < 0) {break};
            element += resultArr[resultArr.length-j-1];
        }   
        resultArr.push(element)
    }
    console.log(resultArr.join(' '));
}

solve(10, 0);
solve(8, 2);