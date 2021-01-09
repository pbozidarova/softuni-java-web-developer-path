//calculates recursively sum
function sum(numbers, index){
    if(index  === numbers.length){
        return 0;
    }

    return numbers[index] + sum(numbers, index + 1);
}

function solve(){
    const numbers = [1, 2, 3, 4, 5, 6]

    console.log(sum(numbers, 0));
}

solve()