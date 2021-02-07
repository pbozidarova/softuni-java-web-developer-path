// Write a function that adds a number passed to it to an internal sum and returns itself with its internal sum set to the new value, 
// so it can be chained in a functional manner. 

function add(x){

    function sum(a){
        x += a;
        return sum;
    }

    sum.toString = () => x;

    return sum;
}

add(1) (5) (-3);
