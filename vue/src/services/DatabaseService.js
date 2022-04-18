import axios from "axios";

const database = axios.create({
    baseURL: 'http://localhost:8080'
});

export default{

    getUsers() {
        return database.get('/users');
    },

    getFamily(userId) {
        return database.get(`/familyStats/${userId}`);
    },

    createFamily(familyForm) {
        return database.post('/family/newAccount', familyForm);
    },

    getSearchResults(searchTerm) {
        return database.get(`/search=${searchTerm}`);
    },
    
    getFamilyMembers(userId, familyId) {
        return database.get(`/family/${userId}/${familyId}`);
    },

    getFamilyAccounts(userId) {
        return database.get(`/family/${userId}/accounts`)
    },

    addMemberToFamily(userFamily) {
        return database.post('/family/addMember', userFamily);
    }



}