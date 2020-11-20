const routes = {
    'home': 'home-template',
    'login': 'login-form-template',
    'register': 'register-form-template',
    'add-movie': 'add-movie-form-template',
    'details': 'movie-details-template',
    'edit-movie': 'edit-movie-form-template',
}

const router = async (fullPath) => {
    let [path, id] = fullPath.split('/');
    let appElement = document.getElementById('app');
    let templateData = authService.getData();

    switch(path) {
        case 'home':
            templateData.movies = await movieService.getAll();
            break;
        case 'logout':
            authService.logout();
            return navigate('home');
        case 'details':
            let movieDetails = await movieService.getOne(id);
            console.log(movieDetails);
            Object.assign(templateData, movieDetails);
            break;
        default:
            break
    }
    
    
    let templateId = routes[fullPath];
    
    let template = Handlebars.compile(document.getElementById(routes[path]).innerHTML);

    appElement.innerHTML = template(templateData);
}

const navigate = (path) => {
    history.pushState({}, '', path);

    router(path);
} 