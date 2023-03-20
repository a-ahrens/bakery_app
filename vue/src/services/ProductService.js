import axios from'axios';

export default {
    getProducts(){
        return axios.get('/products/all');
    }

}