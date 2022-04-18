<template>
  
<div class= "find_friends">
    <head>
    <h1>Find Friends</h1>
    </head>
      <form v-on:submit.prevent="addToFriends">
          <div id="searchBox" class="form-element">
              <label for="account-name"> Search user by username : </label>
              <input id="name-text" type="text" v-model="text"/>
              <p>Type all or part of username.</p>
          </div>    

          <div id="search" class="form-element">
              <button id="searchButton" v-on:click="searchForUsers">Search for Friends to Add</button>
              <select name="results" id="results" v-if="isSearching">
                <option value="username" v-for="user in searchResults" v-bind:key="user.username">{{user}}</option>
              </select>
          </div> 
          <select name="results" id="accountNames" v-on:change="saveAccountSelection()">
              <option disabled selected value>-- select an option --</option>
                <option value="username" v-for="account in userAccounts" v-bind:key="account.user_id">{{account.username}}</option>
              </select>
          <div class="actions">
              <button id="submit" type="submit">Add Friend</button>
          </div>
    </form>
</div>
  
</template>


<script>
import databaseService from '../services/DatabaseService'
export default {
    name:"find_friends",
    data(){
        return{ message: "",
            isLoading: '',
            text1: '',
            search: '',
            users: [],
            text: '',
            searchResults: [],
            searchMessage:"",
            isSearching: false,
            myFriends: [],
            memberAdded: ''
        }
    },
methods: {
            updateSearchFilter() {
                this.$store.commit('UPDATE_SEARCH', this.searchTerm);
            },
            searchForUsers() {
                this.isLoading = true;
                this.search = this.text;
                databaseService.getSearchResults(this.search).then( resp => {
                this.searchResults = resp.data;    
                this.isLoading = false;
                this.isSearching = true;
                console.log(resp.data);
                })
                if (this.searchResults.length > 0) {
                    this.searchMessage = "Select User from Dropdown";
                }else {
                    this.searchMessage = "No users found."
                }
            },
            selectAccount() {
                var account = document.getElementById("accountNames").value;
                this.userAccount.userame = account;
            },

            selectUser() {
                var user = document.getElementById("results").value;
                this.userAccount.username = user;
            },
            addToFriends() {
                var selectedUser = document.getElementById('results');
                var userValue = selectedUser.options[selectedUser.selectedIndex].text;
                this.username = userValue;
                var selectAccount = document.getElementById('accountNames');
                var accountValue = selectAccount.options[selectAccount.selectedIndex].text;
                this.userAccount.userName = accountValue;
                databaseService.addToFriends(this.username).then( resp => {
                    if(resp.status == 200){
                        this.memberAdded = true;
                    }else {
                        this.memberAdded = false;
                    }
                })
            }
            
        },
        computed: {
    filteredUsers() {
      return this.users.filter(u => {
        // return true if the product should be visible

        // in this example we just check if the search string
        // is a substring of the product name (case insensitive)
        return u.toLowerCase().indexOf(this.search.toLowerCase()) != -1;
      });
        }
    }
}
    
</script>

<style scoped>
@import url('http://fonts.cdnfonts.com/css/abeatbykai');
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap');

#name-text{
    height: 30px
}

#searchButton{
    margin-bottom: 80px;
    width: 200px
}

#searchBox{
    display: flex;
    flex-direction: column;
    width: 30%;
    align-self: center;
    font-family: 'abeatbyKai', sans-serif;
    color: rgb(245,245,220);
}
p{
    font-family: 'abeatbyKai', sans-serif;
    color: rgb(245,245,220);
    align-self: center;
}

.form-element{
    padding: 10px;
}

#submit{
    margin-top: 50px;
    width: 200px;
    margin-top: 200px
}

#newUser{
    margin-top: 0px;
    width: 200px;
    margin: 40px
}

.actions{
    display: flex;
    flex-direction: column;
    flex-direction: column-reverse;
    padding: 20px
}

#results{
    width: 25%;
    align-self: center;
    height: 40px

}
#accountNames{
    width: 25%;
    align-self: center;
    height: 40px

}

#search{
    display: flex;
    flex-direction: column;
}

form{
    display: flex;
    flex-direction: column;
    padding: 50px
}
body{
    background-color: rgb(245,245,220);
}
#all{
    background-color:rgb(245,245,220);  
}

label{
    font-family: 'abeatbyKai', sans-serif;
    padding: 5px;
    color:rgb(245,245,220);
}
h1{
    display: flex;
    justify-content: center;
    color:rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
}

#page{
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    background-color:rgb(245,245,220);
}

#main{
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    flex: 1 0 auto;
  
}

</style>