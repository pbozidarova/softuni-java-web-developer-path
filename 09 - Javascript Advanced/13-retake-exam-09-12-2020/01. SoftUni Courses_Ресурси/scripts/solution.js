function solve() {

   let [jsfundamentals, jsadvanced, jsapplications, jsweb ] = Array.from(document.querySelectorAll('input[type=checkbox]'));
   let [onsite, online] = Array.from(document.querySelectorAll('input[type=radio]'));
   let signUpButton = document.querySelector('#availableCourses button');
   let ulElement = document.querySelector('#myCourses .courseBody ul');
   // jsfundamentals.checked ? 

   signUpButton.addEventListener('click', (e) => {
      ulElement.innerHTML = '';
      let moduleDiscount = jsfundamentals.checked && jsadvanced.checked && jsapplications.checked;
      let jsAdvDiscount = jsadvanced.checked && jsfundamentals.checked;
      let onlineDisc = online.checked;

      const course = {
         jsfundamentals: 170,
         jsadvanced: jsAdvDiscount ? 180 - 180 * 0.1 : 180,
         jsapplications: 190,
         jsweb: 490,
      }

      let price = 0;
      let flag = false;
      if(moduleDiscount) {
         price = course.jsfundamentals + course.jsadvanced + course.jsapplications;
         price -= price * 0.06;
      } else {
         price += jsfundamentals.checked ? course.jsfundamentals : 0;
         price += jsadvanced.checked ? course.jsadvanced : 0;
         price += jsapplications.checked ? course.jsapplications : 0;
      }

      price += jsweb.checked ? course.jsweb : 0;

      if(moduleDiscount && jsweb.checked){
         flag = true;
      }

      if(online.checked){
         price -= price * 0.06;
      }

      if(jsfundamentals.checked) {
         let text = jsfundamentals.parentElement.querySelector('label').innerText.split(' - ')[0].replace(' ', '-');
         createLiAndAppendIt(text, ulElement)
      }
      if(jsadvanced.checked) {
         let text = jsadvanced.parentElement.querySelector('label').innerText.split(' - ')[0].replace(' ', '-');
         createLiAndAppendIt(text, ulElement)
      }
      if(jsapplications.checked) {
         let text = jsapplications.parentElement.querySelector('label').innerText.split(' - ')[0].replace(' ', '-');
         createLiAndAppendIt(text, ulElement)
      }
   
      if(jsweb.checked) {
         let text = jsweb.parentElement.querySelector('label').innerText.split(' - ')[0].replace(' ', '-');
         createLiAndAppendIt(text, ulElement)
      }

      if(flag){
         createLiAndAppendIt('HTML and CSS', ulElement)
      }

      document.querySelector('.courseFoot p').innerText = `Cost: ${Math.floor(price).toFixed(2)} BGN`;
   });

   function createLiAndAppendIt(course, ulElement){
      let liElement = document.createElement('li');
      liElement.innerText = course;

      ulElement.appendChild(liElement);

   }

}

solve();