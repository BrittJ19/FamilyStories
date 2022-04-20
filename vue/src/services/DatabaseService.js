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
    },
    addMemberToFriends(userFriends) {
        return database.post('/friends', userFriends);
    },
    getCurrentUser(userId) {
        return database.get(`/user/${userId}`)
    },

    getUserByUsername(username) {
        return database.get(`/user/find=${username}`)
    },
    getUserByFamily(familyId) {
        return database.get(`/user/family/${familyId}`)
    },
    getFamilyPagesRead(familyId) {
        return database.get(`/family/${familyId}/pagesRead`)
    },
    getFamilyBooksCompleted(familyId) {
        return database.get(`/family/${familyId}/booksCompleted`)
    },
    getFamilyMoneyEarned(familyId) {
        return database.get(`/family/${familyId}/moneyEarned`)
    },
    getFamilyMoneyDonated(familyId) {
        return database.get(`/family/${familyId}/moneyDonated`)
    },
    addReadingRecord(userId, readingRecord) {
        return database.post(`/reading/${userId}/record`, readingRecord);
    },
    getUserPagesRead(userId) {
        return database.get(`/reading/${userId}/pagesRead`)
    },
    getUserTimeReading(userId) {
        return database.get(`/reading/${userId}/time`)
    },
    getUserBooksCompleted(userId) {
        return database.get(`/reading/${userId}/booksCompleted`)
    },
    getUserMoneyEarned(userId) {
        return database.get(`/reading/${userId}/moneyEarned`)
    },
    getUserMoneyDonated(userId) {
        return database.get(`/reading/${userId}/moneyDonated`)
    },
    getReadingLogs(userId) {
        return database.get(`reading/${userId}/logs`)
    }



}