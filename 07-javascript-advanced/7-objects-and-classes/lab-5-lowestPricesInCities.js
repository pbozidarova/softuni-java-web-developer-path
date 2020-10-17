// 5.	Lowest Prices in Cities
// You will be given several towns, with products and their price. You need to find the lowest price for every product and the town 
// it is sold at for that price.
// Input
// The input comes as array of strings. Each element will hold data about a town, product, and its price at that town. The town and 
// product will be strings, the price will be a number. The input will come in the following format:
// {townName} | {productName} | {productPrice}
// If you receive the same town and product more than once, you should update the old value with the new one.
// Output
// As output you must print each product with its lowest price and the town at which the product is sold at that price. If two towns 
// share the same lowest price, print the one that was entered first. 
// The output, for every product, should be in the following format:
// {productName} -> {productLowestPrice} ({townName})
// The order of output is - order of entrance. See the examples for more info.

function solve(input){
    let products = {};

    input.forEach(row => {
        let [town, product, priceText] = row.split(' | ');
        let price = Number(priceText);

        if(!products[product]){
            products[product] = {};
        }
        if(!products[product][town]){
            products[product][town] = price;
        }
        if(products[product][town].price > price){
            products[product][town] = price;
        }
    });
    Object.entries(products).forEach(prdData => {
        let lowestPrice = Math.min(...Object.values(prdData[1]));
        console.log(`${prdData[0]} -> ${lowestPrice} (${Object.keys(products[prdData[0]])[0]})`);
    });
}

function solve2(array) {
    let products = new Map();
    for (let sentance of array) {
        let [town, product, price] = sentance.split(" | ");
        if (!products.has(product)) {
            products.set(product, new Map());
        }
        products.get(product).set(town, Number(price));
    }
    for (let [key, value] of products) {
        let lowest = ([...value].reduce(function (a, b) {
            if (a[1] < b[1]) {
                return a;
            } else if (a[1] > b[1]) {
                return b;
            }
            return a;
        }));
        console.log(`${key} -> ${lowest[1]} (${lowest[0]})`);
    }
}

solve(['Sample Town | Sample Product | 1000',
'Sample Town | Orange | 2',
'Sample Town | Peach | 1',
'Sofia | Orange | 3',
'Sofia | Peach | 2',
'New York | Sample Product | 1000.1',
'New York | Burger | 10']
);