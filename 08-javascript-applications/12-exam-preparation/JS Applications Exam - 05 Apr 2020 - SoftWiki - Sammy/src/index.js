import { homePage, createPage, postCreate, detailsPage, editPage, postEdit, deleteArticle } from "./controllers/catalog.js";
import { registerPage, loginPage, postRegister, postLogin } from "./controllers/user.js";
import * as api from './data.js'
import { getUserData } from './util.js'

window.api = api;

const app = Sammy('#root', function(context) {
    
    //Template engine setup
    this.use('Handlebars', 'hbs');
    
    const user = getUserData();
    this.userData = user;
    
    //Home routes
    this.get('/', homePage );
    this.get('/home', homePage );
    this.get('/details/:id', detailsPage );

    this.get('/create', createPage );
    this.post('/create', (ctx) => {postCreate(ctx);});

    this.get('/edit/:id', editPage );
    this.post('/edit/:id', (ctx) => {postEdit(ctx);});
    this.get('/delete/:id', deleteArticle);


    //User routes
    this.get('/register', registerPage);
    this.get('/login', loginPage);
    // this.get('/logout', logout);

    this.post('/register', (ctx) => {postRegister(ctx);});
    this.post('/login', (ctx) => {postLogin(ctx);});


});

app.run();
