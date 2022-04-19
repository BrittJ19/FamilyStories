import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  
  state: {
    token: currentToken || '',
    user: currentUser || {},
    users: [],
    search: '',
    family: [],
    NewFamilyAccount: '',
    books: [
      {
        title: "Misery",
        author: "Stephen King",
        isbn: "9780670813643"
      },
      {
        title: "The Seven Husbands of Evelyn Hugo",
        author: "Taylor Jenkins Reid",
        isbn: "9781982147662"
      },
      {
        title: "The Giving Tree",
        author: "Ernest Hemingway",
        isbn: "9780684830490"
      },
      {
        title: "Le Petit Prince",
        author: "Shel Silverstein",
        isbn: "0060256656"
      },
      {
        title:"The Midnight Library",
        author:"Matt Haig",
        isbn: "9780525559474" 
      },
      {
        title:"Harry Potter and The Deathly Hallows",
        author:"J.K Rowling",
        isbn: "9780545139700" 
      },
      {
        title:"Harry Potter and The Half-Blood Prince",
        author:"J.K Rowling",
        isbn: "9780545582995" 
      }
    ]
    },
    
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    USERS_LIST(state, userList) {
      state.users = userList;
    },
    UPDATE_SEARCH(state, term) {
      state.search = term;
    },
    SET_FAMILY_STATS(state, family) {
      state.family = family;
    },
    SET_NEW_FAMILY(state, resp) {
      state.NewFamilyAccount = resp;
    },
    ADD_BOOK(state, book){
      state.books.push(book);
    }
  },
  actions: {},
  modules: {},
  strict: true
});
