import { errorHandler, extendContext, DB } from '../util.js'

export async function homePage(context){  
    let offers;

    try {
        const response = await DB.collection('offers').get();
        offers = response.docs.map((offer) => ({ id:offer.id, ...offer.data() })); 
    } catch (err) {
        errorHandler(err)
    }

    const data = Object.assign({ offers }, this.app.userData);

    await extendContext(context)
    this.partial('./templates/home.hbs', data);
    

    // .then(response => {    
    //     context.offers = response.docs.map((offer) => { return{id:offer.id, ...offer.data()} }); 
    //     })
    //     .catch(errorHandler);
};