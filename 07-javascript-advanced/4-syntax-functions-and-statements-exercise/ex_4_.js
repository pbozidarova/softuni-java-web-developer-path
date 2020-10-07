// 4.	Time to Walk
// Write a function that calculates how long it takes a student to get to university. 
// The function takes three numbers:
// •	The first is the number of steps the student takes from their home to the university
// •	Тhe second number is the length of the student's footprint in meters
// •	Тhe third number is the student speed in km/h
// Every 500 meters the student rests and takes a 1 minute break.
// Calculate how long the student walks from home to university and print on the console the result in the following format: 'hours:minutes:seconds'.
// The input comes as three numbers.
// The output should be printed on the console.

function solve(steps, stepLength, speed){
    let distanceInMeters = steps * stepLength;
    let speedForMeterInSec = speed / 3.6;
    let rest = Math.floor(distanceInMeters / 500);

    let time = distanceInMeters / speedForMeterInSec + rest*60;
    let timeInHours = Math.floor(time / 3600);
    let timeInMins = Math.floor(time / 60);
    let timeInSeconds = Math.floor(time % 60);

    console.log(`${timeInHours}:${timeInMins}:${timeInSeconds}`)
}

solve(4000, 0.60, 5);
solve(2564, 0.70, 5.5);