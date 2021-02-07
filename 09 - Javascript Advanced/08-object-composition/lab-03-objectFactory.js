// 3.	Object Factory
// Write a function that can compose objects. You will receive a string and your goal is to create a new object with all the unique properties you were given. 
// For more information check the examples below.

function solve(input) {
    let propList = JSON.parse(input);

    let result = propList.reduce((a, x) => ({...a, ...x}), {});
    
    return result;
}

// solve(`[{"canMove": true},{"canMove":true, "doors": 4},{"capacity": 5}]`);
// solve(`[{"canFly": true},{"canMove":true, "doors": 4},{"capacity": 255},{"canFly":true, "canLand": true}]`);
solve(`[{"prop1": 1},{"prop2":2},{"prop3":3}]`);