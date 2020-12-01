import { errorHandler, extendContext, getUserData, clearUserData, saveUserData, UserModel } from '../util.js'

export async function registerPage (context){
    await extendContext(context);

    this.partial('./templates/register.hbs');
    
}

export async function loginPage(context){
    await extendContext(context);
    this.partial('./templates/login.hbs')
}

export function logout(context){
    UserModel.signOut()
        .then(response => {
            clearUserData();
            this.redirect('/home');
        })
        .catch(errorHandler);
}

export function registerPost(context) {
    const {email, password, rePassword} = context.params;
    if(password !== rePassword) {
        return;
    }
    UserModel.createUserWithEmailAndPassword(email, password)
        .then((userData) => {
            console.log(userData);
            this.redirect('/home')
        })
        .catch(errorHandler);
}

export function loginPost (context){
    const { email, password } = context.params;
    UserModel.signInWithEmailAndPassword(email, password)
        .then((userData) => {
            saveUserData(userData);
            this.redirect('/home');
        })
        .catch(errorHandler);
}