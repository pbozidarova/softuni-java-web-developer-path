const UserModel = firebase.auth();
const DB = firebase.firestore();

const app = Sammy('#root', function() {
    this.use('Handlebars', 'hbs');

    this.get('/home', function(context){  
        DB.collection('offers')
            .get()
            .then(response => {
                
                context.offers = response.docs.map((offer) => { return{id:offer.id, ...offer.data()} });

                // response.forEach(offer => {
                //     context.offers.push({ id: offer.id, ...offer.data() })
                // });
                            
                extendContext(context)
                    .then(function(){
                        this.partial('./templates/home.hbs');
                    });
            })
            .catch(errorHandler);
    });

    //User routes
    this.get('/register', function(context){
        extendContext(context).then(function(){
            this.partial('./templates/register.hbs')
        });
    });
    this.get('/login', function(context){
        extendContext(context).then(function(){
            this.partial('./templates/login.hbs')
        });
    });
    this.get('/logout', function(context){
        UserModel.signOut()
            .then(response => {
                clearUserData();
                this.redirect('/home');
            })
            .catch(errorHandler);
    });

    this.post('/register', function(context){
        const {email, password, rePassword} = context.params;
        if(password !== rePassword) {
            return;
        }

        UserModel.createUserWithEmailAndPassword(email, password)
            .then((userData) => {
                console.log(userData);
                this.redirect('/home')
            })
            .catch(errorHandler);
    });
    this.post('/login', function(context){
        const { email, password } = context.params;
        UserModel.signInWithEmailAndPassword(email, password)
            .then((userData) => {
                saveUserData(userData);
                this.redirect('/home');
            })
            .catch(errorHandler);
    })

    //Offers routes
    this.get('/create-offer', function(context){
        extendContext(context)
            .then(function(){ 
                this.partial('./templates/createOffer.hbs')
        });
    });

    this.get('/edit-offer/:id', function(context){
        extendContext(context)
            .then(function(){
                this.partial('./templates/editOffer.hbs')
        });
    });

    this.get('/details/:offerId', function(context){
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
    });

    this.post('/create-offer', function(context){
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
    });

    this.get('/delete/:offerId', function(context){
        const { offerId } = context.params;
        
        DB.collection('offers')
            .doc(offerId)
            .delete()
            .then(() => {
                this.redirect('/home')
            })
            .catch(errorHandler);
    })

    this.get('/edit/:offerId', function(context){
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
    });

    this.post('/edit/:offerId', function(context){
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
    });

    this.get('/buy/:offerId', function(context){
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
    })
});

(() => {
    app.run('/home');
})();

function extendContext(context){
    let user = getUserData();
    context.isLoggedIn = Boolean(user);
    context.userEmail = user ? user.email : '';

    return context.loadPartials({
            'header': './partials/header.hbs',
            'footer': './partials/footer.hbs'
    });
}

function errorHandler(error){
    console.log(error);
}

function saveUserData(data){
    const { user: { email, uid } } = data;
    this.localStorage.setItem('user', JSON.stringify({email, uid}));
}

function getUserData(){
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
}

function clearUserData(){
    this.localStorage.removeItem('user');
}