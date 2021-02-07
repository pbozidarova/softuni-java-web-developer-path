// 4.	Cars
// Write a closure that can create and modify objects. All created objects should be kept and be accessible by name. You should support 
// the following functionality:
// •	create <name> - creates an object with the supplied <name>
// •	create <name> inherits <parentName> - creates an object with the given <name>, that inherits from the parent object with 
//      the <parentName>
// •	set <name> <key> <value> - sets the property with key equal to <key> to <value> in the object with the supplied <name>.
// •	print <name> - prints the object with the supplied <name> in the format "<key1>:<value1>,<key2>:<value2>…" - 
// the printing should also print all inherited properties from parent objects. Inherited properties should come after own properties.

function solve(input) {

    const carFactoryBuilder = () => {
        let cars = {};

        return {
            create: (name, inherit, parent) => cars[name] = inherit ? Object.create(cars[parent]) : cars[name] = {},
            set: (name, key, value) => cars[name][key] = value,
            print: (name) => {
                let result = [];
                for (const key in cars[name]) {
                    result.push(`${key}:${cars[name][key]}`);
                }
                console.log(result.join(', '));
            },
        }
    };

    let carFactory = carFactoryBuilder();
    
    input
        .map(x => x.split(' '))
        .forEach(([command, 
                    ...args]) => carFactory[command].apply(null, args));

}   

solve(['create c1',
'create c2 inherit c1',
'set c1 color red',
'set c2 model new',
'print c1',
'print c2']
);