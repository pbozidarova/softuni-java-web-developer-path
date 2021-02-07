import offerService from './offerService.js';
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

function successNotification(message) {
    let pElement = document.getElementById("successNotification");
    
    pElement.style.display = "block";
    pElement.innerText = message;

    pElement.addEventListener('click', () => {
        pElement.style.display = 'none';
    });
 
    setTimeout(function () {
        pElement.style.display = "none";
 
    }, 3 * 1000);

};
 
function errorNotification(message) {
    let pElement = document.getElementById("errorNotification");

    pElement.style.display = "block";
    pElement.innerText = message;

    pElement.addEventListener('click', () => {
        pElement.style.display = 'none';
    });
 
    setTimeout(function () {
        pElement.style.display = "none";
 
    }, 3 * 1000);

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
                errorNotification('The email and password must be non-empty string!');
            } else {
                const result = await auth.login(email, password);

                if(result.error){
                    errorNotification(result.error.message);
                }else{
                    successNotification('You have successfully logged in!')
                    ctx.redirect('/home');
                }
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
        const {email, password, repeatPassword} = ctx.params;

        try { if(!email || !password || !repeatPassword) {
                errorNotification('The email and password must be non-empty string!');
            } else if(password !== repeatPassword){
                errorNotification('The re-password should be equal to the password');
            }else{
                const result = await auth.register(email, password);

                if(result.error){
                    errorNotification(result.error.message);
                }else{
                    successNotification('You have successfully registered and are now logged in!')
                    ctx.redirect('/home');
                }
            }
               
        } catch (err) {
            console.log(err.message);
        }
    },

    async logout(){
        auth.logout();
        this.redirect('/home');
    },

    async profile() {
        //load header and footer
        await addPartials(this);

        const purchases = await offerService.getUserPurchases(auth.getLocalStorageData().localId);
        let count = purchases ? purchases.count : 0;

        const context = {
            user: auth.getLocalStorageData(),
            count,
        };

        this.partial('/view/profile.hbs', context);
    },

    async home() {
        //load header and footer
        await addPartials(this);

        const context = {
            user: auth.getLocalStorageData(),
        }
        
        this.partial('/view/home.hbs', context);
    },
    async dashboard() {
        //load header and footer
        await addPartials(this);

        //load single offer view - partial template as well
        this.partials.offer = await this.load('/view/offer.hbs');
        
        //take all the offers and pass it to the context
        // const data = mapCategories(await getAll());
        const offers = await offerService.getAll();
        
        const offersWithIndexes = offers.map(offer => {
            return Object.assign({
                index: offers.indexOf(offer), 
                canEditDelete: offer._ownerId == auth.getLocalStorageData().localId
            }, offer);
        });

        const context = {   
            offers: offersWithIndexes,
            user: auth.getLocalStorageData(),
        }
        
        // context.js = offers.filter(x => x.category == 'JavaScript');
        // context.java = offers.filter(x => x.category == 'Java');
        // context.csharp = offers.filter(x => x.category == 'C#');
        // context.python = offers.filter(x => x.category == 'Python');

        this.partial('/view/dashboard.hbs', context);
    },

    async create() {
        await addPartials(this);
        
        const context = {
            user: auth.getLocalStorageData(),
        };
    
        this.partial('/view/create.hbs', context);
    },

    async postCreate(ctx) {
        const { product, description, price, pictureUrl } = ctx.params;
        
        try { if(!product || !description || !price) {
                errorNotification('The input fields for product, description and price should be non-empty strings!');
             } else if(!pictureUrl.startsWith('https://')){
                errorNotification('The input field for imageUrl, must be valid url (starts with "https://")!');
             }else{
                const result = await offerService.create({
                    product, 
                    description, 
                    price,
                    pictureUrl
                 });
    
                if(result.error){
                    errorNotification(result.error.message);
                }else{
                    successNotification('You have successfully created an offer!')
                    ctx.redirect('/dashboard');
                }
             }

         } catch (err) {
             console.log(err.message);
         }
    },

    async details() {
        //load header and footer
        await addPartials(this);

        const offer = await offerService.getById(this.params.id);

        const context = {
            user: auth.getLocalStorageData(),
            offer,
            canEdit: offer._ownerId == auth.getLocalStorageData().localId,
        };

        this.partial('/view/details.hbs', context);
    },

    async edit() {
        //load header and footer
        await addPartials(this);
        const offer = await offerService.getById(this.params.id);
    
        //only the owner can edit it
        // if(offer._ownerId !== auth.getLocalStorageData().localId){
        //     this.redirect('/home');
        // }else {
            const context = {
                user: auth.getLocalStorageData(),
                offer
            };
            
            this.partial('/view/edit.hbs', context);
        // }
    },

    async postEdit(ctx) {
        const { product, description, price, pictureUrl } = ctx.params;
        
        try { if(!product || !description || !price) {
                errorNotification('The input fields for product, description and price should be non-empty strings!');
             } else if(!pictureUrl.startsWith('https://')){
                errorNotification('The input field for imageUrl, must be valid url (starts with "https://")!');
             }else{

             const result = await offerService.editById( ctx.params.id, {
                product, 
                description, 
                price,
                pictureUrl
             });
             successNotification('You have successfully edited this offer!')
             ctx.redirect('/dashboard');
            }
         } catch (err) {
            console.log(err.message);
         }
    },

    async deleteOffer() {
        //load header and footer
        await addPartials(this);
        const offer = await offerService.getById(this.params.id);
    
            const context = {
                user: auth.getLocalStorageData(),
                offer
            };
            
            this.partial('/view/delete.hbs', context);
        // }
    },

    async postDeleteOffer(ctx){
        try {
            const id = ctx.params.id;

            const result = await offerService.deleteById(id);
            successNotification('You have successfully deleted this offer!')
            ctx.redirect('/dashboard');
        }
        catch (err) {
            console.log(err.message);
        }
    },
    
    async buyOffer(){
        try {
            const userId = auth.getLocalStorageData().localId;
            let value = 0;

            const purchasesCount = await offerService.getUserPurchases(userId);
            
            value = 1 + (purchasesCount ? purchasesCount.count : 0);
            
            const result = await offerService.setUserPurchases( userId, {
                count: value,
            });
            successNotification('You have successfully bought this product!')
            this.redirect('/dashboard')
         } catch (err) {
            console.log(err.message);
         }
    },
}