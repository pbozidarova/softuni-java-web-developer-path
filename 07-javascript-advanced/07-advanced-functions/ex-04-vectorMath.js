// Write several functions for peрforming calculations with vectors in 2D space  and collect them all in a single object (namespace), 
// so they don’t pollute the global scope. Implement the following functions:
// •	add(vec1, vec2) - Addition of two vectors 
// •	multiply(vec1, scalar) - Scalar multiplication  
// •	length(vec1) - Vector length 
// •	dot(vec1, vec2) - Dot product of two vectors  
// •	cross(vec1, vec2) - Cross product of two vectors  
// The math-savvy may notice that the given cross product formula results in a scalar, instead of a vector - we’re only measuring the length 
// of the resulting vector, since cross product is not possible in 2D, it will exist purely in the z-dimension. If you don’t know what 
// this all means, ignore this paragraph, it’s irrelevant to the solution.
vectorObject = {
    add: ([x1,y1], [x2,y2]) => [x1+x2, y1+y2],
    multiply: (vector, scalar) => vector.map(el => el*scalar),
    length: ([x,y]) => Math.sqrt(x ** 2 + y ** 2),
    dot: ([x1,y1], [x2,y2]) => x1*x2 + y1*y2,
    cross: ([x1,y1], [x2,y2]) => x1*y2 - x2*y1,
}

console.log(vectorObject.add([1, 1], [1, 0]));
console.log(vectorObject.multiply([3.5, -2], 2));
console.log(vectorObject.length([3, -4]));
console.log(vectorObject.dot([1, 0], [0, -1]));
console.log(vectorObject.cross([3, 7], [1, 0]));