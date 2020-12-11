import { addPartials, getUserID, categoryMap, mapCategories } from '../util.js';
import { createArticle, editArticle, getAll, getById, deleteById } from '../data.js';

export async function homePage() {
    //load header and footer
    await addPartials(this);

    this.partials.article = await this.load('/templates/catalog/article.hbs');
    
    const data = mapCategories(await getAll());
    const context = data;

    context.user = this.app.userData;

    this.partial('/templates/catalog/homePage.hbs', context);
}

export async function detailsPage() {
    //load header and footer
    await addPartials(this);
   
    const article = await getById(this.params.id);
    const context = {
        user: this.app.userData,
        article,
        canEdit: article._ownerId == getUserID(),
    };

    //context.user = this.app.userData;

    this.partial('/templates/catalog/detailsPage.hbs', context);
}

export async function editPage() {
    //load header and footer
    await addPartials(this);
   
    const article = await getById(this.params.id);

    if(article._ownerId !== getUserID()){
        this.redirect('/home');
    }else {

        const context = {
            user: this.app.userData,
            article
        };
    
        context.user = this.app.userData;

        this.partial('/templates/catalog/editPage.hbs', context);
    }

}

export async function postEdit(ctx){
    const {title, category, content} = ctx.params;
    
    try { if(!title || !category || !content) {
             throw new Error('All fields are required');
         }else if ( !categoryMap.hasOwnProperty(category) ){
            throw new Error('Invalid category!');
         }
         const result = await editArticle( ctx.params.id, {
                title, 
                category, 
                content
         });
         ctx.redirect('/home');
     } catch (err) {
         alert(err.message);
     }
}


export async function createPage() {
    await addPartials(this);

    this.partials.article = await this.load('/templates/catalog/article.hbs');
    
    const context = {
        user: this.app.userData,
        
    };

    this.partial('/templates/catalog/createPage.hbs', context);
}

export async function postCreate(ctx) {
    const {title, category, content} = ctx.params;
    console.log(categoryMap);
    try { if(!title || !category || !content) {
             throw new Error('All fields are required');
         }else if ( !categoryMap.hasOwnProperty(category) ){
            throw new Error('Invalid category!');
         }
         const result = await createArticle({
                title, 
                category, 
                content
         });
         ctx.redirect('/home');
     } catch (err) {
        console.log(err.message);
     }
}

export async function deleteArticle() {
    
    try {
        const id = this.params.id;
        const result = deleteById(id);
    
        this.redirect('/home');

    }
    catch (err) {
        console.log(err.message);
    }
}