import monkeys from './monkeys.js'

console.log(monkeys);

const elements = {
    allMonkeys: () => document.querySelector('div.monkeys')
}

fetch('./monkeys.hbs')
    .then(r => r.text())
    .then(monkeyTemplatesSrc => {

        const monkeyTemplate = Handlebars.compile(monkeyTemplatesSrc);
        const resultHtml = monkeyTemplate({ monkeys });

        elements.allMonkeys().innerHTML = resultHtml;
        
        attachEventListener();
    })
    .catch(e => console.error(e));


    function attachEventListener(){
        elements.allMonkeys().addEventListener('click', (e) => {
            const { target } = e;   
            if(target.nodeName !== 'BUTTON' || target.textContent !== 'Info'){
                return;
            }
            const p = target.parentNode.querySelector('p')

            if(p.style.display === 'none'){
                p.style.display = 'block';
            }else{
                p.style.display = 'none';
            }
        });
    }