// Create a program that converts different time units. Your task is to add a click event listener to all [CONVERT] buttons. 
// When a button is clicked, read the corresponding input field, convert the value to the three other time units and display it 
// in the input fields.
// One day is equal to 24 hours/1440 minutes/86400 seconds. Whichever button we click, the input fields should change depending 
// on the added value on the left. (For example, if we write 48 hours and click convert the days, the field value should change to 2).

function attachEventsListeners() {
    let daysInput = document.getElementById('days');
    let hoursInput = document.getElementById('hours');
    let minutesInput = document.getElementById('minutes');
    let secondsInput = document.getElementById('seconds');
    
    document.getElementById('daysBtn').addEventListener('click', () => convert(+daysInput.value * (24 * 60 * 60)));
    document.getElementById('hoursBtn').addEventListener('click', () => convert(+hoursInput.value * (60 * 60)));;
    document.getElementById('minutesBtn').addEventListener('click', () => convert(+minutesInput.value * 60));;
    document.getElementById('secondsBtn').addEventListener('click', () => convert(+secondsInput.value));;
    
    function convert(sec){
        let dayOutput = sec / (24 * 60 * 60);
        let hourOutput = sec / (60 * 60);
        let minOutput = sec / 60;
        let secOutput = sec;

        daysInput.value = dayOutput
        hoursInput.value = hourOutput;
        minutesInput.value = minOutput;
        secondsInput.value = secOutput;
    }
}   