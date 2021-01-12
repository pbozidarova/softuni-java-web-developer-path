import authService from './services/authService.js';
import articleService from './services/articleService.js';
import router from './router.js';

export const onLoginSubmit = (e) => {
    e.preventDefault();

    let formData = new FormData(e.target);

    let email = formData.get('email');
    let password = formData.get('password');

    // let email = document.getElementById('email').value;
    // let password = document.getElementById('login-pass').value;

    authService.login(email, password)
        .then(data => {
            console.log(data);
            console.log(`You are logged with ${data.email}`);
            
            router('/');
        });
}

export const onRegisterSubmit = (e) => {
    e.preventDefault();

    let formData = new FormData(e.target);

    let email = formData.get('email');
    let password = formData.get('password');

    authService.register(email, password)
        .then(data => {
            console.log(data);
            console.log(`You are registered!`);
        });
}
export const onCreateSubmit = (e) => {
    e.preventDefault();

    let formData = new FormData(e.target);

    let title = formData.get('title');
    let category = formData.get('category');
    let content = formData.get('content');

    articleService.create({
        title,
        category,
        content
    }).then(res => {
        router('/');
    });

}