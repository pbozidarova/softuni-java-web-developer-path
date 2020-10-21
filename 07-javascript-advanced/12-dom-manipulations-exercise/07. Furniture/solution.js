// You will be given some furniture as an array of objects. Each object will have a name, a price and a decoration factor. 
// When the "Generate" button is clicked, add a new row to the table for each piece of furniture with image, name, price and 
// decoration factor (code example below). 
// When the "Buy" button is clicked, get all checkboxes that are marked and show in the result textbox the names of the piece 
// of furniture that were checked, separated by a comma and single space (", ") in the following format: 
// "Bought furniture: {furniture1} {furniture2}…".
// On the next line, print the total price in format: "Total price: {totalPrice}" (formatted to the second decimal point). 
// Finally, print the average decoration factor in the format: "Average decoration factor: {decFactor}"

// Input Example
// [{"name": "Sofa", "img": "https://res.cloudinary.com/maisonsdumonde/image/upload/q_auto,f_auto/w_200/img/grey-3-seater-sofa-bed-200-13-0-175521_9.jpg", "price": 150, "decFactor": 1.2}]


function solve() {
  let [generate, buy] = [...document.querySelectorAll('button')];
  let [input,output] = document.querySelectorAll('textarea');
  
  generate.addEventListener('click', () => {
      let products = JSON.parse(input.value);

      products.forEach(product => {
        let { name, img, price, decFactor } = product;
        let htmlString = `<tr>\n
        <td><img src="${img}"></td>\n
        <td><p>${name}</p></td>\n
        <td><p>${price}</p></td>\n
        <td><p>${decFactor}</p></td>\n
        <td><input type="checkbox" /></td>\n
        </tr>`
        document.querySelectorAll('tbody')[0]
                .insertAdjacentHTML("beforeEnd", htmlString);
      });
      input.value = '';
    });   
  
  buy.addEventListener('click', () => {
    let [products, prices, factors] = [[], [], []];
      [...document.querySelectorAll('tbody tr')].forEach(tr => {
        if (tr.querySelectorAll('input')[0].checked) {
            let data  = tr.querySelectorAll('p');
            products.push(data[0].textContent);
            prices.push(Number(data[1].textContent));
            factors.push(Number(data[2].textContent));
        }
      });
      let totalPrice = prices.reduce((sum, num) => sum +=num);
      let avgFactor = factors.reduce((sum, num) => sum += num) / factors.length;
      output.textContent = `Bought furniture: ${products.join(', ')}\nTotal price: ${totalPrice.toFixed(2)}\nAverage decoration factor: ${avgFactor}`;
  });
}













