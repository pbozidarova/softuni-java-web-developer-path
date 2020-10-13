// 1.	Towns to JSON
// You're tasked to create and print a JSON from a text table. You will receive 
// input as an array of strings, where each string represents a row of a table, 
// with values on the row encompassed by pipes "|" and optionally spaces. 
// The table will consist of exactly 3 columns "Town", "Latitude" and "Longitude". 
// The latitude and longitude columns 

function solve(input){
    let data = input.map(row => row
                                .split('|')
                                .filter(x => x != '')
                                .map(x => x.trim()));

        let properties = data.shift();
        let result = [];

        data.forEach(row => {
            let town = {
                [properties[0]]: row[0],
                [properties[1]]: Number(Number(row[1]).toFixed(2)),
                [properties[2]]: Number(Number(row[2]).toFixed(2)),
            };
            result.push(town);
        })

        console.log(JSON.stringify(result))
}

solve(['| Town | Latitude | Longitude |',
'| Sofia | 42.696552 | 23.32601 |',
'| Beijing | 39.913818 | 116.363625 |']
);