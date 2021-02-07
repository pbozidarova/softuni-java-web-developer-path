// Write a timer that counts minutes and seconds. The user should be able to control it with buttons. Clicking [Start] starts the counter from zero. 
// Clicking [Stop] stops the timer. Only one of the buttons should be enabled at a time (you cannot stop the timer, if it is not running). 
// Submit only the stopwatch() function in judge.


function stopwatch() {
    let timerElement = document.getElementById('time');
    let startButtonElement = document.getElementById('startBtn');
    let stopButtonElement = document.getElementById('stopBtn');
    let interval;

    startButtonElement.addEventListener('click', function(e) {
        timerElement.textContent = '00:00';
        stopButtonElement.removeAttribute('disabled');
        e.currentTarget.setAttribute('disabled', true);

        interval = setInterval(function() {
            let currentTime = timerElement.textContent;
            let timeArray = currentTime.split(':');
            let minutes = Number(timeArray[0]);
            let seconds = Number(timeArray[1]);
            
            seconds++;
            if(seconds > 59){
                minutes++;
                seconds = 0;
            }
            timerElement.textContent = `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, 0)}`;
        }, 1000)
    })

    stopButtonElement.addEventListener('click', function(e){
        clearInterval(interval);
        startButtonElement.removeAttribute('disabled');
        e.currentTarget.setAttribute('disabled', true);
    })
}
