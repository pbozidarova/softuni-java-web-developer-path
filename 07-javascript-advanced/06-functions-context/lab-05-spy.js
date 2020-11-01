// Write a function that takes 2 parameters target(an object) and method(a string) and tracks 
// how many times the method of an object is called.

function Spy(target, methodName) {
    let result = {
        count: 0,
    };

    let originalMethod = target[methodName];

    target[methodName] = function() {
        result.count++;

        return originalMethod.apply(target, arguments);
    };
    return result;
}


let obj = {
    getText:()=>"invoked"
}
let spy = Spy(obj,"getText");

obj.getText();
obj.getText();
obj.getText();

console.log(spy) // { count: 3 }

// let spy = Spy(console,"log");

// console.log(spy); // { count: 1 }
// console.log(spy); // { count: 2 }
// console.log(spy); // { count: 3 }
