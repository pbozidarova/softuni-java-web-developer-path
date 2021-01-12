// 2.	List Processor
// Using a closure, create an inner object to process list commands. The commands supported should be the following:
// •	add <string> - adds the following string in an inner collection.
// •	remove <string> - removes all occurrences of the supplied <string> from the inner collection.
// •	print - prints all elements of the inner collection joined by ",".

function solve(input) {
    const listProcessorBuilder = function() {
        let list = [];
        return {
            ///add: text => list.push(text),
            add: text => list = [...list, text],
            //remove: text => list.splice(indexOf(text), 1),
            remove: text => list = list.filter(x => x != text),
            print: () => console.log(list.join()),
        }
    }

    let listProcessor = listProcessorBuilder();

    input
        .map(x => x.split(' '))
        .forEach(([command, argument]) => listProcessor[command](argument));
    }

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);
solve(['add pesho', 'add george', 'add peter', 'remove peter','print']);