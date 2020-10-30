// 9.	Point Distance
// Write a JS class that represents a Point. It has x and y coordinates as properties, that are set through the constructor, 
// and a static method for finding the distance between two points, called distance().
// Input
// The distance() method should receive two Point objects as parameters.
// Output
// The distance() method should return a number, the distance between the two point parameters.
// Submit the class definition as is, without wrapping it in any function.


function solve(){
    
    class Point{
        constructor(x, y){
            this.x = x;
            this.y = y;
        }

        static distance(p1, p2){
            let xOffset = Math.abs(p1.x - p2.x);
            let yOffset = Math.abs(p1.y - p2.y);
            
            let distance = Math.sqrt(xOffset ** 2 + yOffset ** 2);
            return distance
        }
    }
    
    let p1 = new Point(5, 5);
    let p2 = new Point(9, 8);
    console.log(Point.distance(p1, p2));
}

solve();