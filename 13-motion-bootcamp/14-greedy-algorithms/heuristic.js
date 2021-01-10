function setCoverProblem(){

    const universe = [1, 2, 3, 4, 5, 6,];
    const sets = [[1, 2], [2, 3, 4], [1, 7, 8, 9, 11], [3, 4], [1, 2, 3, 4, 5]];

    while(sets.length > 0){
        let  currentSet = sets.sort((a, b) => {
            let aSum = 0;
            let bSum = 0;
            a.forEach(el => {if(universe.indexOf(el) >= 0) aSum++});
            b.forEach(el => {if(universe.indexOf(el) >= 0) bSum++});
            return aSum - bSum;
            })
            .pop();
            console.log(currentSet);
    }
}

setCoverProblem()