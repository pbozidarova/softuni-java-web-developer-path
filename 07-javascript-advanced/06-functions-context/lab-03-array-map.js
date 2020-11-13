// Write a function that takes 2 parameters (array and a function) that uses .reduce() to implement a simple version of .map().

function arrayMap(arr, func){
    return arr.reduce(function(acc, x){
        acc.push(func(x));
        return acc;
    }, []);
}

let mappedArray = arrayMap([1,2,3], x => x*2);

console.log(mappedArray.join(' '));