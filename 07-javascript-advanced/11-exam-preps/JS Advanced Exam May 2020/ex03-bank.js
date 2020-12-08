// Your Task
// Write a Class Bank, Which Implements the Following Functionality:

class Bank {

    // Receives 1 parameter at initialization of the class (bankName), and should be set as private property.
    // Should have these 2 properties:
    // ·	bankName - private property of type string 
    // ·	allCustomers -  initially an empty array
    constructor(bankName){
        this._bankName = bankName;
        this.allCustomers = [];
    }

    hasCustomer(personalId) {
        return this.allCustomers.find( customer => customer.personalId === personalId );

    }

    // The customer is of type object {firstName, lastName, personalId}.
    // •	Check if the customer is already a customer of the bank. If so you should throw an Error: ”{firstName} {lastName} is already our customer!”
    // •	Otherwise this function should add the customer as new one and return the customer details
    newCustomer({firstName, lastName, personalId}) {
        if( this.hasCustomer(personalId)) {
            throw new Error(`${firstName} ${lastName} is already our customer!`)
        }

        this.allCustomers.push({firstName, lastName, personalId});
        return {firstName, lastName, personalId}
    }
    
    // Both the personalId and the amount are numbers.
    // ·	Check if the given personalId corresponds to a customer in the customers array, if not throw a new error: “We have no customer with this ID!”
    // ·	Otherwise add the amount to the corresponding customer in a property named totalMoney and store the transaction information to this customer 
    //     (for more clarity see the example below and the hints), then return the total money of the corresponding customer and a dollar sign: “{totalMoney}$”
    depositMoney (personalId, amount) {
       let currentCustomer = this.hasCustomer(personalId);

        if(!currentCustomer ) {
            throw new Error(`We have no customer with this ID!`)
        }

        if( currentCustomer.totalMoney ){
            currentCustomer.totalMoney += amount;
        } else {
            currentCustomer.totalMoney = amount;
            currentCustomer.transactions = [];
        }

        currentCustomer.transactions.push(`${currentCustomer.firstName} ${currentCustomer.lastName} made deposit of ${amount}$!`)
        
        return `${currentCustomer.totalMoney}$`;
    }

    // Both the personalId and the amount are numbers.
    // ·	Check if the given personalId corresponds to a customer in the customers array, if not throw a new error: “We have no customer with this ID!”
    // •	If there is a customer with the given personalId, check if the customer has enough money in his account, to withdraw the given amount. 
    // If the money is not enough throw a new error: “{firstName} {lastName} does not have enough money to withdraw that amount!”
    // ·	Otherwise subtract the amount from the totalMoney  of the customer and store the transaction information to this customer, 
    // then return the total money of the corresponding customer and a dollar sign: “{totalMoney}$”
    withdrawMoney (personalId, amount) {
        let currentCustomer = this.hasCustomer(personalId);

        if(!currentCustomer ) {
            throw new Error(`We have no customer with this ID!`)
        }

        if(currentCustomer.totalMoney < amount) {
            throw new Error(`${currentCustomer.firstName} ${currentCustomer.lastName} does not have enough money to withdraw that amount!`)
        }

        currentCustomer.totalMoney -= amount;
        currentCustomer.transactions.push(`${currentCustomer.firstName} ${currentCustomer.lastName} withdrew ${amount}$!`)

        return `${currentCustomer.totalMoney}$`;

    }


    // The personalId is of type number.
    // ·	Check if the given personalId corresponds to a customer in the customers array, if not throw a new error: “We have no customer with this ID!”
    // •	Otherwise return the whole information for the customer in the following format:
    // “Bank name: {bankName}
    // Customer name: {firstName} {lastName}
    // Customer ID: {personalId}
    // Total Money: {totalMoney}$
    // Transactions:
    // n. {firstName} {lastName} made deposit of {amount}$!
    // ...
    // 2.	{firstName} {lastName} withdrew {amount}$!
    // 1.	{firstName} {lastName} made deposit of {amount}$!”

    // Transaction information contains information about:
    // •	number of the transaction in descending order;
    // •	names (firstName, lastName);
    // •	if the transaction is deposit/withdraw;
    // •	amount of the transaction.
    customerInfo (personalId) {
        let currentCustomer = this.hasCustomer(personalId);

        let output = `Bank name: ${this._bankName}`
        output += '\n';
        output += `Customer name: ${currentCustomer.firstName} ${currentCustomer.lastName}`
        output += '\n';
        output += `Customer ID: ${currentCustomer.personalId}`
        output += '\n';
        output += `Total Money: ${currentCustomer.totalMoney}$`
        
        if(currentCustomer.transactions.length > 0){
            output += '\n';
            output += `Transactions:\n`
    
            for(let i = currentCustomer.transactions.length; i > 0; i--){
                output += `${i}. ${currentCustomer.transactions[i - 1]}`;
                output += '\n';
            }
        }
    
        return output.trim();
    }
}


let bank = new Bank("SoftUni Bank");

console.log(bank.newCustomer({firstName: "Svetlin", lastName: "Nakov", personalId: 6233267}));
console.log(bank.newCustomer({firstName: "Mihaela", lastName: "Mileva", personalId: 4151596}));

bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596,555);

console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));
