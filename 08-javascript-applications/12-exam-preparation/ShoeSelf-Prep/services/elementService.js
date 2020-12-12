import request from './requestService.js';
import authService from './authService.js'

const baseUrl = `https://retakeexam-aa5b4-default-rtdb.firebaseio.com/`;

const urlBuilder = (resource) => {
    return `${baseUrl}/${resource}.json?auth=${authService.getLocalStorageData().idToken}`;
}

export default {
    async create(element) {
        const elementData  = Object.assign( {_ownerId: authService.getLocalStorageData().localId, clients: ['']}, element);

        let res = await request.post(urlBuilder('elements'), elementData);
        
        return res;
    },

    async getAll() {
        let elements = await request.get(urlBuilder('elements'));
        
        if(!elements){
            return [];
        } else {
            return Object.keys(elements).map(key => ({_id: key, ...elements[key]}));
        }
    },

    async getById(id) {
        let element = await request.get(urlBuilder(`elements/${id}`));

        element._id = id;

        return element;
    },

    async editById(id, element) {
        return await request.patch( urlBuilder(`elements/${id}`), element);
    },

    async deleteById(id){
        return request.delete( urlBuilder(`elements/${id}`) );
    }
}