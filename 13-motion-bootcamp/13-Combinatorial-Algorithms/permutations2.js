function solve(){
    
    let elements = [1, 2, 3];    
    permute(0);
    
    function permute(index){
        if(index >= elements.length) {
            console.log(elements.join(' '));
            return;
        }
        permute(index + 1);
        for(let i = index + 1; i < elements.length; i++){
            swap(index, i);
            permute(index + 1);
            swap(index, i);
        }
    }

    function swap(first, second) {
        let temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}

solve();