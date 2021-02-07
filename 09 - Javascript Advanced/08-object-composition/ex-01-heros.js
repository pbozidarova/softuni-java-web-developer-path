// Create a function returns an object with 2 methods (mage and fighter). This object should be able to create heroes (fighters and mages). 
// Every hero has a state.
// •	Fighters have name, health = 100 and stamina = 100 and every fighter can fight.  When he fights his stamina decreases by 1 and 
// the following message is printed on the console:
// `${fighter's name} slashes at the foe!`
// •	Mages also have state (name, health = 100 and mana = 100). Every mage can cast spells. When a spell is casted the mage's mana 
// decreases by 1 and the following message is printed on the console:
// `${mage's name} cast ${spell}`

solve = () => {
    const fighter = function(name = '') {
        [this.name, this.health, this.stamina] = [name, 100, 100];
        this.fight = () => {
            this.stamina--;
            console.log(`${this.name}, slashes at the foe!`);
        }
    }

    const mage = function(name = '') {
        [this.name, this.health, this.mana] = [name, 100, 100];
        this.cast = (spell) => {
            this.mana--;
            console.log(`${this.name} cast ${spell}`);
        }
    }

    return {
        fighter: (name = '') => new fighter(name),
        mage: (name = '') => new mage(name),
    };
}

let create = solve();
let warrior = create.fighter('Gosho');
warrior.fight();

let mage = create.mage('Pesho');
mage.cast('Frost nova');