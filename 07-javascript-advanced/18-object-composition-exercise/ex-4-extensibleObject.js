// Create an object that can clone the functionality of another object into itself. Implement an extend(template) function that would 
// copy all of the properties of template to the parent object and if the property is a function, add it to the object’s prototype instead.
// Input / Output
// Your code should return the extensible object instance. The extend() function of your object will receive a valid object as input parameter, 
// and has no output.
// Note that __proto__ is a hidden property, representing the object’s prototype - depending on your test environment, you may not have access 
// to it directly, but you can use other functions to do that.
// Hints
// To gain access to the prototype of an instance, use the Object.getPrototypeOf() function. To make a function shared between all instances, 
// it’ll have to be attached to the prototype instead of the instance.

myObj = () => ({
    __proto__: {},
    extend: function(template){
        Object.entries(template).forEach(([key, value]) => {
            if(typeof value === 'function'){
                this.__proto__[key] = value;
            }else{
                this[key] = value;
            }
        });
    }
});

myObj().extend({
    extensionMethod: function(){},
    extensionProperty: 'somethingString',
})