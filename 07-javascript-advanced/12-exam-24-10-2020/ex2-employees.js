function solveClasses(){
    class Developer {
        constructor ( firstName, lastName ) {
            this.firstName = firstName;
            this.lastName = lastName;

            this.baseSalary = 1000;
            this.tasks = [];
            this.experience = 0;
        }

        addTask ( id, taskName, priority ) {
            let task = {id, 
                        taskName,
                        priority }
            
            priority == 'high' ? this.tasks.unshift(task) : this.tasks.push(task);
            return `Task id ${id}, with ${priority} priority, has been added.`
        }

        doTask() {
            this.tasks.shift();

            return `${this.firstName}, you have finished all your tasks. You can rest now.`
        }

        getSalary(){
            return `${this.firstName} ${this.lastName} has a salary of: ${this.baseSalary}`
        }

        reviewTasks(){
            let output = `Tasks, that need to be completed:\n`
            this.tasks.forEach(task => { output += `${task.id}: ${task.taskName} - ${task.priority}\n` });

            return output.trim();
        }
    }

    class Junior extends Developer {
        constructor( firstName, lastName, bonus, experience ) {
            super(firstName, lastName);
            
            this.baseSalary  = 1000 + bonus;
            this.experience = experience;
        }
    
        learn( years ) {
            this.experience += years;
        }

    }

    class Senior extends Developer {
        constructor( firstName, lastName, bonus, experience ) {
            super(firstName, lastName);
            
            this.baseSalary = 1000 + bonus;
            this.tasks = [];
            this.experience = experience + 5;
        }

        changeTaskPriority(taskId) {
            let task = this.tasks.find(task => task.id == taskId);
            
            let indexOfTask = this.tasks.indexOf(task);
            
            let changedTask = this.tasks.splice(indexOfTask, 1)[0]

            if ( changedTask.priority == 'high') {
                changedTask.priority == 'low'
                this.tasks.push(changedTask);  
            } else {
                changedTask.priority == 'high'
                this.tasks.unshift(changedTask);
            }
            return changedTask;
        }
    }

    return { Developer, Junior, Senior}
}

let classes = solveClasses();
const developer = new classes.Developer("George", "Joestar");
console.log(developer.addTask(1, "Inspect bug", "low"));
console.log(developer.addTask(2, "Update repository", "high"));
console.log(developer.reviewTasks());
console.log(developer.getSalary());
// ----------------------------------------------------------------------------
const junior = new classes.Junior("Jonathan", "Joestar", 200, 2);
console.log(junior.getSalary());
//----------------------------------------------------------------------------
const senior = new classes.Senior("Joseph", "Joestar", 200, 2);
senior.addTask(1, "Create functionality", "low");
senior.addTask(2, "Update functionality", "high");
console.log(senior.changeTaskPriority(1)["priority"]);

// Task id 1, with low priority, has been added.
// Task id 2, with high priority, has been added.
// Tasks, that need to be completed:
// 2: Update repository - high
// 1: Inspect bug - low
// George Joestar has a salary of: 1000
// ----------------------------------------------------------------------------
// Jonathan Joestar has a salary of: 1200
// ----------------------------------------------------------------------------
// high
