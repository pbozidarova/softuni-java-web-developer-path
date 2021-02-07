// You need to implement the class hierarchy for a computer business, here are the classes you should create and support:
// •	Keyboard  class that contains:
//      o	manufacturer - string property for the name of the manufacturer
//      o	responseTime - number property for the response time of the Keyboard
// •	Monitor class that contains:
//      o	manufacturer - string property for the name of the manufacturer
//      o	width - number property for the width of the screen
//      o	height - number property for the height of the screen
// •	Battery class that contains:
//      o	manufacturer - string property for the name of the manufacturer
//      o	expectedLife - number property for the expected years of life of the battery
// •	Computer - abstract class that contains:
//      o	manufacturer - string property for the name of the manufacturer
//      o	processorSpeed - a number property containing the speed of the processor in GHz
//      o	ram - a number property containing the RAM of the computer in Gigabytes
//      o	hardDiskSpace - a number property containing the hard disk space in Terabytes
// •	Laptop - class extending the Computer class that contains:
//      o	weight - a number property containing the weight of the Laptop in Kilograms
//      o	color - a string property containing the color of the Laptop
//      o	battery - an instance of the Battery class containing the laptop's battery. There should be a getter and a setter for the property 
//          and validation that the passed in argument is actually an instance of the Battery class.
// •	Desktop - concrete class extending the Computer class that contains:
//      o	keyboard - an instance of the Keyboard class containing the Desktop PC's Keyboard. There should be a getter and a setter for the 
//          property and validation that the passed in argument is actually an instance of the Keyboard class.
//      o	monitor - an instance of the Monitor class containing the Desktop PC's Monitor. There should be a getter and a setter for 
//          the property and validation that the passed in argument is an instance of the Monitor class.
// Attempting to instantiate an abstract class should throw an Error, attempting to pass an object that is not of the expected instance 
// (ex. an object that is not an instance of Battery to the laptop as a battery) should throw a TypeError.

function generateComputerClasses() {
    class PcComponent {
        constructor(manufacturer) {
            if (new.target === PcComponent) {
                throw new Error;
            }

            this.manufacturer = manufacturer;
        }
    }

    class Keyboard extends PcComponent {
        constructor(manufacturer, responseTime) {
            super(manufacturer);

            this.responseTime = responseTime;
        }
    }

    class Monitor extends PcComponent {
        constructor(manufacturer, width, height) {
            super(manufacturer);

            this.width = width;
            this.height = height;
        }
    }

    class Battery extends PcComponent {
        constructor(manufacturer, expectedLife) {
            super(manufacturer);

            this.expectedLife = expectedLife;
        }
    }

    class Computer extends PcComponent {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace) {
            if (new.target === Computer) {
                throw new Error;
            }

            super(manufacturer);

            this.processorSpeed = processorSpeed;
            this.ram = ram;
            this.hardDiskSpace = hardDiskSpace;
        }
    }

    class Laptop extends Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, weight, color, battery) {
            super(manufacturer, processorSpeed, ram, hardDiskSpace);

            this.weight = weight;
            this.color = color;
            this.battery = battery;
        }

        get battery() {
            return this._battery;
        }

        set battery(value) {
            if (!(value instanceof Battery)) {
                throw new TypeError;
            }

            this._battery = value;
        }
    }

    class Desktop extends Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, keyboard, monitor) {
            super(manufacturer, processorSpeed, ram, hardDiskSpace);

            this.keyboard = keyboard;
            this.monitor = monitor;
        }

        get keyboard() {
            return this._keyboard;
        }

        set keyboard(value) {
            if (!(value instanceof Keyboard)) {
                throw new TypeError;
            }

            this._keyboard = value;
        }

        get monitor() {
            return this._monitor;
        }

        set monitor(value) {
            if (!(value instanceof Monitor)) {
                throw new TypeError;
            }

            this._monitor = value;
        }
    }

    return {
        Battery,
        Keyboard,
        Monitor,
        Computer,
        Laptop,
        Desktop
    }
}