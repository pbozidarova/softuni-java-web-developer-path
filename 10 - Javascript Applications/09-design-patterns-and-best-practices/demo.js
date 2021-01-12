window.addEventListener('load', () => {
    const container = contentDiv([e('p', 'Hello, DOM!'), 
                          e('ul', [
                                li('First Item'),
                                li('Second Item'),
                                li('Third Item'),
                                li('Fourth Item')
                ])]);

    // const div = document.createElement('div');
   
    // div.textContent = 'Hello, DOM!'
   
    // const ul = document.createElement('ul');

    // const items = [
    //     e('li', 'First Item'),
    //     e('li', 'Second Item'),
    //     e('li', 'Third Item'),
    //     e('li', 'Fourth Item'),
        // document.createElement('li'),
        // document.createElement('li'),
        // document.createElement('li'),
        // document.createElement('li')
    // ];
    
    // items[0].textContent = 'First Item'
    // items[1].textContent = 'Second Item'
    // items[2].textContent = 'Third Item'
    // items[3].textContent = 'Fourth Item'

    // items.forEach(i => ul.appendChild(i));
    // div.appendChild(ul);
    const btn = button('Click Me!', () => {
        alert('You clicked!');
        btn.disabled();
    });

    document.querySelector('main').appendChild(container);
    document.querySelector('main').appendChild(btn);
});

// function element(type, content) {
//     const e = document.createElement(type);
//     if(content != undefined) {
//         e.textContent = content;
//     }
//     return e;
// }

function button(label, handler) {
    const result = e('button', label);
    result.addEventListener('click', handler)

    result.enable = () => {
        result.disabled = false;
    }
    result.disabled = () => {
        result.disabled = true;
    }

    return result;
}

function contentDiv(content){
    return div(content, { className: "wrapper" })
}

function li(content, attributes) {
    return e('li', content, attributes)
}
function div(content, attributes){
    return e('div', content, attributes)
}

function e(type, content, attributes){
    const result = document.createElement(type);

    if(attributes) {
        for (let attr of Object.keys(attributes)) {
            result[attr] = attributes[attr];
        }
    }

    result.append = append.bind(result);
    
    result.appendTo = parent => {
        parent.append(result);
        return result;
    }

    if(content !== undefined && content !== null) {
        result.append(content);
    }

    return result;
}

function append(child){
    if(typeof (child) === 'string' || typeof (child) === 'number'){
        if(child.toString().trim()[0] === '<') {
            this.innerHtml = child;
        } else {
            child = document.createTextNode(child);
            this.appendChild(child);
        }
    }else if (Array.isArray(child)) {
        for(let node of child) {
            this.appendChild(node);
        }
    }else {
        this.appendChild(child);
    }   
    return this;
}