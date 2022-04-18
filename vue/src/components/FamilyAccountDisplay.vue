<template>
      <div class="container">
      <nav>
        <router-link v-bind:to="{ name: 'userProfile' }"><img id="logo" src="/offWhiteLogo.png"></router-link>  
      <router-link id="logout" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>
      <div id="menu">
          <ul id="menu-items">
              <router-link id="family" v-bind:to="{ name: 'userProfile' }"><li>Back To Profile</li></router-link>
              <li>Add a Book</li>
              <li>Log Reading</li>
              <li>Reading Activity</li>
              <li>Prizes</li>
              <li>Friends</li>
          </ul>
      </div>
      <main>
          <div id="name">
              <h1>Family Members</h1>
               <table>
          <thead>
              <th>Username</th>
          </thead>
          <tbody>
              <tr v-for="family in familyMembers" v-bind:key="family.familyId">
                  <td id="usernames">{{ family }}</td>
                </tr>
          </tbody>
      </table>
              </div>
          <div id="stats">
              <h1>Family Reading Stats</h1>
              <family-account-list id="list" />
          </div>

      </main>
      </div>
</template>

<script>
import FamilyAccountList from '../components/FamilyAccountList.vue';
import databaseService from '../services/DatabaseService'
export default {
  components: { FamilyAccountList },
   data() {
        return {
            familyAccounts: [],
            familyMembers: [],
            isLoading: ''
        };
    },
    created() {
        this.isLoading = true;
        databaseService.getFamilyAccounts(this.$store.state.user.id).then(response => {
            this.familyAccounts = response.data;
            console.log(response.data)
        })
        this.familyAccounts.forEach( account => {
        databaseService.getFamilyMembers(this.$store.state.user.id, account).then( response => {
            this.familyMembers.concat(response.data)
            this.isLoading = false;
            console.log(this.familyMembers)
        });
        })
    }

}
</script>

<style>


.container{
    display: grid;

    grid-template-columns: 1.5fr 1fr 4fr 1fr;

    grid-template-areas: 
    "nav nav nav nav"
    "menu . main ."
    ;
}

#logout{
    text-decoration: none;
   color: rgb(245,245,220);
   margin: 20px;
   font-size: 25px;
   font-family: 'abeatbyKai', sans-serif;
}

nav{
    grid-area: nav;
}

nav{
    display: flex;
    /* justify-content: space-between; */
    flex-grow: 1;
    background-color: rgb(255,117,24);
}

main{
    display: flex;
    flex-direction: column;
    grid-area: main;
}

main{
    display: flex;
    flex-direction: column;
    background-color: rgb(150,165,60);
    /* margin: 25px; */
    width: 100%;
    /* height: 80%; */
}

#name{
    display: flex;
    justify-content: flex-start;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
}

#family{
    text-decoration: none;
    color: rgb(245,245,220);
}

#menu{
    display: flex;
    grid-area: menu;
    height: 100vh
}

#menu-items{
    display: flex;
    flex-grow: 1;
    font-family: 'abeatbyKai', sans-serif;
    color: rgb(245,245,220);
    padding: 10px;
}

li{
    padding:15px;
}

li:hover{
    padding: 25px;
}

#menu{
    background-color: rgb(150,165,60);
}

ul{
    list-style-type: none;
    display: flex;
    flex-direction: column;
    flex-grow: 1;
}

li:nth-child(odd){
    background-color: darkolivegreen;
}

body{
    background-color: rgb(245,245,220);
}

#pp{
    margin-left: 20px;
}

#profile-image{
    display: flex;
    background-color: white;
    width: 250px;
    height: 200px;
    margin-left: 20px;
}

h1{
    display: flex;
    flex-grow: 1;
    justify-content: center;
    align-content: center;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
}

#list{
    display: flex;
    margin-left: 250px;
    color: rgb(245,245,220);
}


/* #body{
    display: flex;
    flex: 1 0 auto;
    background-color: rgb(245,245,220);
} */


#logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
 }
</style>