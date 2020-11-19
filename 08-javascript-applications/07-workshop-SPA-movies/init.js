function addEventListeners() {
    let navigationTemplate = Handlebars.compile(document.getElementById('navigation-template').innerHTML)
    let movieCard = Handlebars.compile(document.getElementById('movie-card-template').innerHTML)
    
    Handlebars.registerPartial('navigation-template', navigationTemplate);
    Handlebars.registerPartial('movie-card', movieCard);

    //navigate(location.pathname == '/' ? 'home' : location.pathname.slice(1));
    navigate('home')
}

function navigateHandler(e) {
    e.preventDefault();

    if(e.target.tagName != 'A'){
        return;
    }
    let url = new URL(e.target.href);

    navigate(url.pathname.slice(1));
}

function onLoginSubmit(e) {
    e.preventDefault();

    console.log(document.forms['login-form']);
    let formData = new FormData(document.forms['login-form']);

    let email = formData.get('email');
    let password = formData.get('password');

    authService.login(email, password)
        .then(data => {
            navigate('home')
        });
}

function onRegisterSubmit(e) {
    e.preventDefault();

    console.log(document.forms['register-form']);
    let formData = new FormData(document.forms['register-form']);

    let email = formData.get('email');
    let password = formData.get('password');
    let repeatPassword = formData.get('repeatPassword');

    if(password !== repeatPassword) {
        showMessage('errorBox','block', 'Password does not match the value in the Repeat password field!', 0 );            
        return;
    }

    authService.register(email, password)
        .then(data => {
            showMessage('successBox','block', 'Successful registration!', 1);    
            console.log(data);
            authService.login(email, password)
        });
}

function showMessage(box, value, message, notifNumber) {

    let notificationsBoxElement = document.querySelectorAll('.notifications')[notifNumber];
    let errorBoxElement = document.getElementById(box);
    
    notificationsBoxElement.style.display = value;
    errorBoxElement.innerText = message;

}

function onAddMovieSubmit(e){
    e.preventDefault();

    let formData = new FormData(document.forms['add-movie-form']);

    let title = formData.get('title');
    let description = formData.get('description');
    let imageUrl = formData.get('imageUrl');

    //if(title == '' || description == '' || imageUrl == '')

    movieService.add({
        title, 
        description, 
        imageUrl,
    }).then(res => {
        navigate('home');
    })

}

addEventListeners();