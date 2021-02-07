// 6.	System Components
// You will be given a register of systems with components and subcomponents. You need to build an ordered database of all 
// the elements that have been given to you.
// The elements are registered in a very simple way. When you have processed all of the input data, you must print them in a 
// specific order. For every System you must print its components in a specified order, and for every Component, you must print 
// its Subcomponents in a specified order.
// The Systems you’ve stored must be ordered by amount of components, in descending order, as first criteria, and by alphabetical 
// order as second criteria. The Components must be ordered by amount of Subcomponents, in descending order.

function solve(input){
    let result = {};

    input.forEach(line => {
        let [systemName, component, subComponent] = line.split(" | ");
        if(!result[systemName]){
            result[systemName] = {};
        }
        if(!result[systemName][component]){
            result[systemName][component] = [];
        }
        result[systemName][component].push(subComponent);
    });

    Object.entries(result).sort((curr, next) => {
        return (Object.entries(next[1]).length - Object.entries(curr[1]).length) || 
                curr[0].localeCompare(next[0]);
    }).forEach(([system, components])=> {
        console.log(system);
        Object.entries(components).sort((curr, next) => {
            return next[1].length - curr[1].length;
        }).forEach(([component, subComponent]) => {
            console.log(`|||${component}`)
            subComponent.forEach(sub => {
                console.log(`||||||${sub}`);
            });
        });
    });

}

solve(['SULS | Main Site | Home Page',
'SULS | Main Site | Login Page',
'SULS | Main Site | Register Page',
'SULS | Judge Site | Login Page',
'SULS | Judge Site | Submittion Page',
'Lambda | CoreA | A23',
'SULS | Digital Site | Login Page',
'Lambda | CoreB | B24',
'Lambda | CoreA | A24',
'Lambda | CoreA | A25',
'Lambda | CoreC | C4',
'Indice | Session | Default Storage',
'Indice | Session | Default Security']
);
