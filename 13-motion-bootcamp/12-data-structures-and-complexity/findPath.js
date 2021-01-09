let path = [];

function findPath(row, col, direction){
    if(!isInBounds(row, col)) return;

    path.push(direction)

    if(isExit(row, col)){
        printPath();
    }else if(!isVisied(row, col) && isPassable(row, col)){
        mark(row, col);
        findPath(row, col + 1, 'R'); //Right
        findPath(row + 1, col, 'D'); //Down
        findPath(row, col - 1, 'L'); //Left
        findPath(row - 1, col, 'U'); //Up
        unMark(row, col);
    }

    path.pop();
    
}

function isExit(){}

function isVisied(){}

function mark() {}

function printPath() {}