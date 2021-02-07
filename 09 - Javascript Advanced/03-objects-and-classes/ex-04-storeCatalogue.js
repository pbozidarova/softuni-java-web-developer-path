// 4.	Store Catalogue
// You have to create a sorted catalogue of store products. You will be given the products’ names and prices. 
// You need to order them by alphabetical order. 
// Input
// The input comes as array of strings. Each element holds info about a product in the following format:
// “{productName} : {productPrice}”
// The product’s name will be a string, which will always start with a capital letter, and the price will be a number. 
// You can safely assume there will be NO duplicate product input. The comparison for alphabetical order is case-insensitive.
// Output
// As output you must print all the products in a specified format. They must be ordered exactly as specified above. 
// The products must be divided into groups, by the initial of their name. The group’s initial should be printed, and after that 
// the products should be printed with 2 spaces before their names. For more info check the examples.

function solve(input){
    let result = {};

    input.forEach(line => {
        let [name, price] = line.split(' : ');
        let letter = name[0];

        if(!result[letter] ){
            result[letter] = [];
        }
        price = Number(price); 
        let product = {name, price};
        result[letter].push(product);
    });
    
    let sortedByLetter = Object.entries(result).sort((curr, next) => {
        return curr[0].localeCompare(next[0]);
    });
    
    for(let i = 0; i < sortedByLetter.length; i++){
        console.log(sortedByLetter[i][0]);
        let sortedByName = sortedByLetter[i][1].sort((curr, next) => curr.name.localeCompare(next.name));
        sortedByName.forEach(product => {
            console.log(`  ${product.name}: ${product.price}`);
        })
    }
}

solve(['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
);
solve(['Banana : 2',
"Rubic's Cube : 5",
'Raspberry P : 4999',
'Rolex : 100000',
'Rollon : 10',
'Rali Car : 2000000',
'Pesho : 0.000001',
'Barrel : 10']
);