import axios from "axios";

const database = new axios.create({
    baseURL: 'http://localhost:8080'
});

export default{

    getUsers() {
        return database.get('/users');
    },

    getFamily() {
        return database.get('/family');
    }



}