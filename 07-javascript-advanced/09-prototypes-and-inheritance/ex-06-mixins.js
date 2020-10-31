// Using the classes from the last task, write two mixins (functions which attach some functionality to passed in classes' prototypes) 
// to extend their functionality. You need to support the following mixins:
// •	computerQualityMixin(classToExtend)  - a function that attaches the following functions to the prototype of the passed in class. 
//     o	getQuality() - returns a number equal to the computer's (processorSpeed + RAM + hardDiskSpace) / 3
//     o	isFast() - if processorSpeed > (ram / 4) returns true, otherwise false
//     o	isRoomy()-if hardDiskSpace > Math.floor(ram * processorSpeed) returns true, otherwise false
// •	styleMixin(classToExtend) - a function that attaches the following functions to the prototype of the passed in class:
//     o	isFullSet() - if the computer's manufacturer, keyboard's manufacturer and monitor's manufacturer all have the same name returns true, 
//     otherwise false.
//     o	isClassy() - if the computer battery's expected life is 3 years or more and the computer's color is either "Silver" or "Black" and the 
//     computer's weight is less than 3 kilograms returns true, otherwise returns false .


function createMixins() {
    function computerQualityMixin(classToExtend) {
        classToExtend.prototype.getQuality = function () {
            return (this.processorSpeed + this.ram + this.hardDiskSpace) / 3;
        };

        classToExtend.prototype.isFast = function () {
            return this.processorSpeed > (this.ram / 4);
        };

        classToExtend.prototype.isRoomy = function () {
            return this.hardDiskSpace > Math.floor(this.ram * this.processorSpeed);
        }
    }

    function styleMixin(classToExtend) {
        classToExtend.prototype.isFullSet = function () {
            return this.manufacturer === this.keyboard.manufacturer && this.manufacturer === this.monitor.manufacturer;
        };

        classToExtend.prototype.isClassy = function () {
            return this.battery.expectedLife >= 3 &&
                (this.color === 'Silver' || this.color === 'Black') &&
                this.weight < 3;
        };
    }

    return {
        computerQualityMixin,
        styleMixin
    }
}