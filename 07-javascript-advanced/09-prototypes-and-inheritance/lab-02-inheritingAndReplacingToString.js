// 2.	Inheriting and Replacing ToString
// Extend the Person and Teacher from the previous task and add a class Student inheriting from Person. 
// Add toString() functions to all classes, the formats should be as follows:
// •	Person - returns "Person (name: {name}, email: {email})"
// •	Student - returns "Student (name: {name}, email: {email}, course: {course})"
// •	Teacher - returns "Teacher (name: {name}, email:{email}, subject:{subject})"
// Try to reuse code by using the toString() function of the base class.
// Input / Output
// There will be NO input. Your function should return an object containing the classes Person, Teacher and Student.


function toStringExtension() {
    class Person {
        constructor(name, email) {
            this.name = name;
            this.email = email;
        }

        toString(){
            return `${this.constructor.name} (name: ${this.name}, email: ${this.email})`;
        }    
    }

    class Teacher extends Person {
        constructor(name, email, subject) {
            super(name, email);
            this.subject = subject;
        }

        toString(){
            return super.toString().replace(')', '') + `, subject: ${this.subject})`;
        }
    }

    class Student extends Person {
        constructor(name, email, course) {
            super(name, email);
            this.course = course;
        }
        toString(){
            return super.toString().replace(')', '') + `, course: ${this.course})`;
        }    
    }

    let p = new Person("Pesho",'Pesho@pesh.com');
    console.log(p.toString())
    
    return {
        Person,
        Teacher,
        Student
    }
}    
