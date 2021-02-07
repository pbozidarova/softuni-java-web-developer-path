import view  from './services/viewService.js';

const app = Sammy('#root', function(context) {
    
    //Template engine setup
    this.use('Handlebars', 'hbs');
    
    //Home routes
    this.get('/', view.home );
    this.get('/home', view.home );
    this.get('/dashboard', view.dashboard );
    this.get('/details/:id', view.details );

    this.get('/create', view.create );
    this.post('/create', (ctx) => {view.postCreate(ctx);});

    this.get('/edit/:id', view.edit );
    this.post('/edit/:id', (ctx) => {view.postEdit(ctx);});

    this.get('/delete/:id', view.deleteOffer);
    this.post('/delete/:id', (ctx) => {view.postDeleteOffer(ctx);});
    
    this.get('/buy/:id', view.buyOffer);

    //User routes
    this.get('/register', view.register);
    this.post('/register', (ctx) => {view.postRegister(ctx);});
    
    this.get('/login', view.login);
    this.post('/login', (ctx) => {view.postLogin(ctx);});
    
    this.get('/profile', view.profile);
    // this.post('/profile', (ctx) => {view.postLogin(ctx);});

    this.get('/logout', view.logout);

});

app.run();