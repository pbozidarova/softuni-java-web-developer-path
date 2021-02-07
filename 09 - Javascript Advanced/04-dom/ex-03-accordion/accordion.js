// An html file is given and your task is to show more/less information by clicking a [ADD] button 
// (it is not an actual button, but a span that has an onclick event attached to it). When [More] button is clicked, 
// it reveals the content of a hidden div and changes the text of the button to [Less]. When the same link is clicked again 
// (now reading Less), hide the div and change the text of the link to More. Link action should be toggleable 
// (you should be able to click the button infinite amount of times).


function toggle() {
    let btn = document.getElementsByClassName('button')[0];
    let info = document.getElementById('extra');

    if(btn.textContent === 'More'){
        btn.textContent = 'Less';
        info.style.display = 'block';
    } else{
        btn.textContent = 'More';
        info.style.display = 'none';
    }
    
}