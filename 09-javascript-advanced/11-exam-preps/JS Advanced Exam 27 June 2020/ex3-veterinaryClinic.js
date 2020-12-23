    class VeterinaryClinic {
        clients = [];
        
        constructor(clinickName, capacity) {
            this.clinicName = clinickName;
            this.capacity = capacity;
            this.currentWorkload = 0;
            this.totalProfit = 0;
        }

    getPet(owner, petName) {
        if(!owner) {
            return;
        }
        return owner.pets.find(x => x.petName == petName);
    }
 
    getClient(ownerName) {
        let client = this.clients.find(x => x.ownerName == ownerName);

        return client;  
    }

    newCustomer(ownerName, petName, kind, procedures) {
        if(this.currentWorkload >= this.capacity) {
            throw new Error("Sorry, we are not able to accept more patients!");
        }

        //Check if currently in clinic/ throw Error
        let currentOwner = this.getClient(ownerName);
        let currentPet = this.getPet(currentOwner, petName);

        if (currentOwner && currentPet){
            if(currentPet.procedures.length > 0) {
                throw new Error (`This pet is already registered under ${currentOwner.ownerName} name! ${currentPet.petName} is on our lists, waiting for ${currentPet.procedures.join(', ')}.`)
            }else {
                currentPet.procedures = procedures;
            }
        } else if(!currentOwner) {
                    currentOwner = {
                        ownerName,
                        pets: [],
                    };
                    this.clients.push(currentOwner);
                }

        //Check if client is already registered
        //Add pet to owner
        currentOwner.pets.push({
            petName,
            kind, 
            procedures,
        });

        //Modify workload
        this.currentWorkload++;
        
        //return welcome message
        return `Welcome ${petName}!`
    }

    onLeaving (ownerName, petName) {
        let currentOwner = this.getClient(ownerName);
 
        if(!currentOwner) {
            throw new Error ("Sorry, there is no such client!");
        }

        let currentPet = this.getPet(currentOwner, petName);

        if(!currentPet || currentPet.procedures.length == 0) {
            throw new Error(`Sorry, there are no procedures for ${ petName }!`)
        }

        //Add new price $500.00
        this.totalProfit += currentPet.procedures.length * 500;

        //update workload
        this.currentWorkload--;
        
        //clear procedures of the current pet
        currentPet.procedures = [];

        //return
        return `Goodbye ${ currentPet.petName }. Stay safe!`
    }


    toString () {
        let busyPercentage = Math.floor(this.currentWorkload / this.capacity * 100);
         
        let result = `${this.clinicName} is ${busyPercentage}% busy today!`;
        result += '\n'
        result += `Total profit: ${this.totalProfit.toFixed(2)}$`;
        
        this.clients.sort( (a, b) => a.ownerName.localeCompare(b.ownerName));

        for (const client of this.clients) {
            client.pets.sort(( (a, b) => a.petName.localeCompare(b.petName)));

            result += '\n';
            result += `${client.ownerName} with:`
            for (const pet of client.pets) {
                result += '\n';
                result += `---${ pet.petName } - a ${ pet.kind.toLowerCase() } that needs: ${pet.procedures.join(', ')}`;
            }
        }

        return result.trim();
    }

}


let clinic = new VeterinaryClinic('SoftCare', 10);
console.log(clinic.newCustomer('Jim Jones', 'Tom', 'Cat', ['A154B', '2C32B', '12CDB']));
console.log(clinic.newCustomer('Anna Morgan', 'Max', 'Dog', ['SK456', 'DFG45', 'KS456']));
console.log(clinic.newCustomer('Jim Jones', 'Tiny', 'Cat', ['A154B'])); 
console.log(clinic.onLeaving('Jim Jones', 'Tiny'));
console.log(clinic.toString());
clinic.newCustomer('Jim Jones', 'Sara', 'Dog', ['A154B']); 
console.log(clinic.toString());

// Welcome Tom!
// Welcome Max!
// Welcome Tiny!
// Goodbye Tiny. Stay safe!
// SoftCare is 20% busy today!
// Total profit: 500.00$
// Anna Morgan with:
// ---Max - a dog that needs: SK456, DFG45, KS456
// Jim Jones with:
// ---Tiny - a cat that needs: 
// ---Tom - a cat that needs: A154B, 2C32B, 12CDB
// SoftCare is 30% busy today!
// Total profit: 500.00$
// Anna Morgan with:
// ---Max - a dog that needs: SK456, DFG45, KS456
// Jim Jones with:
// ---Sara - a dog that needs: A154B
// ---Tiny - a cat that needs: 
// ---Tom - a cat that needs: A154B, 2C32B, 12CDB
