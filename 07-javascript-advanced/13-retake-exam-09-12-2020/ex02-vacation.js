class Vacation {
    
    constructor(organizer, destination, budget) {
        this.organizer = organizer;
        this.destination = destination;
        this.budget = budget;
        this.kids = [];
        
    }

    findGrade(grade) {
        return this.kids.find(el => Object.keys(el)[0] == grade);
    }

    findKid(name, grade){
        let kidGrade = this.findGrade(grade);

        let kid = null;
        if(!kidGrade){
            return kid;
        }
        kidGrade[grade].forEach(k => {
            if(k.split('-')[0] == name){
                kid = { name: k.split('-')[0] , 
                        budget: k.split('-')[1]};
            }

        });

        return kid;
    }

    registerChild(name, grade, budget) {
        let foundKid = this.findKid(name, grade);
        let foundGrade = this.findGrade(grade);
        
        if(foundKid) {
            return `${name} is already in the list for this ${this.destination} vacation.`;
        }

        if(budget < this.budget) {
            return `${name}'s money is not enough to go on vacation to ${this.destination}.`;
        }

        if(!foundGrade) {
            this.kids.push( {[grade]: []} )
        }

        let gradeClass = this.findGrade(grade)[grade];
        gradeClass.push(`${name}-${budget}`);

        return this.findGrade(grade)[grade];
    }

    removeChild(name, grade) {
        let foundKid = this.findKid(name, grade);
        let foundGrade = this.findGrade(grade);

        if(!foundKid) {
            return `We couldn't find ${name} in ${grade} grade.`;
        }   

        let indexOfFoundKid = foundGrade[grade].indexOf(`${name}-${foundKid.budget}`);
        foundGrade[grade].splice(indexOfFoundKid, 1);

        return this.findGrade(grade)[grade];
    }

    toString() {
        let output = '';

        if(!this.kids.length){
            return `No children are enrolled for the trip and the organization of ${this.organizer} falls out...`;
        }

        output += `${this.organizer} will take ${this.numberOfChildren()} children on trip to ${this.destination}`;
        this.kids
        .sort((a, b) => Number(Object.keys(a)[0]) - Number((Object.keys(b)[0])))
        .forEach(el => {
                output += `Grade: ${Object.keys(el)[0]}`;
                output += '\n'
                Object.values(el)[0].forEach(kid => output += `${Object.values(el)[0].indexOf(kid)+1}. ${kid}\n`);
                // output += '\n'
            });

        return output;
    }

    numberOfChildren() {
        let count = 0;
        this.kids.forEach(el => count += Object.values(el)[0].length);

        return count;
    }
}

// let vacation = new Vacation('Mr Pesho', 'San diego', 2000);
// console.log(vacation.registerChild('Gosho', 5, 2000));
// console.log(vacation.registerChild('Lilly', 6, 2100));
// console.log(vacation.registerChild('Pesho', 6, 2400));
// console.log(vacation.registerChild('Gosho', 5, 2000));
// console.log(vacation.registerChild('Tanya', 5, 6000));
// console.log(vacation.registerChild('Mitko', 10, 1590));

/////////////////////////

let vacation = new Vacation('Mr Pesho', 'San diego', 2000);
vacation.registerChild('Gosho', 5, 2000);
vacation.registerChild('Lilly', 6, 2100);

console.log(vacation.removeChild('Gosho', 9));

vacation.registerChild('Pesho', 6, 2400);
vacation.registerChild('Gosho', 5, 2000);

console.log(vacation.removeChild('Lilly', 6));
console.log(vacation.registerChild('Tanya', 5, 6000))

////////////////////////

// let vacation = new Vacation('Miss Elizabeth', 'Dubai', 2000);
// vacation.registerChild('Gosho', 5, 3000);
// vacation.registerChild('Lilly', 6, 1500);
// vacation.registerChild('Pesho', 7, 4000);
// vacation.registerChild('Tanya', 5, 5000);
// vacation.registerChild('Mitko', 10, 5500)
// console.log(vacation.toString());
