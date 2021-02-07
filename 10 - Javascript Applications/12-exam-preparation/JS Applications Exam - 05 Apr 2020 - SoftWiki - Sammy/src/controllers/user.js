import { addPartials } from '../util.js';
import { register, login } from '../data.js';

export async function registerPage() {
    //load header and footer
    await addPartials(this);

    this.partial('/templates/user/registerPage.hbs');
}

export async function loginPage() {
    //load header and footer
    await addPartials(this);

    this.partial('/templates/user/loginPage.hbs');
}

export async function postRegister(ctx) {
    const {email, password, rePass} = ctx.params;

   try { if(!email || !password || !rePass) {
            throw new Error('All fields are required');
        } else if(password !== rePass){
            throw new Error('Passwords don\'t match!');
        }

        const result = await register(email, password);
        ctx.redirect('/home');
    } catch (err) {
        alert(err.message);
    }
}

export async function postLogin(ctx) {
    const {email, password} = ctx.params;

   try { if(!email || !password) {
            throw new Error('All fields are required');
        } else {
            const result = await login(email, password);
            ctx.app.userData = result;
            ctx.redirect('/home');
        }
    } catch (err) {
        alert(err.message);
    }
}