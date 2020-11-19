const UserModel = firebase.auth();
const DB = firebase.firestore();

const router = Sammy('#main', function(){

    this.use('Handlebars', 'hbs'); //IMPORTANT

    //GET
    this.get('/home', function(context) {
        const userInfo = localStorage.getItem('userInfo');

        if(userInfo){
            const { uid, email} = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }

        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'footer': '../templates/common/footer.hbs'
        })
        .then(function() {
            this.partial('../templates/home/home.hbs')
        });
    });
    this.get('/about', function(context) {
        const userInfo = localStorage.getItem('userInfo');

        if(userInfo){
            const { uid, email} = JSON.parse(userInfo);
            context.loggedIn = true;
            context.email = email;
        }

        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'footer': '../templates/common/footer.hbs'
        })
        .then(function() {
            this.partial('../templates/about/about.hbs')
        });
    });
    this.get('/catalog', function(context){
        const userInfo = localStorage.getItem('userInfo');

        if(userInfo){
            const { uid, email} = JSON.parse(userInfo);
            context.loggedIn = true;
            context.hasNoTeam = true;
            context.email = email;
        }
        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'footer': '../templates/common/footer.hbs',
            'team': '../templates/catalog/team.hbs',
        })
        .then(function() {
            this.partial('../templates/catalog/teamCatalog.hbs')
        });

    })
    this.get('/create-team', function(context){
        const userInfo = localStorage.getItem('userInfo');

        if(userInfo){
            const { uid, email} = JSON.parse(userInfo);
            context.loggedIn = true;
            context.hasNoTeam = true;
            context.email = email;
        }
        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'footer': '../templates/common/footer.hbs',
            'createForm': './templates/create/createForm.hbs'
        })
        .then(function() {
            this.partial('../templates/create/createPage.hbs')
        });
    })
    this.get('/login', function(context) {
        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'footer': '../templates/common/footer.hbs',
            'loginForm': '../templates/login/loginForm.hbs'
        })
        .then(function() {
            this.partial('../templates/login/loginPage.hbs')
        });
    });
    this.get('/register', function(context){
        this.loadPartials({
            'header': '../templates/common/header.hbs',
            'footer': '../templates/common/footer.hbs',
            'registerForm': '../templates/register/registerForm.hbs'
        })
        .then(function(){
            this.partial('./templates/register/registerPage.hbs')
        });
    });
    this.get('/logout', function(context){
        
        UserModel.signOut()
            .then(response => {
                localStorage.removeItem('userInfo');
                context.redirect('/home');
            })
            .catch(err => console.log(err));
    });
    //POST
    this.post('/register', function(context){
        const { email, password, repeatPassword } = context.params;

        if(password !== repeatPassword) {
            let err = document.querySelector('#errorBox');
            
            err.textContent = "Passwords should match eachother.";
            err.style.display = 'block';
            return;
        }

        UserModel.createUserWithEmailAndPassword(email, password)
        .then((createdUser) => {
            console.log(createdUser);
            this.redirect('/login');
        })
        .catch((error) => {
          var errorCode = error.code;
          var errorMessage = error.message;
          console.log(error);
        });

        console.log(email);
        console.log(password);
    });
    // this.post('/create-team', function(context){
    //     const { name, comment } = context.params;

    //     // UserModel.createUserWithEmailAndPassword(email, password)
    //     // .then((createdUser) => {
    //     //     console.log(createdUser);
    //     //     this.redirect('/login');
    //     // })
    //     // .catch((error) => {
    //     //   var errorCode = error.code;
    //     //   var errorMessage = error.message;
    //     //   console.log(error);
    //     // });

    //     DB.collection("teams").add({
    //         name,
    //         comment
    //     })
    //     .then(function(docRef) {
    //         console.log("Document written with ID: ", docRef.id);
    //     })
    //     .catch(function(error) {
    //         console.error("Error adding document: ", error);
    //     });

    //     // console.log(email);
    //     // console.log(password);
    // });
    this.post('/login', function(context){
        const { email, password } = context.params;

        UserModel.signInWithEmailAndPassword(email, password)
            .then(({user: {uid, email}}) => {
                localStorage.setItem('userInfo', 
                                        JSON.stringify({ uid, email }));

                context.redirect('/home');
            })
            .catch((e) => console.log(e))


    });
});

(() => {
    router.run('#/home');
})();

// function loadPartials(context) {
//     return context.loadPartials({
//                 'header': '../templates/common/header.hbs',
//                 'footer': '../templates/common/footer.hbs'
//             })
// }