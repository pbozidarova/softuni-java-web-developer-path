import request from './requestService.js';

const apiKey = "AIzaSyC2trdP5U5pfYkZITOdU7dGCydUhH_jnl8"; 
const baseUrl = 'https://softwiki-6cdfb-default-rtdb.firebaseio.com';

let endPoints = {
    login: `https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=${apiKey}`,
    register: `https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${apiKey}`,
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

    getData() {
        try{
            let data = JSON.parse(localStorage.getItem('auth'));
            console.log(data)
            return {
                isAuthenticated: Boolean(data.idToken),
                email: data.email || '',
                idToken: data.idToken,
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
