function solve(){
    let startTimes = [1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12];
    let endTimes = [4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14];

    let activities = [];

    for(let i = 0; i < startTimes.length; i++){
        activities.push({startTime: startTimes[i], endTime: endTimes[i]});
    }

    activities.sort((a, b) => a.endTime - b.endTime);    
    let last = activities[0];
    
    console.log(last.startTime + '-' + last.endTime);
    activities.forEach(act => {
        if(act.startTime >= last.endTime){
            last = act;
            console.log(last.startTime + '-' + last.endTime);
        }
    })
}

solve();