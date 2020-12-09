function solveClasses() {

class Person {
    constructor ( firstName, lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.problems = [];
    }

    toString () {
        return `${this.firstName} ${this.lastName} is part of SoftUni community now!`
    }
}

class Teacher extends Person {
    constructor ( firstName, lastName) {
        super(firstName, lastName)
    }

    createProblem ( id, difficulty ) {
        let objProblem = {id, difficulty};

        if(!this.problems.find(objPrb => objPrb.id === id)) {
            this.problems.push(objProblem);
        }
        this.getProblems();
    }

    getProblems() {
        return this.problems;
    }

    showProblemSolution ( id) {
        let currentObjProblem = this.problems.find(objPrb => objPrb.id === id);

        if(!currentObjProblem) {
            throw new Error(`Problem with id ${ this.id } not found.`);
        }

        currentObjProblem.difficulty--;
        return currentObjProblem;
    }
}

class Student extends Person {
    constructor( firstName, lastName, graduationCredits, problems ){
        super(firstName, lastName);
        this.graduationCredits = graduationCredits;
        this.myCredits = 0;
        this.solvedProblems = []
        this.problems = problems;
    
    }   

    solveProblem(id) {
        let currentObjProblem = this.problems.find(objPrb => objPrb.id === id);

        if(!currentObjProblem) {
            throw new Error(`Problem with id ${ this.id } not found.`);
        }

        if(!this.solvedProblems.find(solvedProblem => solvedProblem.id === currentObjProblem.id)){
            this.myCredits += currentObjProblem.difficulty;
            this.solvedProblems.push(currentObjProblem);
        }

        return this.myCredits;
    }

    graduate() {
        if(this.myCredits >= this.graduationCredits) {
            return `${this.firstName} ${this.lastName} has graduated succesfully.`;
        }

        return `${this.firstName} ${this.lastName}, you need ${ this.graduationCredits - this.myCredits } credits to graduate.`
    }
    
}
    return {
        Person,
        Teacher,
        Student
    }
}

const classes = solveClasses();
const teacher = new classes.Teacher("Ivailo", "Papazov");
teacher.createProblem('as442df', 5);
console.log(teacher.problems);

teacher.createProblem('ffff44', 15);
console.log(teacher.problems);

teacher.showProblemSolution('as442df');
console.log(teacher.problems);
//----------------------------------------------------------------------------
// const classes = solveClasses();
// const student = new classes.Student("Pesho", "Petrov", 23, [{id: '111', difficulty: 5}, {id: '222', difficulty: 15}]);

// student.solveProblem('111');
// console.log(student.myCredits);
// console.log(student.graduate());

// student.solveProblem('222');
// console.log(student.solvedProblems);
// console.log(student.graduate());

// [{id: 'as442df', difficulty: 5}]
// [{id: 'as442df', difficulty: 5}, {id: 'ffff44', difficulty: 15}]
// [{id: 'as442df', difficulty: 4}, {id: 'ffff44', difficulty: 15}]
// ----------------------------------------------------------------------------
// 5 
// Pesho Petrov, you need 18 credits to graduate. 
// [{id: '111', difficulty: 5}, {id: '222', difficulty: 15}]
// Pesho Petrov, you need 3 credits to graduate.
