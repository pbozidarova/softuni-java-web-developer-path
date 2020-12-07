class Parking {
    constructor ( capacity )  {
        this.capacity = capacity;
        this.vehicles = [];
        this.occupied = 0;
    }

    car(carNumber) {
       return this.vehicles.find(vehicle => vehicle.carNumber == carNumber);
    }


    addCar( carModel, carNumber ){
        if(this.capacity == this.occupied){
            throw new Error("Not enough parking space.");
        }

        let car = {carModel, carNumber, payed: false};
        
        this.vehicles.push(car);
        this.occupied++;

        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    }

    removeCar( carNumber ) {
        if(!this.car(carNumber)) {
            throw new Error("The car, you're looking for, is not found.")
        }

        if(!this.car(carNumber).payed) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`)
        }

        let indexOfCars = this.vehicles.indexOf(this.car(carNumber));
        this.vehicles.splice(indexOfCars, 1);
        this.occupied--;

        return `${carNumber} left the parking lot.`
    }

    pay( carNumber ) {
        if(!this.car(carNumber)) {
            throw new Error(`${carNumber} is not in the parking lot.`)
        }

        if(this.car(carNumber).payed) {
            throw new Error(`${carNumber}'s driver has already payed his ticket.`)
        }

        this.car(carNumber).payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`;

    }

    getStatistics(carNumber) {
        let output = '';
        
        if(carNumber){
            let foundCar = this.car(carNumber)
            output += `${foundCar.carModel} == ${foundCar.carNumber} - ${foundCar.payed ? 'Has payed' : 'Not payed'}`;
        }else{
            this.vehicles.sort((a, b) => a.carModel.localeCompare(b.carModel));
            output = `The Parking Lot has ${ this.capacity - this.occupied } empty spots left.\n`;
            this.vehicles.forEach(carData => {
                output += `${carData.carModel} == ${carData.carNumber} - ${carData.payed ? 'Has payed' : 'Not payed'}\n`
            });
        }

        return output.trim();
    }
}

const parking = new Parking(12);

console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.getStatistics());

console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3691CA"));

// The Volvo t600, with a registration number TX3691CA, parked.
// The Parking Lot has 11 empty spots left.
// Volvo t600 == TX3691CA - Not payed
// TX3691CA's driver successfully payed for his stay.
// TX3691CA left the parking lot.
