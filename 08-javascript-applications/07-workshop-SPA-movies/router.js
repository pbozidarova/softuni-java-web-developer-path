const routes = {
    'home': 'home-template',
    'login': 'login-form-template',
    'register': 'register-form-template',
    'add-movie': 'add-movie-form-template',
    'details': 'movie-details-template',
    'edit-movie': 'edit-movie-form-template',
}

const router = async (path) => {
    let appElement = document.getElementById('app');
    let templateData = authService.getData();

    switch(path) {
        case 'home':
            templateData.movies = await movieService.getAll();
            break;
        case 'logout':
            authService.logout();
            return navigate('home');
        default:
            break
    }
    
    
    let templateId = routes[path];
    
    let template = Handlebars.compile(document.getElementById(routes[path]).innerHTML);

    appElement.innerHTML = template(templateData);
}

const navigate = (path) => {
    history.pushState({}, '', path);

    router(path);
} 