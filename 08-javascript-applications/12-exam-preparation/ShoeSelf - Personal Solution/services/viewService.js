import elementService from './elementService.js';
import auth from './authService.js';

async function addPartials(ctx) {
    const partials = await Promise.all([
        ctx.load('/view/partials/header.hbs'),
        ctx.load('/view/partials/footer.hbs')
    ]);

    ctx.partials = {
        header: partials[0],
        footer: partials[1],
    };
};

export default {

    async login() {
            //load header and footer
        await addPartials(this);

        this.partial('/view/login.hbs');
    },

    async postLogin(ctx) {
        const {email, password} = ctx.params;

        try { if(!email || !password) {
                throw new Error('All fields are required');
            } else {
                const result = await auth.login(email, password);
                // ctx.app.userData = result;
                ctx.redirect('/home');
            }
        } catch (err) {
            console.log(err.message);
        }
    },

    async register() {
        //load header and footer
        await addPartials(this);

        this.partial('/view/register.hbs');
    },

    async postRegister(ctx){
        //params to be specified
        // let formData = new FormData(ctx.target)
        // let email = formData.get('email');
        // let password = formData.get('password');
    
        const {email, password, rePass} = ctx.params;

        try { if(!email || !password || !rePass) {
                throw new Error('All fields are required');
            } else if(password !== rePass){
                throw new Error('Passwords don\'t match!');
            }
            const result = await auth.register(email, password);
            console.log(result);
            ctx.redirect('/home');
        } catch (err) {
            console.log(err.message);
        }
    },

    async logout(){
        auth.logout();
        this.redirect('/home');
    },

    async home() {
        //load header and footer
        await addPartials(this);

        //load single element view - partial template as well
        this.partials.element = await this.load('/view/element.hbs');
        
        //take all the elements and pass it to the context
        // const data = mapCategories(await getAll());
        const elements = await elementService.getAll();
        const context = elements;
        
        context.js = elements.filter(x => x.category == 'JavaScript')
        context.java = elements.filter(x => x.category == 'Java')
        context.csharp = elements.filter(x => x.category == 'C#')
        context.python = elements.filter(x => x.category == 'Python')

        context.user = auth.getLocalStorageData();
    
        this.partial('/view/home.hbs', context);
    },

    async create() {
        await addPartials(this);
        // this.partials.article = await this.load('/templates/catalog/article.hbs');
        
        const context = {
            user: this.app.userData,
        };
    
        this.partial('/view/create.hbs', context);
    },

    async postCreate(ctx) {
        //element properties to be specified
        const {title, category, content} = ctx.params;

        try { if(!title || !category || !content) {
                 throw new Error('All fields are required');
            //  }else if ( !categoryMap.hasOwnProperty(category) ){
            //     throw new Error('Invalid category!');
             }
             const result = await elementService.create({
                    title, 
                    category, 
                    content
             });
             ctx.redirect('/home');
         } catch (err) {
             alert(err.message);
         }
    },

    async details() {
        //load header and footer
        await addPartials(this);

        const element = await elementService.getById(this.params.id);

        const context = {
            user: auth.getLocalStorageData(),
            element,
            canEdit: element._ownerId == auth.getLocalStorageData().localId,
        };

        this.partial('/view/details.hbs', context);
    },

    async edit() {
        //load header and footer
        await addPartials(this);
        const element = await elementService.getById(this.params.id);
    
        //only the owner can edit it
        if(element._ownerId !== auth.getLocalStorageData().localId){
            this.redirect('/home');
        }else {
            const context = {
                user: auth.getLocalStorageData(),
                element
            };
            
            this.partial('/view/edit.hbs', context);
        }
    },

    async postEdit(ctx) {
        //element properties to be specified
        const {title, category, content} = ctx.params;
    
        try { 
            
            if(!title || !category || !content) {
                 throw new Error('All fields are required');
            //  }else if ( !categoryMap.hasOwnProperty(category) ){
            //     throw new Error('Invalid category!');
            }
             const result = await elementService.editById( ctx.params.id, {
                    title, 
                    category, 
                    content
             });
             ctx.redirect('/home');
         } catch (err) {
            console.log(err.message);
         }
    },

    async deleteElement(){
        try {
            const id = this.params.id;

            const result = await elementService.deleteById(id);
            this.redirect('/home');
        }
        catch (err) {
            console.log(err.message);
        }
    },
    
}