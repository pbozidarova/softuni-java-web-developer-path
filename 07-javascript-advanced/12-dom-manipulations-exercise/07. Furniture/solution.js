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
    [...document.querySelectorAll('button')][0].addEventListener('click', () => {
      let input = document.querySelectorAll('textarea')[0];
      let products = JSON.parse(input.value);

      products.forEach(product => {
        let {name, img, price, decFactor} = product;
        let htmlString = `<tr>
                              <td>
                                  <img src="${img}">
                              </td>
                              <td>
                                  <p>${name}</p>
                              <td>
                                  <p>${price}</p>
                              </td>
                              <td>
                                  <p>${decFactor}</p>
                              </td>
                              <td>
                                  <input type="checkbox"/>
                              </td>
                          </tr>`
        document.querySelectorAll('tbody')[0].insertAdjacentHTML("beforeEnd", htmlString);
      });
      input.value = '';
    });   
}