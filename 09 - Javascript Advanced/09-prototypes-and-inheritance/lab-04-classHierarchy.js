// 4.	Class Hierarchy
// Write a function that returns 3 classes - Figure, Circle and Rectangle. 
// Figure:
// •	Should have property units ("m", "cm", "mm") with default value "cm"
// •	Has method changeUnits that sets different units for that figure 
// Circle:
// •	Extends Figure
// •	Has a property radius
// •	Overrides area getter to return the area of the Circle (PI * r * r)
// •	toString() - should return a string representation of the figure in the format 
// "Figures units: {type} Area: {area} - radius: {radius}"
// Rectangle:
// •	Extends Figure
// •	Has properties width and height
// •	Overrides area getter to return the area of the Rectangle (width * height)
// •	toString() - should return a string representation of the figure in the format
// "Figures units: {type} Area: {area} - width: {width}, height: {height}"
// Note:  All Parameters Passed in the Constructors Are in Centimeters ("cm")
// Input / Output
// There will be no input. Your function should return an object containing the Figure, Circle and Rectangle classes.

function solve() {
    class Figure{
        units = 'cm'
        changeUnits(unit) { this.units = unit };
    }

    class Circle extends Figure {
        constructor(radius) {
            super();
            this.radius = radius;
        }

        get area() {
            return Math.PI * unitRecalculation(this.units, this.radius) ** 2;
        }

        toString() {
            return `Figures units: ${this.units} Area: ${this.area} - radius: ${unitRecalculation(this.units, this.radius)}`
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, units) {
            super();
            this.width = width;
            this.height = height;
            this.changeUnits(units);
        }

        get area() {                                  
            return unitRecalculation(this.units, this.width) * unitRecalculation(this.units, this.height);
        }

        toString() {
            return `Figures units: ${this.units} Area: ${this.area} - width: ${unitRecalculation(this.units, this.width)}, height: ${unitRecalculation(this.units, this.height)}`;
        }
    }   

    function unitRecalculation(unit, figureProperty){
        
        return  unit == 'mm' ? figureProperty * 10 : 
                unit == 'm'  ? figureProperty / 10 
                                    : figureProperty;
    }


        // let c = new Circle(5);
        // console.log(c.area); // 78.53981633974483
        // console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5

        let r = new Rectangle(3, 4, 'mm');
        console.log(r.area); // 1200 
        console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40

        r.changeUnits('cm');
        console.log(r.area); // 12
        console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4

        // c.changeUnits('mm');
        // console.log(c.area); // 7853.981633974483
        // console.log(c.toString()) // Figures units: mm Area: 7853.981633974483 - radius: 50


    return  {
        Figure,
        Circle,
        Rectangle,
    }

}

solve()