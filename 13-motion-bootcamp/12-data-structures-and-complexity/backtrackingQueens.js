function putQueens(row, col){

    if(row == 8){
        printSolution();
    }
    for(i = 0; i < col; i++){
        if(canPlaceQueen(row, col)){
            markAllAttachedPositions(row, col);
            putQueens(row + 1);
            unmarkAllAttackedPositions(row, col);
        }
    }

}

function printSolution(){

}

function markAllAttachedPositions(){

}

function unmarkAllAttackedPositions(){

}