function solve(){
    
    let elements = [1, 2, 3, 4];
    let used = new Array(elements.length);
    let permutations = new Array(elements.length);
    
    permute(0);
    
    function permute(index){
        if(index >= elements.length) {
            console.log(permutations.join(' '));
            // return;
        }
        for( let i = 0; i < elements.length; i++){
            if(!used[i]){
                let current = elements[i];

                used[i] = true;

                permutations[index] = current;
                permute(index + 1);
                used[i] = false;
            }
        }
    }
}

solve();