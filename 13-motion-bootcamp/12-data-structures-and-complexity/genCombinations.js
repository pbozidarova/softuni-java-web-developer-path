//Generate combinations of 0/1 for array with given length
function generate(index, arr){

    if(index == arr.length ){
        console.log(arr.join(' '));
        return;
    }

    for(let i = 0; i <=1; i++){
        arr[index] = i;
        generate(index + 1, arr);
    }
    
}

let arr = new Array(3);

generate(0, arr.fill('', 0, 3));