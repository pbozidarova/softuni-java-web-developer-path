function genCombs(set, vector, index, border){

    if(index >= vector.length){
        console.log(vector);
        return;
    }
    for( let i = border; i < set.length; i++ ){
        vector[index] = set[i];
        genCombs(set, vector, index + 1, i + 1);
    }

}

let set = [1, 2, 3, 4];
let vector = new Array(2)

genCombs( set, vector, 0, 0 );