import { html, render } from '../node_modules/lit-html/lit-html.js';

import authService from './services/authService.js';
import articleService from './services/articleService.js';

import { onLoginSubmit, onRegisterSubmit, onCreateSubmit } from './eventListeners.js';

import layout from '../views/layout.js';
import home from '../views/home.js';
import login from '../views/login.js';
import register from '../views/register.js';
import createMovie from '../views/create.js';
import movieDetails from '../views/details.js';
import edit from '../views/edit.js';
import notFound from '../views/not-found.js';
import articleSection from './views/article.js';

const routes = [
    {
        path: /^\/$/i,
        template: (props) => {
            let template = home;
            let url = '/';
            
            if (!props.isAuthenticated) {
                template = login;
                url = '/login';
            }

            history.pushState({}, '', url);
            return template(props);
        },
        getData: articleService.getAll,
    },
    {
        path: /^\/logout$/i,
        template: (props) => {
            //logout
            authService.logout();
            
            history.pushState({}, '', '/');
            return login(props);
        }
    },
    {
        path: /^\/login$/i,
        template: login,
        context: {
            onLoginSubmit
        }
    },
    {
        path: /^\/register$/i,
        template: register,
        context: {
            onRegisterSubmit
        }
    },
    {
        path: /^\/not-found$/i,
        template: notFound,
    },
    {
        path: /^\/edit$/i,
        template: edit,
    },
    {
        path: /^\/create$/i,
        template: createMovie,
        context: {
            onCreateSubmit
        }
    },
    {
        path: /^\/details\/(?<id>\.+)$/i,
        template: movieDetails,
        getData: articleService.getOne,
    }

];

const router = (path) => {
    history.pushState({}, '', path);

    let route = routes.find(x => x.path.test(path)) || routes.find(x => x.path.test('/not-found'));
    let context = route.context;

    let params = route.path.exec(path).gourps;

    let userData = authService.getData();

    if(route.getData) {
        route.getData().then(data => {
            render(layout(route.template, { navigtionHandler, onLoginSubmit , ...userData, ...context, data, params}), document.getElementById('app'));        
        });
    }
    console.log(navigtionHandler);
    render(layout(route.template, { navigtionHandler, onLoginSubmit , ...userData, ...context, params}), document.getElementById('app'));
};


function navigtionHandler(e){
    if(e.target.tagName == 'A') {
        console.log(omg);
        e.preventDefault();
        
        let url = new URL(e.target.href);
        
        router(url.pathname);
    }
}

export default router;