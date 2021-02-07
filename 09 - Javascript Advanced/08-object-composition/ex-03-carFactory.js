// Write a program that assembles a car by given requirements out of existing components. The client will place an order in the form of an object 
// describing the car. You need to determine which parts to use to fulfil the client’s order. You have the following parts in storage:
// An engine has power (given in horsepower) and volume (given in cubic centimeters). Both of these values are numbers. When selecting an engine, 
// pick the smallest possible that still meets the requirements.
// Small engine: { power: 90, volume: 1800 }
// Normal engine: { power: 120, volume: 2400 }
// Monster engine: { power: 200, volume: 3500 }
// A carriage has a type and color. Both of these values are strings. You have two types of carriages in storage and can paint it any color.
// Hatchback: { type: 'hatchback', color: <as required> }
// Coupe: { type: 'coupe', color: <as required> }
// The wheels will be represented by an array of 4 numbers, each number represents the diameter of the wheel in inches. The size can only be an 
// odd number. Round down any requirements you receive to the nearest odd number. 

function solve(customerInfo){
    let {model, power, color, carriage, wheelsize} = customerInfo;
    let engine;
    if(power <= 90) {
        engine = {power: 90, volume: 1800}
    }else if(power <=120){
        engine = {power: 120, volume: 2400}
    }else{
        engine = {power: 200, volume: 3500}
    }

    let carCarriage = {type: carriage, color};
    let size = wheelsize % 2 === 0 ? --wheelsize : wheelsize;
    let wheels = [size, size, size, size];
    let wheels2 = [0,0,0,0].fill(size);

    let result = {
        model,
        engine,
        carriage: carCarriage,
        wheels
    }

    return result;
}

solve({ model: 'VW Golf II',
power: 90,
color: 'blue',
carriage: 'hatchback',
wheelsize: 14 }
);

solve({ model: 'Opel Vectra',
power: 110,
color: 'grey',
carriage: 'coupe',
wheelsize: 17 }
);

