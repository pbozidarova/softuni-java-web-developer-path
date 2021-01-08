function solve() {

    let cells = document.querySelectorAll('tbody td');
    let rows = document.querySelectorAll('tbody tr');
    
    let [quickCheck, clear] = document.querySelectorAll('button');
    
    let successBorder = '2px solid green';
    let failBorder = '2px solid red';

    const SUMROWCOLUMN = 6;

    quickCheck.addEventListener('click', e => {
        let flag = true;
        let rowMatrix = [];

        rows.forEach( row => {
            let rowCells = [];
            row.querySelectorAll('input').forEach(cell => rowCells.push(Number(cell.value)));

            rowMatrix.push(rowCells);
        });
        
        for( row = 0; row < rowMatrix.length; row++){
            let rowSum = 0;
            for( col = 0; col < rowMatrix[row].length; col ++){
                rowSum += rowMatrix[row][col];
            }
            if(rowSum != SUMROWCOLUMN) {
                flag = false;    
                break;
            }        
        }

        for( col = 0; col < rowMatrix[0].length; col++){
            let colSum = 0;
            for(row = 0; row < rowMatrix.length; row++) {
                colSum += rowMatrix[row][col];
            }
            if(colSum != SUMROWCOLUMN) {
                flag = false;    
                break;
            }
        }

        if(flag){
            document.getElementById('check').innerHTML = '<p>You solve it! Congratulations!</p>';
            document.querySelector('table').style.border = successBorder;
        }else {
            document.getElementById('check').innerHTML = '<p>NOP! You are not done yet…</p>';
            document.querySelector('table').style.border = failBorder;
        }

    })

    clear.addEventListener('click', clearCells);

    function clearCells() {
        cells.forEach(cell => cell.innerText = '');
        document.getElementById('check').innerHTML = '<p></p>';
        document.querySelector('table').style.border = '';
    }



}