// Write unit tests for a function that retrieves a character at a given index from a passed in string.
// You are given a function named lookupChar(), which has the following functionality:
// •	lookupChar(string, index) - accepts a string and an integer (the index of the char we want to lookup) :
//      o	If the first parameter is NOT a string or the second parameter is NOT a number - return undefined.
//      o	If both parameters are of the correct type but the value of the index is incorrect (bigger than or equal to the string length 
//          or a negative number) - return "Incorrect index". 
//      o	If both parameters have correct types and values - return the character at the specified index in the string.

let {assert} = require('chai');
let {lookupChar} = require('./lookupChar.js');

describe('lookupChar', () => {
    it('should return undefined with incorrect first param', () => {
        assert.equal(undefined, lookupChar(5, 0));
    });

    it('should return undefined with incorrect second param', () => {
        assert.equal(undefined, lookupChar('pesho', 'gosho'));
    });

    it('should return incorrect index with incorrect first param length', () => {
        assert.equal('Incorrect index', lookupChar('pesho', 5));
    });

    it('should return incorrect index with second param lower than 0', () => {
        assert.equal('Incorrect index', lookupChar('Pesho', -1));
    });

    it('should return correct charecter', () => {
        assert.equal('a', lookupChar('Stamat', 2))
    });
});