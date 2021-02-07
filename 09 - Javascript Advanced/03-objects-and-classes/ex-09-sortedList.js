// 9.	Sorted List
// Implement a class, which keeps a list of numbers, sorted in ascending order. 
// It must support the following functionality:
// •	add(elemenent) - adds a new element to the collection
// •	remove(index) - removes the element at position index
// •	get(index) - returns the value of the element at position index
// •	size - number of elements stored in the collection
// The correct order of the elements must be kept at all times, regardless of which operation is called. 
// Removing and retrieving elements shouldn’t work if the provided index points outside the length of 
// the collection (either throw an error or do nothing). 
// Note the size of the collection is not a function.

function solve(){  
    class List{
        constructor(){
            this.list = []
            this.size = 0
        }
        
        add(elemenent){
            this.list.push(elemenent);
            this.size += 1;
            this.list.sort((curr, next) => curr - next);
            return;
        }
        remove(index){
            if (index < 0 || index >= this.list.length) {
                throw new Error(`Index doesn't exist`);
            } else {
                this.list.splice(index, 1);
                this.size--;
                return;
            }        
        }
        get(index) {
            if (index < 0 || index >= this.list.length) {
                throw new Error(`Index doesn't exist`);
            } else {
                return this.list[index];
            }
        }
    }

    let list = new List();
    list.add(5);
    list.add(6);
    list.add(7);
    console.log(list.get(1)); 
    list.remove(1);
    console.log(list.get(1));
}

solve();