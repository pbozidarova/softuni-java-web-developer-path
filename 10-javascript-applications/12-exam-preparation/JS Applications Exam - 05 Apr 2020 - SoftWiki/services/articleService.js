import request from './requestService.js';
import authService from './authService.js'

const baseUrl = 'https://softwiki-6cdfb-default-rtdb.firebaseio.com';

const urlBuilder = (resource) => {
    
    return `${baseUrl}/${resource}.json?auth=${authService.getData().idToken}`;
}

export default {
    async create(article) {
        let res = await request.post(urlBuilder('articles'), article);
        
        return res;
    },

    async getAll() {
        let articles = await request.get(urlBuilder('articles'));
        
        return Object.keys(articles).map(key => ({_id: key, ...articles[key]}));
    }
}