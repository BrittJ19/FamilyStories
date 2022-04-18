<template id="all">
  <div id="page">
          <div class="loading" v-if="isLoading">
              <img src="/loadingGif.gif"/>
          </div>
      <div id="banner">
      <router-link v-bind:to="{ name: 'userProfile' }"><img id="logo" src="/offWhiteLogo.png"></router-link>
      </div>
      <div id="accountForm">
      <div id="main">    
      <h1>Add User to Family</h1>
      <form v-on:submit.prevent="addToFamily">
          <div id="searchBox" class="form-element">
              <label for="account-name"> Search user by username : </label>
              <input id="name-text" type="text" v-model="text"/>
              <p>Type all or part of username.</p>
          </div>    

          <!-- <div class="form-element">
              <label for="account-type"> Account Type:</label>
                  <select id="selections">
                      <option value="parent">Parent</option>
                      <option value="child">Child</option>
                  </select>
          </div>  -->
          <div id="search" class="form-element">
              <button id="searchButton" v-on:click="searchForUsers">Search Users to Add</button>
              <select name="results" id="results" v-if="isSearching">
                <option value="username" v-for="user in searchResults" v-bind:key="user.username">{{user}}</option>
              </select>
          </div> 
          <p>Select Family name to add member</p>
          <select name="results" id="accountNames">
                <option value="username" v-for="account in familyAccounts" v-bind:key="account.family_id">{{account.familyName}}</option>
              </select>
          <div class="actions">
              <button id="newUser">Create New User</button>
              <button id="submit" type="submit">Add User to Family</button>
          </div>
          <!-- <h1>{{message}}</h1> -->
      </form>
      </div>
      </div>
  </div>
</template>

<script>
import databaseService from '../services/DatabaseService'
export default {
    name: "family-account",
    data() {
        return {
            familyAccount: {
                familyName: '',
                username: '',
            },
            newUser: {

            },
            message: "",
            isLoading: '',
            text1: '',
            search: '',
            users: [],
            text: '',
            searchResults: [],
            searchMessage:"",
            isSearching: false,
            familyAccounts: [],
            memberAdded: ''

        }
    },
    created() {
        databaseService.getUsers().then( resp => {
            this.users = resp.data;
        databaseService.getFamilyAccounts(this.$store.state.user.id).then(resp => {
            this.familyAccounts = resp.data;
        })    
        })
    },
    methods: {
        createFamily() {
            this.isLoading = true;
            const familyForm = {
                familyName: this.text1,
                userId: this.$store.state.user.id
            };
            databaseService.createFamily(familyForm).then( resp => {
                if (resp.status == 200) {
                this.$store.commit('SET_NEW_FAMILY', resp.data);
                this.isLoading = false;
                this.message = "New Family Account has been created!"
            } else {
                this.message = "Family Account not created. Family account name may already be in use."
                this.isLoading = false;
            }})
            },
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
            // selectAccount() {
            //     var account = document.getElementById("accountNames").value;
            //     this.familyAccount.familyName = account;
            // },

            // selectUser() {
            //     var user = document.getElementById("results").value;
            //     this.familyAccount.username = user;
            // },
            addToFamily() {
                var selectedUser = document.getElementById('results');
                var userValue = selectedUser.options[selectedUser.selectedIndex].text;
                this.familyAccount.username = userValue;
                var selectAccount = document.getElementById('accountNames');
                var accountValue = selectAccount.options[selectAccount.selectedIndex].text;
                this.familyAccount.familyName = accountValue;
                databaseService.addMemberToFamily(this.familyAccount).then( resp => {
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
        },
    }
    }


</script>

<style scoped>

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

#banner{
    display: flex;
    flex-grow: 1;
    background-color: rgb(255,117,24);
    justify-content: center;
}
#accountForm{
    display: flex;
    flex-direction: column;
    margin:10px;
    background-color: rgb(150,165,60);
    border-radius: 2%;
    width: 60%;
    padding-bottom: 26%;
    justify-content: center;
    align-self: center;
    align-content: center;
    align-items: stretch;
    margin-left: 400px
}

.form-element{
    display: flex;
    justify-content: center;
}

#logo{
    display: flex;
    justify-content: center;
}

button{
    display: flex;
    justify-content: center;
    align-content: center;
    align-self: center;
    margin: 20px;
    background-color: rgb(255,117,24);
    padding: 10px
}

.actions{
    display: flex;
    justify-content: center;
    height: 100px;
}

</style>