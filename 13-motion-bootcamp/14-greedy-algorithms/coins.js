function solve(finalSum){
    
    let currentSum = 0;
    let coins = [10, 10, 5, 5, 2, 2, 1, 1];
    let resultCoins = [];
    let output = ''; 

    for(let i = 0; i < coins.length; i++){
        if(currentSum + coins[i] > finalSum) continue;

        currentSum += coins[i];
        resultCoins.push(coins[i]);
        
        currentSum == finalSum ? output = 'Sum found!' : output = 'Sum not found!';
    }
    console.log(output, resultCoins);
}

solve(28);

function solveNoCoinsLimit(targetSum){
    let availableCoins = [1, 2, 5, 10, 20, 50];
    availableCoins.sort((a, b) => b - a);
    
    let coinIndex = 0;
    let currentSum = 0;
    let result = {}

    while(coinIndex < availableCoins.length && currentSum != targetSum){
        let currentCoinValue = availableCoins[coinIndex];
        if(currentSum + currentCoinValue > targetSum) {
            coinIndex++;
            continue;
        }
        let remainingSum = targetSum - currentSum;
        let coinsToTake = Math.floor(remainingSum / currentCoinValue);
        if(coinsToTake > 0){
            result[currentCoinValue] = coinsToTake;
            currentSum += coinsToTake * currentCoinValue;
        }
    }
    
    if(currentSum != targetSum) {
        console.log('Sorry, sum not found!');
    } else{
        console.log(result);
    }
}

solveNoCoinsLimit(58);