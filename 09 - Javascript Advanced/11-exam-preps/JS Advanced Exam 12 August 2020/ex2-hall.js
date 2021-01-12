function solveClasses () {

    class Hall {
        constructor( capacity, name ) {
            this.capacity = capacity;
            this.name = name;
            this.events = [];
            this.occupied = 0;
        }

        eventExists(title) {
            return this.events.find(ev => ev.title == title);
        }

        hallEvent( title ) {
            if(this.eventExists(title)) {
                throw new Error("This event is already added!")
            }

            this.occupied++;
            this.events.push(title);
            return "Event is added.";
        }

        close() {
            this.events = [];
            this.occupied = 0;
            return `${this.name} hall is closed.`;
        }

        toString() {
            let output = `${this.name} hall - ${ this.capacity }`;
            if(this.occupied){
                output += `\nEvents: ${this.events.join(', ')}`;
            }
            return output.trim();
        }
    }

    class MovieTheater extends Hall {
        constructor( capacity, name, screenSize ){
            super(capacity, name);
            this.screenSize = screenSize;
            
        }

        close() {
            return super.close() + "Аll screenings are over.";
        }

        toString() {
            return super.toString() + `\n${this.name} is a movie theater with ${this.screenSize} screensize and ${this.capacity} seats capacity.`;
        }
    }

    class ConcertHall extends Hall {
        constructor( capacity, name ) {
            super(capacity, name);
            this.events = [];
            this.performers = [];
        }

        hallEvent( title, performers ) {
            
            if(this.eventExists(title)) {
                throw new Error("This event is already added!")
            }

            this.occupied++;
            this.events.push(title);
            this.performers.push(performers);
            return "Event is added.";
        }

        close() {
  
            return super.close() + "Аll performances are over.";
        }

        toString() {
            let output = `${this.name} hall - ${ this.capacity }`;
            if(this.occupied){
                output += `\nEvents: ${this.events.join(', ')}`;
                output += `\nPerformers: ${this.performers.join(', ')}.`;
            }
            return output.trim();            
        }
    }
    
    return {Hall, MovieTheater, ConcertHall}
}


let classes = solveClasses();
// let hall = new classes.Hall(20, 'Main');
// console.log(hall.hallEvent('Breakfast Ideas'));
// console.log(hall.hallEvent('Annual Charity Ball'));
// console.log(hall.toString());
// console.log(hall.close()); 
// //--------------------------------------------------------------------------------------
// let movieHall = new classes.MovieTheater(10, 'Europe', '10m');
// console.log(movieHall.hallEvent('Top Gun: Maverick')); 
// console.log(movieHall.toString());
//--------------------------------------------------------------------------------------
let concert = new classes.ConcertHall(5000, 'Diamond');        
console.log(concert.hallEvent('The Chromatica Ball', ['LADY GAGA']));  
console.log(concert.toString());
console.log(concert.close());
console.log(concert.toString());

// Event is added.
// Event is added.
// Main hall - 20
// Events: Breakfast Ideas, Annual Charity Ball
// Main hall is closed.
// --------------------------------------------------------------------------------------
// Event is added.
// Europe hall - 10
// Events: Top Gun: Maverick
// Europe is a movie theater with 10m screensize and 10 seats capacity.
// --------------------------------------------------------------------------------------
// Event is added.
// Diamond hall - 5000
// Events: The Chromatica Ball
// Performers: LADY GAGA.
// Diamond hall is closed.Аll performances are over.
// Diamond hall - 5000

