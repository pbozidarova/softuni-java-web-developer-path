import { getUserData } = './util.js';

const apiKey = "AIzaSyD7h2m4NObM0btiFMix86XE8dNzBFJfB9s";
const databaseUrl = `https://jsapplications-2d93d.firebaseio.com`;

const endpoints = {
    LOGIN: 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=',
    REGISTER: 'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=',
    OFFERS: 'offers',
}

function host(url) {
    let result = databseUrl + url + '.json';
    const auth = localStorage.getItem('auth');
    if(auth !== null) {
        result += `?auth=${JSON.parse(auth).idToken}`;
    }
    return result;
}

async function request (url, method, body) {
        let options  = {
            method,    
        };

        if(body) {
            Object.assign(options, {
                headers: { 
                'content-type': 'application/json'
                },
                body: JSON.stringify(body)
            });
        };

        let response = await fetch(url, options); 

        let data = await response.json();

        return data;
}

async function get(url) {
    return request(url, 'GET');
}
async function post(url, body) {
    return request(url, 'POST', body);
}
async function del(url) {
    return request(url, 'DELETE')
}
async function patch(url, body) {
    return request(url, 'PATCH', body);
}

// const authService = {
    async function login(email, password) {
       let response = await post(endpoints.LOGIN + apiKey, {
        email,
        password
       });

        let data = await response.json();

        localStorage.setItem('auth', JSON.stringify(data));
        
        return data;
    }

    async function register(email, password, repeatPassword) {
        let response =  await post(endpoints.REGISTER + apiKey, {
            email,
            password
           });

         let data = await response.json();
 
        //  localStorage.setItem('auth', JSON.stringify(data));
         
         return data;
     }

    // getData() {
    //     try{
    //         let data = JSON.parse(localStorage.getItem('auth'));
    //         console.log(data)
    //         return {
    //             isAuthenticated: Boolean(data.idToken),
    //             email: data.email || '',
    //             idToken: data.idToken
    //         };
    //     } catch (error) {
    //         return {
    //             isAuthenticated: false,
    //             email: ''
    //         }
    //     }
    // },
    
    // logout() {
    //     localStorage.setItem('auth', '');
    // }
// }

window.login = login;
window.register = register;

async function getOffers(){
    return get(databaseUrl + endpoints.OFFERS)
}

async function createOffer(offer){
    return post(host(endpoints.OFFERS), offer);
}

window.getOffers;
window.createOffer;

// const movieService = {
//     async add(movieData) {
//         let res = await request(`${databaseUrl}/movies.json`, 'POST' , movieData); 

//         return res;
//     },
//     async getAll(){
//         let res = await request(`${databaseUrl}/movies.json`, 'GET'); 

//         // ({key, ...res[key]})
//         //Object.assign(res[key], {key})
//         return Object.keys(res).map(key => ({key, ...res[key]}));
//     },
//     async getOne(id) {
//         let res = await request(`${databaseUrl}/movies/${id}.json`, 'GET');

//         return res;
//     },
//     async deleteMovie(id){
//         let res = await request(`${databaseUrl}/movies/${id}.json`, 'DELETE');
        
//         return res;
//     },
//     async editMovie(id, movie){
//         let res = await request(`${databaseUrl}/movies/${id}.json`, 'PUT', movie);

//         return res;
//     }
// }