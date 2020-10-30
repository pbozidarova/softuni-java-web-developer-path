// Extend the build-in String object with additional functionality. Implement the following functions:
// •	ensureStart(str) - append str to the beginning of a string, only if it’s not already present
// •	ensureEnd(str) - append str to the end of a string, only if it’s not already present
// •	isEmpty() - return true if the string is empty, false otherwise
// •	truncate(n) - truncates the string to n characters by removing words and appends an ellipsis (three periods) to the end. 
// If a string is less than n characters long, return the same string. If it is longer, split the string where a space occurs and append 
// an ellipsis to it so that the total length is less than or equal to n. If no space occurs anywhere in the string, return n - 3 characters 
// and an ellipsis. If n is less than 4, return n amount of periods.
// •	format(string, …params) - static method to replace placeholders with parameters. A placeholder is a number surrounded by curly braces. 
// If parameter index cannot be found for a certain placeholder, do not modify it. Note static methods are attached to the String object instead 
// of it’s prototype. See the examples for more info.
// Note strings are immutable, so your functions will return new strings as a result.

(() => {
    String.prototype.ensureStart = function(str = ''){
        if(!this.startsWith(str)){
            return str + this;
        }
        return this.toString();
    }
    String.prototype.ensureEnd = function(str = ''){
        if(!this.endsWith(str)){
            return this + str;
        }
        return this.toString();
    }
    String.prototype.isEmpty = function(){
        return this.length == 0;
    }
    String.prototype.truncate = function(n){
        if(this.length < n) {
            return this.toString();
        }
        if(n < 4){
            return '.'.repeat(n);
        }
        if (!this.includes(' ')) {
            return this.slice(0, n - 3) + '...'
        }

        let tokens = this.split(' ');
        let result = tokens[0];
        for (let i = 1; i < tokens.length; i++) {
            if (result.length + tokens[i].length + 4 > n) {
                return result + '...'
            }
            result += ' ' + tokens[i]
        }
        return result;
    }
    String.format = function (string, ...params) {
        for (let i = 1; i < arguments.length; i++) {
            string = string.replace('{' + (i - 1) + '}', arguments[i]);
        }

        return string;
    };
})()

let str = 'the quick brown fox jumps over the lazy dog';
// str = str.ensureStart('my');
// str = str.ensureStart('hello ');
str = str.truncate(43);
// str = str.truncate(14);
// str = str.truncate(8);
// str = str.truncate(4);
// str = str.truncate(2);
// str = String.format('The {0} {1} fox',
//   'quick', 'brown');
// str = String.format('jumps {0} {1}',
//   'dog');