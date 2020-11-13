// 1.	Order Rectangles
// You will be passed a few pairs of widths and heights of rectangles, create objects to represent the rectangles. 
// The objects should additionally have two functions area - that returns the area of the rectangle and compareTo - 
// that compares the current rectangle with another and produces a number signifying if the current rectangle is smaller 
// (negative number), equal (0) or larger (positive number) than the other rectangle. 

function solve(input) {
    let result = input.map(([width, height]) => ({ 
        width, 
        height,
        area: () => width * height,
        compareTo(rect) {
            return rect.area() - this.area() || rect.width - this.width;
        }
    })).sort((a, b) => a.compareTo(b));
    return result;
}

// solve([[10,5],[5,12]]);
solve([[10,5], [3,20], [5,12]]);