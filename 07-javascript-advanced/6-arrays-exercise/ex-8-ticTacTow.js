// 8.	*Tic-Tac-Toe
// Make a tic-tac-toe console application.
// You will receive an array of arrays. As you know there are two players in this game, 
// so the first element of the input will be first player's chosen coordinates, 
// the second element will be the second player's turn coordinates and so on.
// The initial state of the dashboard is
// [[false, false, false],
// [false, false, false],
// [false, false, false]]
// The first player's mark is X and the second player's mark is O.

function solve(input){
    let dashboard = [
        [false, false, false],
        [false, false, false],
        [false, false, false]
    ];

    let player = 'X';
    let win = false;
    input.forEach(line => {
        let [row, col] = line.split(' ').map(num => Number(num));
        if(!win){
            if(!dashboard[row][col]){
                dashboard[row][col] = player;
                
                if(ifWins(dashboard,player)){
                    win = true;
                }    
                player = player === 'X' ? 'O' : 'X';
        
            }else{
                console.log('This place is already taken. Please choose another!'); 
            }
        }
    });

    if(win) {
        console.log(`Player ${player} wins!`);
    } else {
        console.log('The game ended! Nobody wins :(');
    }

    printMatrix(dashboard);
    
    function printMatrix(dashboard){
        dashboard.forEach(row => {
            console.log(row.join('\t'))
        });
    }

    function ifWins(dashboard, player){
        return checkDiagonalFirst(dashboard, player) ||
             checkDiagonalSecond(dashboard, player) ||
             checkRows(dashboard, player) ||
             checkCols(dashboard, player);
    }

    function checkDiagonalFirst(dashboard, player){
            for(let col = 0; col < 3;col++){
                if(dashboard[col][col] !== player){
                    return false;
                }
            }
        return true;
    }

    function checkDiagonalSecond(dashboard, player){
        for(let row = 2; row > 0; row--){
            for(let col = 0; col < 3; col++)
            if(dashboard[row][col] !== player){
                return false;
            }
        }
        return true;
    }

    function checkRows(dashboard, player){
        for(let row = 0; row < 3;row++){
            let winRow = '';
            for(let col = 0; col < 3;col++){    
                winRow += dashboard[row][col];
            }        
            if(winRow == (player+player+player)) {
                return true;
            }
        }
        return false;
    }

    function checkCols(dashboard, player){
        for(let row = 0; row < 3;row++){
            let winCol = '';
            for(let col = 0; col < 3;col++){    
                winCol += dashboard[col][row];
            }
            if(winCol == (player+player+player)){
                return true;
            }
        }
        return false;
    }
 
}

// solve(["0 1",
// "0 0",
// "0 2", 
// "2 0",
// "1 0",
// "1 1",
// "1 2",
// "2 2",
// "2 1",
// "0 0"]
// );

solve(["0 0",
"0 0",
"1 1",
"0 1",
"1 2",
"0 2",
"2 2",
"1 2",
"2 2",
"2 1"]
);

// solve(["0 1",
// "0 0",
// "0 2",
// "2 0",
// "1 0",
// "1 2",
// "1 1",
// "2 1",
// "2 2",
// "0 0"]
// );