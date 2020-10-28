function stopwatch() {
    let timerElement = document.getElementById('time');
    let startButtonElement = document.getElementById('startBtn');
    let endBtuttonElement = document.getElementById('stopBtn');

    startButtonElement.addEventListener('click', function(e) {
        
        
        let interval = setInterval(function() {
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

    endBtuttonElement.addEventListener('click', function(e){
        
    })
}