// In this problem, you should create a JS functonality which shows and hides the additional
// information about users.
// When one of the [Show more] buttons is clicked, the hiden information inside the div should
// be shown, only if the profile is not locked! If the current profile is locked, nothing should
// happen.
// If the hidden information is displayed and we lock the profile again, the [Hide it] button
// should not be working! Otherwise, when the profile is unlocked and we click on the [Hide it]
// button, the new fields must hide again.


function lockedProfile() {
    Array.from(document.getElementsByClassName('profile')).forEach(parent => {
        let btn = parent.querySelectorAll('button')[0];
        
        btn.addEventListener('click', () => {
            let unlock = parent.querySelectorAll('input')[1].checked;
            let hiddenDiv = parent.querySelectorAll('div')[0];
            
            if(unlock){
                if(btn.textContent == 'Show more'){
                    hiddenDiv.style.display = 'block';
                    btn.textContent = 'Hide it'
                }else{
                    hiddenDiv.style.display = 'none';
                    btn.textContent = 'Show more';
                }
            }
        })

    });
}