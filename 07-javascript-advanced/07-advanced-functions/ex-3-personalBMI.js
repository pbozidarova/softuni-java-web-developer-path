// A wellness clinic has contacted you with an offer - they want you to write a program that composes patient charts and performs some preliminary 
// evaluation of their condition. The data comes in the form of several arguments, describing a person - their name, age, weight in kilograms and 
// height in centimeters. Your program must compose this information into an object and return it for further processing.
// The patient chart object must contain the following properties:
// •	name
// •	personalInfo, which is an object holding their age, weight and height as properties
// •	BMI - body mass index. You can find information about how to calculate it here: https://en.wikipedia.org/wiki/Body_mass_index
// •	status
// The status is one of the following:
// •	underweight, for BMI less than 18.5;
// •	normal, for BMI less than 25;
// •	overweight, for BMI less than 30;
// •	obese, for BMI 30 or more;
// Once the BMI and status are calculated, you can make a recommendation. If the patient is obese, add an additional property called 
// recommendation and set it to “admission required”.

function solve(name, age, weight, height){
    let BMI = Math.round(Number(weight) / (Number(height)/100) ** 2);
    let status = calcStatus(BMI);

    let person = {
        name,
        personalInfo: {
            age,
            weight,
            height,
        },
        BMI,
        status,
    }

    if(status === 'obese'){
        person.recommendation = 'admission required';
    }

    return person;

    function calcStatus(BMI){
        if(BMI < 18.5) return 'underweight';
        if( BMI < 25 ) return 'normal';
        if( BMI < 30 ) return 'overweight';
        if( BMI >= 30) return 'obese';
    }
    
}

solve('Peter', 29, 75, 182);
solve('Honey Boo Boo', 9, 57, 137)