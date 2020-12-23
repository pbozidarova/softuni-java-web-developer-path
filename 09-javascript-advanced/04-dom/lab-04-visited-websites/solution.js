// 4.	Visited Sites
// In this problem, you should create a JS functionality that keeps track of how many times a
// specific site has been visited.

function solve() {

    [...document.querySelectorAll('.link-1 a')].forEach(site => {
      site.addEventListener('click', onLinkElemenetClick);
    });

    function onLinkElemenetClick(e){
        let paragraphElement = e.currentTarget.nextElementSibling;
        let visitedCount = Number(paragraphElement.innerText.split(' ')[1]);
        visitedCount++;

        paragraphElement.innerText = `visited ${visitedCount} times`;
    }
  
}