import request from './requestService.js';
import authService from './authService.js'

const baseUrl = `https://retakeexam-aa5b4-default-rtdb.firebaseio.com/`;

const urlBuilder = (resource) => {
    return `${baseUrl}/${resource}.json?auth=${authService.getLocalStorageData().idToken}`;
}

export default {
    async create(offer) {
        const offerData  = Object.assign( {_ownerId: authService.getLocalStorageData().localId}, offer);

        let res = await request.post(urlBuilder('offers'), offerData);
        
        return res;
    },

    async getUserPurchases(userId) {
        let purchasesCount = await request.get(urlBuilder(`purchases/${userId}`));

        return purchasesCount;
    },

    async setUserPurchases(userId, purchasesCount) {
        return await request.put( urlBuilder(`purchases/${userId}`), purchasesCount);
    },

    async getAll() {
        let offers = await request.get(urlBuilder('offers'));
        
        if(!offers){
            return [];
        } else {
            return Object.keys(offers).map(key => ({_id: key, ...offers[key]}));
        }
    },

    async getById(id) {
        let offer = await request.get(urlBuilder(`offers/${id}`));

        offer._id = id;

        return offer;
    },

    async editById(id, offer) {
        return await request.patch( urlBuilder(`offers/${id}`), offer);
    },

    async deleteById(id){
        return request.delete( urlBuilder(`offers/${id}`) );
    }
}