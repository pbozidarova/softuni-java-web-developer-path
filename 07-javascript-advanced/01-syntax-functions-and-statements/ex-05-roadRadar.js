// 5.	Road Radar
// // Write a function that determines whether a driver is within the speed limit. 
// You will receive the speed and the area. Each area has a different limit: 
// // •	On the motorway the limit is 130 km/h
// // •	On the interstate the limit is 90 km/h
// // •	In the city the limit is 50 km/h 
// // •	Within a residential area the limit is 20 km/h
// // If the driver is within the limits, there should not be any output. 
// If the driver is over the limit, however, your function should print the severity of the infraction. 
// // For speeding up to 20 km/h over the limit, speeding should be printed 
// // For speeding up to 40 km/h over the limit, excessive speeding should be printed
// // For anything else, reckless driving should be printed
// // The input comes as an array of elements. The first element is the current speed (number), the second element is the area.
// // The output should be printed on the console. Note that in certain cases there isn’t any output.

function solve(input){
    let speed = +input[0];
    let location = input[1];

    let speedLimit = 0;

    switch (location) {
        case 'motorway':
            speedLimit = 130;
        break;
        case 'interstate':
            speedLimit = 90;
        break;
        case 'city':
            speedLimit = 50;
        break;
        case 'residential':
            speedLimit = 20;
        break;
    }

    let speeding = speed - speedLimit;
    let result = '';

    if (speeding > 0 && speeding <= 20) {
        result = 'speeding';
    } else if(speeding > 20 && speeding <= 40) {
        result = 'excessive speeding';
    } else if(speeding > 40) {
        result = 'reckless driving';
    }
    console.log(result)
}

solve([40, 'city']);
solve([21, 'residential']);
solve([120, 'interstate']);
solve([200, 'motorway']);