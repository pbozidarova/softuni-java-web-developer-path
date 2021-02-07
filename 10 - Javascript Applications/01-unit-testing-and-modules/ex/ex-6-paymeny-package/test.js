// Functionality
// The above code defines a class that contains information about a payment package. An instance of the class should support the 
// following operations:
// •	Can be instantiated with two parameters - a string name and number value
// •	Accessor name - used to get and set the value of name
// •	Accessor value - used to get and set the value of value
// •	Accessor VAT - used to get and set the value of VAT
// •	Accessor active - used to get and set the value of active
// •	Function toString() - return a string, containing an overview of the instance; if the package is not active, 
// append the label "(inactive)" to the printed name
// When creating an instance, or changing any of the property values, the parameters are validated. They must follow these rules:
// •	name - non-empty string
// •	value - non-negative number
// •	VAT - non-negative number
// •	active - Boolean
// If any of the requirements aren’t met, the operation must throw an error.
// Scroll down for examples and details about submitting to Judge.

let {assert} = require('chai');
let PaymentPackage = require('./paymentPackage.js');

describe('PaymentPackage', () => {
    let paymentPackage;
    describe('constructor', () => {
        it('constructor should work properly with two params', () => {
            paymentPackage = new PaymentPackage('Pesho', 10);
            let expected = new PaymentPackage('Pesho', 10);
            assert.deepEqual(paymentPackage, expected);
        });
    });
    describe('functions', () => {
        it('should throw exception with incorrect name', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage(10, 10);
            },'Name must be a non-empty string');
        });
        it('should throw exception with incorrect name length 0', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage('', 10);
            },'Name must be a non-empty string');
        });
        it('should throw exception with incorrect value', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage('Pesho', 'Gosho');
            },'Value must be a non-negative number');
        });
        it('should throw exception with value lower than 0', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage('Pesho', -5);
            },'Value must be a non-negative number');
        });
    });
});