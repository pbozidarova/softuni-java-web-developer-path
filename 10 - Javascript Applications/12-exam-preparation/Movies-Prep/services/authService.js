import request from './requestService.js';

const apiKey = "AIzaSyD7h2m4NObM0btiFMix86XE8dNzBFJfB9s"; 
const baseUrl = `https://retakeexam-aa5b4-default-rtdb.firebaseio.com/`;

let endPoints = {
    login: `https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=${apiKey}`,
    register: `https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${apiKey}`,
    elements: 'elements',
    element_by_id: 'elements/',
}

export default {
    async login(email, password) {
        let data = await request.post( endPoints.login, {
                email,
                password
            }
        );

        localStorage.setItem('auth', JSON.stringify(data));
        
        return data;
    },

    async register(email, password, repeatPassword) {
        let data = await request.post(endPoints.register, {
            email,
            password
            }
        );
  
        //  localStorage.setItem('auth', JSON.stringify(data));
         
         return data;
     },

    //getData() {
    getLocalStorageData() {
        try{
            let data = JSON.parse(localStorage.getItem('auth'));
            // console.log(data)
            return {
                isAuthenticated: Boolean(data.idToken),
                email: data.email || '',
                idToken: data.idToken,
                localId: data.localId,
            };
        } catch (error) {
            return {
                isAuthenticated: false,
                email: ''
            }
        }
    },
    
    logout() {
        localStorage.setItem('auth', '');
    }
}
