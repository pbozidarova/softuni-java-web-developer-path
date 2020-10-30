// Write a Company Class, Which Supports the Described Functionality Below.
// Functionality
// Constructor()
// Should have these 1 property:
// •	departments - empty array
// AddEmployee({username}, {Salary}, {Position}, {Department})
// This function should add a new employee to the department with the given name.
// •	If one of the passed parameters is empty string (""), undefined or null,  this function should throw an error with the following message:
// "Invalid input!"
// •	If salary is less than 0, this function should throw an error with the following message:
// " Invalid input!"
// •	If the new employee is hired successfully, you should add him into the departments array and return the following message:
// " New employee is hired. Name: {name}. Position: {position}"
// bestDepartment()
// This function should print the department with the highest average salary and its employees sorted by their salary by descending and by name


class Company {
  constructor() {
    this.departments = [];
  }

  addEmployee(username, salary, position, department) {
    for (let arg of [username, salary, position, department]) {
      this.validate(arg);
    }
    if (!this.departments[department]) {
      this.departments[department] = [];
    }
    this.departments[department].push({ username, salary, position });
    return `New employee is hired. Name: ${username}. Position: ${position}`;
  }

  bestDepartment() {
    let departments = {};
    Object.entries(this.departments).forEach(([department, employees]) => {
      let totalSalary = employees
        .map((e) => e.salary)
        .reduce((acc, curr) => (acc += curr));

      departments[department] = totalSalary / employees.length;
    });

    let maxSalary = 0;
    let bestDepartment;
    Object.entries(departments).forEach(([department, avgSalary]) => {
      if (avgSalary > maxSalary) {
        maxSalary = avgSalary;
        bestDepartment = department;
      }
    });

    let output = `Best Department is: ${bestDepartment}\nAverage salary: ${departments[
      bestDepartment
    ].toFixed(2)}\n`;

    this.departments[bestDepartment]
      .sort(
        (a, b) => b.salary - a.salary || a.username.localeCompare(b.username)
      )
      .forEach((e) => {
        output += `${e.username} ${e.salary} ${e.position}\n`;
      });

    return output.trim();
  }

  validate(value) {
    if (!value || value < 0) {
      throw new Error("Invalid input!");
    }
  }
}

function solve() {
  let c = new Company();
  c.addEmployee("Stanimir", 2000, "engineer", "Construction");
  c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
  c.addEmployee("Slavi", 500, "dyer", "Construction");
  c.addEmployee("Stan", 2000, "architect", "Construction");
  c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
  c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
  c.addEmployee("Gosho", 1350, "HR", "Human resources");
  console.log(c.bestDepartment());
}

solve();
