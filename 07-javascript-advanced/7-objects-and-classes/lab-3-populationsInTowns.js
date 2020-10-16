// 3.	Populations in Towns
// You have been tasked to create a register for different towns and their population.
// Input
// The input comes as array of strings. Each element will contain data for a town and its population in the following format:
// “{townName} <-> {townPopulation}”
// If you receive the same town twice, you should add the given population to the current one.
// Output
// As output, you must print all the towns, and their population.

function solve(input){
    let towns = input
                    .map(x => x.split(' <-> '))
                    .reduce(
                        (a, x) => {
                            let currentTown = x[0];
                            let currentPopulation = Number(x[1]);
                            if(!a.hasOwnProperty(currentTown)){
                                a[currentTown] = 0;
                            }
                            a[currentTown] += currentPopulation;
                            return a;
                        }, {}
                        );

    Object.keys(towns).forEach(town => console.log(`${town} : ${towns[town]}`));
}

solve(['Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000']
);
solve(['Istanbul <-> 100000',
'Honk Kong <-> 2100004',
'Jerusalem <-> 2352344',
'Mexico City <-> 23401925',
'Istanbul <-> 1000']
);