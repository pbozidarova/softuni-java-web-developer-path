// Implement a collection, which keeps a list of numbers, sorted in ascending order. It must support the following functionality:
// •	add(elemenent) - adds a new element to the collection
// •	remove(index) - removes the element at position index
// •	get(index) - returns the value of the element at position index
// •	size - number of elements stored in the collection
// The correct order of the element must be kept at all times, regardless of which operation is called. Removing and retrieving 
// elements shouldn’t work if the provided index points outside the length of the collection (either throw an error or do nothing). 
// Note the size of the collection is NOT a function. Write your code such that the first function in your solution returns an instance 
// of your Sorted List.

function result(){
    
    let objFunctionality = {
        elements: [],    
        add: function(element) { this.elements.push(element)
                                 this.elements.sort( (a, b) => a - b );
                                 this.size++;
                                },

        remove: function(index) { 
            if(index < 0 || index > this.size) {
                throw new Error("Please provide a valid index!")
            }
            this.elements.splice(index, 1);
            
            if(this.size > 0) this.size--;
            
        }, 

        get: function(index) {
            if(index < 0 || index > this.size) {
                throw new Error("Please provide a valid index!");
            }
            return this.elements[index];
        },
        
        size: 0,
    }

    return objFunctionality;
}

let res = result();
// res.add(5);
// res.add(9);
// res.add(2);
console.log(res.size);

