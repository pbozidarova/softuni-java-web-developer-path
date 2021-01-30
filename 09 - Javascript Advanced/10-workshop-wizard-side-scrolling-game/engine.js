let keys = {};

const initialState = (options) => ({
    player: {
        x: 150,
        y: 150,
        width: 0,
        height: 0,
        w: 0,
        h: 0,
        lastTimeFiredFireball: 0,
    },
    scene: {
        isActiveGame: true,
        score: 0,
        lastCloudSpawn: 0,
        lastBugSpawn: 0,
        ...options,

    },
    clouds: [],
    attacks: [],
    bugs: [],
});

const nextClouds = (state) => state.clouds;
const nextPlayer = (state) => state.player;
const nextScene = (state) => state.scene;
const nextAttacks = (state) => state.attacks
            .filter(a => {        
                if (a.x + state.scene.attackWidth > state.scene.areaWidth) {
                    // removeEl(a.el)
                    return false;
                }
                return true;
            })
            .map(a => ({...a, x: a.x + game.speed * game.fireBallMultiplier}));

const nextBugs = (state) => state.bugs
    .filter(b => {
        if( b.x + state.scene.bugHeight <= 0 ){
            //removeEl(b.el);
            return false;
        }
        return true;
    })
    .map(b => {
        b.x -= game.speed * 3;
        return b;
    });

const next = (state) => ({
    player: nextPlayer(state),
    scene: nextScene(state),
    clouds: nextClouds(state),
    attacks: nextAttacks(state),
    bugs: nextBugs(state)
});

function isCollision(firstElement, secondElement){
    let firstRect = firstElement.getBoundingClientRect();
    let secondRect = secondElement.getBoundingClientRect();

    return !(firstRect.top > secondRect.bottom || 
            firstRect.bottom < secondRect.top ||
            firstRect.right < secondRect.left ||
            firstRect.left > secondRect.right);
}

function gameOverAction(){
    state.scene.isActiveGame = false;
    gameOver.classList.remove('hide');
}

function addFireball(state) {
    let fireBall = document.createElement('div');
    fireBall.classList.add('fire-ball');
    fireBall.style.top = (state.player.y + state.player.height / 3 - 5 )+ 'px';
    fireBall.x = state.player.x + state.player.width;
    fireBall.style.left = fireBall.x + 'px';

    state.attacks.push({
        x: state.player.x,
        y: state.player.y + state.player.height / 3 - 5,
        el: fireBall,
        
    });

    gameArea.appendChild(fireBall);
}

function onKeyDown(e) {
    keys[e.code] = true;
}

function onKeyUp(e) {
    keys[e.code] = false;
}
