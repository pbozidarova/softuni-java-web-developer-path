class ChristmasDinner {
    
    constructor(budget){
        if(budget < 0) {
            throw new Error("The budget cannot be a negative number");
        }
        this.budget = budget;
        this.dishes = [];
        this.products = [];
        this.guests = {};
    }

    shopping(product){
        if(this.budget < product[1]) {
            throw new Error("Not enough money to buy this product");
        }

        this.budget -= product[1];
        this.products.push(product[0]);
        return `You have successfully bought ${product[0]}!`;
    }

    recipes({recipeName, productsList}){
        productsList.forEach(neededProduct => {
            if(!this.products.find(availableProduct => availableProduct == neededProduct)){
                throw new Error("We do not have this product");
            }
        });
        
        this.dishes.push({recipeName, productsList});

        return `${recipeName} has been successfully cooked!`;
    }

    inviteGuests(name, dish){
        if(!this.dishes.find(dishCooked => dishCooked.recipeName == dish)){
            throw new Error("We do not have this dish");
        }
        if(Object.keys(this.guests).find(guest => guest == name)){
            throw new Error("This guest has already been invited");
        }

        this.guests[name] = dish;
        return `You have successfully invited ${name}!`;
    }

    showAttendance() {
        let output = '';
        
        Object.entries(this.guests).forEach( ([guest, dish]) => {
            let products = this.dishes.find(d => d.recipeName == dish).productsList.join(', ');
            output += `${guest} will eat ${dish}, which consists of ${products}\n`;
        })
        return output.trim();
    }
}


let dinner = new ChristmasDinner(300);

dinner.shopping(['Salt', 1]);
dinner.shopping(['Beans', 3]);
dinner.shopping(['Cabbage', 4]);
dinner.shopping(['Rice', 2]);
dinner.shopping(['Savory', 1]);
dinner.shopping(['Peppers', 1]);
dinner.shopping(['Fruits', 40]);
dinner.shopping(['Honey', 10]);

dinner.recipes({
    recipeName: 'Oshav',
    productsList: ['Fruits', 'Honey']
});
dinner.recipes({
    recipeName: 'Folded cabbage leaves filled with rice',
    productsList: ['Cabbage', 'Rice', 'Salt', 'Savory']
});
dinner.recipes({
    recipeName: 'Peppers filled with beans',
    productsList: ['Beans', 'Peppers', 'Salt']
});

dinner.inviteGuests('Ivan', 'Oshav');
dinner.inviteGuests('Petar', 'Folded cabbage leaves filled with rice');
dinner.inviteGuests('Georgi', 'Peppers filled with beans');

console.log(dinner.showAttendance());

// Ivan will eat Oshav, which consists of Fruits, Honey
// Petar will eat Folded cabbage leaves filled with rice, which consists of Cabbage, Rice, Salt, Savory
// Georgi will eat Peppers filled with beans, which consists of Beans, Peppers, Salt
