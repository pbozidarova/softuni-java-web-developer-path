// You will be given some products that you should be able to add to your cart. Each product will have a name, picture and a price.
// When the "Add" button is clicked, append the current product to the textarea in the following format: 
// "Added {name} for {money} to the cart.\n". 
// When the button "Checkout" is clicked, calculate the total money that you need to pay for the products that are currently in 
// your cart. Append the result to the textarea in the following format: 
// "You bought {list} for {totalPrice}."
// The list should contain only the unique products, separated by ", ". The total price should be rounded to the second decimal point.
// Also, after clicking over "Checkout" and every from above is done you should disable all buttons. (You can't add products or 
// checkout again, if once checkout button is clicked)

function solve() {
   let addButtons = document.querySelectorAll('.add-product');
   let resultArea = document.querySelector('textarea');
   
   let boughtProducts = [];
   let boughtProductsPrices = {'Bread': 0.80,
                          'Milk': 1.09,
                          'Tomatoes': 0.99,
                         };
   let totalPrice = 0;

   addButtons.forEach(btn => btn.addEventListener('click', e => {
      let output = '';

      let product = e.target.parentNode.previousElementSibling.firstElementChild.innerText;
      let price = Number(e.target.parentNode.nextElementSibling.innerText);

      boughtProducts.push(product);
      totalPrice += price;
      
      boughtProducts
                  .forEach(prd => {               
                     output += `Added ${prd} for ${boughtProductsPrices[prd]} to the cart.\n`;
                  });
      
      output += `You bought ${[...new Set(boughtProducts)].join(', ')} for ${totalPrice.toFixed(2)}.`;
      
      resultArea.innerHTML = output;
      console.log(totalPrice);
   }));

   document.querySelector('.checkout').addEventListener('click', disableButtos);

   function disableButtos() {
      addButtons.forEach(btn => btn.disabled = true);
   }

   
}