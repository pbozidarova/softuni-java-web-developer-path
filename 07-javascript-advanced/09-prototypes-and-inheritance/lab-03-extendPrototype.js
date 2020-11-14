// 3.	Extend Prototype
// Write a function which receives a class and attaches to it a property species and a function toSpeciesString(). When called, 
// the function returns a string with format:
// "I am a <species>. <toString()>"
// The function toString() is called from the current instance (call using this).
// Input / Output
// Your function will receive a class whose prototype it should extend. There is NO output, your function should only attach the 
// properties to the given class’ prototype.

function extendProrotype(Parent) {
    Parent.prototype.species = 'Human';
    Parent.prototype.toSpeciesString = function() {
        return `I am a ${this.species}. ${this.toString()}`
    }
}
class Animal {
    isAnimal = true;

    toString() {
        return 'mrmrmrmrm';
    }
}

extendProrotype(Amimal);
let animal = new Animal();
console.log(animal.toSpeciesString());