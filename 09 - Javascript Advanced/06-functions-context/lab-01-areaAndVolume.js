// Write a function which calculates the area and the volume of a figure, which is defined by its coordinates 
// (x, y, z). 

function solve(area, vol, input){
    let figures = JSON.parse(input);

    let result = figures.map(function(figure){
        return {
            area: Math.abs(area.call(figure)),
            volume: Math.abs(vol.call(figure)),
        }
    });
    return result;
}

function area() {
    return this.x * this.y;
};
function vol() {
    return this.x * this.y * this.z;
};
    

let res = solve(area, vol, `[
    {"x":"1","y":"2","z":"10"},
    {"x":"7","y":"7","z":"10"},
    {"x":"5","y":"2","z":"10"}
    ]`
);
console.log(res);

    // solve(area, vol, '[
    //     {"x":"10","y":"-22","z":"10"},
    //     {"x":"47","y":"7","z":"-5"},
    //     {"x":"55","y":"8","z":"0"},
    //     {"x":"100","y":"100","z":"100"},
    //     {"x":"55","y":"80","z":"250"}
    //     ]'
    // );  