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
      <h1>Create New Family Account</h1>
      <form v-on:submit.prevent="createFamily">
          <div class="form-element">
              <label for="account-name"> Account Name : </label>
              <input id="name-text" type="text" v-model="text1"/>
          </div>

          <!-- <div class="form-element">
              <label for="account-type"> Account Type:</label>
                  <select id="selections">
                      <option value="parent">Parent</option>
                      <option value="child">Child</option>
                  </select>
          </div> -->
          <!-- <div class="form-element">
              <button>Search Users to Add</button>
          </div> -->
          <div class="actions">
              <button type="submit">Create Family Account</button>
          </div>
          <router-link v-bind:to="{ name: 'family' }"><button id="back">Back</button></router-link>
          <h1>{{message}}</h1>
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
                accountType: '',
                userId: this.$store.state.userId
            },
            message: "",
            isLoading: '',
            text1: ''
        }
    },
    methods: {
        createFamily() {
            this.isLoading = true;
            const familyForm = {
                familyName: this.text1,
                userId: this.$store.state.user.id
            };
            databaseService.createFamily(familyForm).then( resp => {
                if (resp.status === true) {
                this.$store.commit('SET_NEW_FAMILY', resp.data);
                this.isLoading = false;
                this.message = "Your new Family Account has been created!"
            } else {
                this.message = "Family Account not created. Family account name may already be in use."
                this.isLoading = false;
            }})
            }
            
        }
    }


</script>

<style scoped>


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
#back{
    display: flex;
    margin-left: 490px;
    width: 175px;
    text-decoration: none;
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