// You need to write unit tests for a function isOddOrEven() that checks whether the length of a passed in string is even or odd.
// If the passed parameter is NOT a string return undefined. If the parameter is a string return either "even" or "odd" based on the 
// length of the string.

let assert = require('chai').assert;
let {isOddOrEven} = require('./isOddOrEven.js');

describe('isOddOrEven', () => {
    it('should return undefined with param different from string', () => {
        assert.equal(undefined, isOddOrEven(5));
    });

    it('should return undefined with param different from string.2', () => {
        assert.equal(undefined, isOddOrEven({}));
    });

    it('should return even', () => {
        assert.equal('even', isOddOrEven('word'));
    });
    
    it('should return odd', () => {
        assert.equal('odd', isOddOrEven('words'));
    });

});

