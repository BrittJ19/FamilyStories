<template>
      <div class="container">
      <nav>
        <router-link v-bind:to="{ name: 'userProfile' }"><img id="logo" src="/offWhiteLogo.png"></router-link>  
      <router-link id="logout" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>
      <div id="menu">
          <ul id="menu-items">
              <router-link id="family" v-bind:to="{ name: 'userProfile' }"><li>Back To Profile <i id="b" class="fa-solid fa-arrow-left-long"></i></li></router-link>
              <li>Add a Book <i id="b" class="fa-solid fa-book-bookmark"></i> </li>
              <li>Log Reading <i id="l" class="fa-solid fa-book-open"></i></li>
              <li>Reading Activity <i id="ra" class="fa-solid fa-book-open-reader"></i></li>
              <li>Prizes <i id="p" class="fa-solid fa-trophy"></i></li>
              <li>Friends <i id="f" class="fa-solid fa-user-group"></i></li>
          </ul>
      </div>
      <main>
          <div id="name">

              <h1>Family Members</h1>
               <table>
          <thead>
              <th>Username</th>
              <th>Family</th>
              <th>Books Read</th>
              <th>Pages Read</th>
              <th>Charity Money Earned</th>
          </thead>
          <tbody>
              <tr v-for="member in familyMembers" v-bind:key="member.username">
                  <td id="familyName">{{ family.familyName }}</td>
                  <td id="books">{{family.booksCompleted}}</td>
                  <td id="pages">{{family.pagesRead}}</td>
                  <td id="money">$ {{family.moneyEarned}}</td>
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
// import FamilyAccountList from '../components/FamilyAccountList.vue';
import databaseService from '../services/DatabaseService'
export default {
//   components: { FamilyAccountList },
   data() {
        return {
            familyInfo:{
                familyName: '',
                userId: this.$store.state.user.id
            },
            familyAccounts: [],
            familyMembers: [],
            memberStats: [],
            isLoading: ''
        };
    },
    created() {
        this.isLoading = true;
        databaseService.getFamilyAccounts(this.userId).then((response) => {
            this.familyAccounts = response.data;
            console.log(response.data)
            console.log(this.familyAccounts.familyId)
        })
        this.familyAccounts.forEach( account => {
        databaseService.getUserByFamily(account.familyId).then( (response) => {
            this.familyMembers.add(response.data)
            this.isLoading = false;
            console.log(this.familyMembers)
        });
        })
    }

}
</script>

<style>

#b{
    font-size: 25px;
}
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
    flex-direction: column;
    justify-content: center;
    align-content: center ;
    align-items: center;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
    /* margin-left: 10px; */
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
    flex-grow: 1;
    /* margin-left: 250px; */
    color: rgb(245,245,220);
    width: 100%
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
 table{
     display: flex;
     flex-grow: 1;
     width: 100vh;
     flex-direction: column;
     justify-content: space-between;
     align-items: center;
 }
 tbody{
     display: flex;
     flex-grow: 1;
     justify-content: space-between;
     align-content: space-between;
 }
 thead{
     display: flex;
     flex-grow: 1;
 }
</style>