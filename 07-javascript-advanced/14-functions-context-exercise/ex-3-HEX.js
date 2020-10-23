// Write a Hex Class, Which Supports the Described Functionality Below.
class Hex {
    // Functionality
    // Constructor({value})
    // Should have these 1 property:
    // •	value - number
    constructor(value) {
        this.value = Number(value);
    }
    // This Function Should Return the Value Property of the Hex Class.
    valueOf(){
        return this.value;
    }
    // This function will show its hexidecimal value starting with "0x"
    toString(){
        return '0x' + this.value.toString(16).toUpperCase(); 
    }
    // This function should add a number or Hex object and return a new Hex object.
    plus(num){
        let result = this.value + Number(num.valueOf());
        return new Hex(result);
    }   
    // This function should subtract a number or Hex object and return a new Hex object.
    minus(num){
        let result = this.value - Number(num.valueOf());
        return new Hex(result);
    }
    // Create a parse class method that can parse Hexidecimal numbers and convert them to standard decimal numbers.
    parse(string){
        return parseInt(string, 16);
    }
}

function solve(){
    let FF = new Hex(255);
    console.log(FF.toString());
    FF.valueOf() + 1 == 256;
    let a = new Hex(10);
    let b = new Hex(5);
    console.log(a.plus(b).toString());
    console.log(a.plus(b).toString()==='0xF');
}

solve();