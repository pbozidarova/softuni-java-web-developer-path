// The above code defines a class that holds characters (strings with length 1) in an array. An instance of the class should support the
// following operations:
// •	Can be instantiated with a passed in string argument or without anything
// •	Function append(string) - converts the passed in string argument to an array and adds it to the end of the storage
// •	Function prepend(string) - converts the passed in string argument to an array and adds it to the beginning of the storage
// •	Function insertAt(string, index) - converts the passed in string argument to an array and adds it at the given index (there is no
//     need to check if the index is in range)
// •	Function remove(startIndex, length) - removes elements from the storage, starting at the given index (inclusive), length number of
//     characters (there is no need to check if the index is in range)
// •	Function toString() - returns a string with all elements joined by an empty string
// •	All passed in arguments should be strings. If any of them are not, throws a type error with the following message:
//     'Argument must be a string'

let { assert } = require('chai');
let StringBuilder = require('./stringBuilder.js');

let sb;
describe('StringBulder', () => {
  beforeEach(() => {
    sb = new StringBuilder();
  });
  describe('verifyParams', () => {
    it('should throw exception when param is not a string', () => {
      assert.throw(() => {
        new StringBuilder({});
      }, 'Argument must be string');
    });
  });

  describe('constructor', () => {
    it('should work properly without argument', () => {
      assert.equal('', sb.toString());
    });

    it('should work proverly with argument', () => {
      sb = new StringBuilder('Pesho');
      assert.equal('Pesho', sb.toString());
    });
  });

  describe('append', () => {
    it('should append text at the end of a string', () => {
      sb.append('Pesho');
      assert.equal('Pesho', sb.toString());
    });
  });
  describe('prepend', () => {
    it('should prepend text at the start of a string', () => {
      sb.prepend('Pesho');
      assert.equal('Pesho', sb.toString());
    });
  });
  describe('insertAt', () => {
    it('should insert text at index', () => {
      sb.append('Psho');
      sb.insertAt('e', 1);
      assert.equal('Pesho', sb.toString());
    });
  });
  describe('remove', () => {
     it('should remove text from index exact length', () => {
       sb.append('Pesho');
       sb.remove(0, 1);
       assert.equal('esho', sb.toString());
     });
   });
   describe('toString', () => {
     it('should return correct string', () => {
       sb.append('Pesho');
       assert.equal('Pesho', sb.toString());
     });
   });
});