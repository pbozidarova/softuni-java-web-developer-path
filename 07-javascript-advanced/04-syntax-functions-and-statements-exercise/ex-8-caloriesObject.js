// 8.	* Calorie Object
// Write a function that composes an object by given properties. The input comes as an array of strings. 
// Every even index of the array represents the name of the food. 
// Every odd index is a number that is equal to the calories in 100 grams of the given product. 
// Assign each value to its corresponding property and print it on the console.
// The input comes as an array of string elements.
// The output should be printed on the console.

function solve(input){
    let outputArray = [];

    for(let i =0; i < input.length; i += 2){
        let obj = {};

        obj.name = input[i];
        obj.calories = input[i+1];

        outputArray.push(obj);
    }

    let outputString = '';

    for(let i = 0; i < outputArray.length; i++) {
        outputString += `${outputArray[i].name}: ${outputArray[i].calories}`;
        i !== outputArray.length -1 ? outputString += ', ' : outputString += '';
    }

    console.log(`{ ${outputString} }`)
    
}

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
solve(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);