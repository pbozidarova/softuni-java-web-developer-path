/* globals Sammy, firebase */ 
import { buyPage, createOfferPost, createPage, deleteOffer, detailsPage, editOffer, editOfferPost, editPage } from './controllers/catalog.js';
import { homePage } from './controllers/home.js'
import { loginPage, loginPost, logout, registerPage, registerPost } from './controllers/user.js';
import { getUserData } from './util.js';

const app = Sammy('#root', function(context) {
    console.log('App Context', context);
    
    //Template engine setup
    this.use('Handlebars', 'hbs');
    
    const user = getUserData();
    this.userData = {
        isLoggedIn: user ? true : false,
        ...user
    }

    //Home routes
    this.get('/home', homePage )

    //User routes
    this.get('/register', registerPage);
    
    this.get('/login', loginPage);
    this.get('/logout', logout);

    this.post('/register', registerPost);
    this.post('/login', loginPost)

    //Offers routes
    this.get('/create-offer', createPage );
    
    this.get('/edit-offer/:id', editPage);
    
    this.get('/details/:offerId', detailsPage );
    
    this.get('/delete/:offerId', deleteOffer);

    this.get('/edit/:offerId', editOffer);

    this.post('/create-offer', createOfferPost);

    this.post('/edit/:offerId', editOfferPost );

    this.get('/buy/:offerId', buyPage);
});

app.run('/home');
