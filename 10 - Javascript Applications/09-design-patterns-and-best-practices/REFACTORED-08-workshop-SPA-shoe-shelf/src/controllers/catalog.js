import { errorHandler, extendContext, getUserData,DB } from '../util.js'

export function createPage(context){
    extendContext(context)
        .then(function(){ 
            this.partial('./templates/createOffer.hbs')
    });
}

export function editPage(context){
    extendContext(context)
        .then(function(){
            this.partial('./templates/editOffer.hbs')
    });
}

export function detailsPage(context){
    const { offerId } = context.params;

    DB.collection('offers')
        .doc(offerId)
        .get()
        .then(response => {
            const { uid } = getUserData()
            const actualOfferData = response.data();
            const imTheSalesman = actualOfferData.salesMan === uid;
            
            const userIndex = actualOfferData.clients.indexOf(uid);
            const imInTheClientsList = userIndex > -1;
            context.offer = {...actualOfferData, imTheSalesman, imInTheClientsList, id: offerId}
            
            extendContext(context)
                .then(function(){
                    this.partial('./templates/details.hbs')
            });
        })
}

export function deleteOffer(context){
    const { offerId } = context.params;
    
    DB.collection('offers')
        .doc(offerId)
        .delete()
        .then(() => {
            this.redirect('/home')
        })
        .catch(errorHandler);
}

export function editOffer(context){
    const { offerId } = context.params;
    DB.collection('offers')
        .doc(offerId)
        .get()
        .then(response => {
            context.offer = {id: offerId, ...response.data()}

            extendContext(context). 
                then(function(){
                    this.partial('./templates/editOffer.hbs');
                });
        })
}

export function createOfferPost(context){
    const { productName, price, imageUrl, description, brand } = context.params
    
    DB.collection('offers').add({productName, 
                                price, 
                                imageUrl, 
                                description, 
                                brand,
                                salesMan: getUserData().uid,
                                clients: [] })
    .then(createdProduct => {
        console.log(createdProduct)
        this.redirect('/home')
    })
    .catch(errorHandler);
}
export function editOfferPost(context){
    const { offerId, productName, price, brand, description, imageUrl } = context.params;

   DB.collection('offers')
        .doc(offerId)
        .get()
        .then(response => {
           return DB.collection('offers')
            .doc(offerId)
            .set({
                ...response.data(),
                productName,
                price,
                brand,
                description,
                imageUrl,
            })
            .then(response => {
                this.redirect(`#/details/${offerId}`)
            })
            .catch(errorHandler);    
        })
}

export function buyPage(context){
    const { offerId } = context.params;
    const userId = getUserData().uid;

    DB.collection('offers')
    .doc(offerId)
    .get()
    .then(response => {
        const offerData = { ...response.data() };
        offerData.clients.push(userId)
        
        return DB.collection('offers')
            .doc(offerId)
            .set(offerData)
        })
        .then(() => {
            this.redirect(`/details/${offerId}`)
        })
        .catch(errorHandler);    
}
