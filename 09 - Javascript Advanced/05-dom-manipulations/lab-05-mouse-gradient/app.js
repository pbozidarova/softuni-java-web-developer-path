// Write a program that detects and displays how far along a gradient the user has moved their mouse. The result should be rounded down and 
// displayed as a percentage inside the <div> with ID "result". 
// Submit only the attachGradientEvents() function in judge. 

function attachGradientEvents() {
    let gradientElement = document.getElementById('gradient');
    let resultElement = document.getElementById('result');

    gradientElement.addEventListener('mousemove', e => {

        let offset = e.offsetX;
        let width = e.target.clientWidth -1;
        let percent = Math.trunc((offset / width) * 100);
        resultElement.innerHTML = `${percent}%`;
    });

    gradientElement.addEventListener('mouseout', e => {
        resultElement.textContent = '';
    })
}