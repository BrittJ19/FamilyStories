<template>
      <div class="container">
      <nav>
        <router-link v-bind:to="{ name: 'userProfile' }"><img id="logo" src="/offWhiteLogo.png"></router-link>
        <img id="catchphrase" src="/logoText.png">   
      <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'login' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        <router-link id="logout" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">Logout</router-link>
        </div> 
 </div>
      </nav>
      <div id="menu">
          <ul id="menu-items">
              <router-link id="family" v-bind:to="{ name: 'userProfile' }"><li>Back To Profile <i id="b" class="fa-solid fa-arrow-left-long"></i></li></router-link>
              <li>Add a Book <i id="b" class="fa-solid fa-book-bookmark"></i> </li>
              <router-link id="log" v-bind:to="{ name: 'readingLog' }"><li>Log Reading <i id="l" class="fa-solid fa-book-open"></i></li></router-link>
              <router-link id="log" v-bind:to="{ path: '/checkactivity' }"><li>Reading Activity <i id="ra" class="fa-solid fa-book-open-reader"></i></li></router-link>
              <router-link id="log" v-bind:to="{ path: '/prize/donate' }"><li>Prizes <i id="p" class="fa-solid fa-trophy"></i></li></router-link>
              <li>Friends <i id="f" class="fa-solid fa-user-group"></i></li>
          </ul>
      </div>
      <main id="m">
          <div id="name">

              <h1 class="heading">Family Members</h1>
               <table id="table1"> 
          <thead id="tHead">
              <th>Username</th>
              <th>Family</th>
              <th>Books Read</th>
              <th>Pages Read</th>
              <th>Charity Money Earned</th>
          </thead>
          <tbody>
              <tr v-for="member in familyMembers[0]" v-bind:key="member.id">
                  <td id="username">{{member.username}}</td>
                  <td id="familyName">{{member.familyName}}</td>
                  <td id="books">{{member.booksCompleted}}</td>
                  <td id="pages">{{member.pagesRead}}</td>
                  <td id="moneyMoney">${{Math.floor(member.pagesRead / 500) * 5}}</td>
                </tr>
          </tbody>
      </table>
              </div>
          <div id="stats">
              <h1 class="heading">Family Reading Accounts</h1>
              <table>
          <thead>
              <th> Family Name</th>
              <th> Total Books Read </th>
              <th> Total Pages Read </th>
              <th> Total Money Earned </th>
          </thead>
          <tbody>
              <tr v-for="account in familyAccounts" v-bind:key="account.familyName" id="row">
                  <td class="rows" id="username">{{account.familyName}}</td>
                  <td class="rows" id="bcd">{{account.booksCompleted}}</td>
                  <td class="rows" id="prd">{{account.pagesRead}}</td>
                  <td class="rows" id="med">${{Math.floor(account.pagesRead / 500) * 5}}</td>
                </tr>
          </tbody>
      </table>
      </div>
              <!-- <family-account-list id="list" /> -->
               <div id="options">
          <router-link v-bind:to="{ name: 'newAccount' }"><button id="new">Create New Family Account</button></router-link>
        <router-link v-bind:to="{name: 'addUser'}"><button id="update">Add User to Family Account</button></router-link>
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
            isLoading: '',
            pagesRead: '',
            booksCompleted: '',
            moneyEarned: '',
            moneyDonated: '',
            familyId: '',
            totals: [],
            test: 0
        };
    },
    created() {
        this.isLoading = true;
        databaseService.getFamilyAccounts(this.$store.state.user.id).then(response => {
            this.familyAccounts = response.data;
            this.familyAccounts.forEach( account => {
                account.moneyEarned = 0;
                account.pagesRead = 0;
                account.booksCompleted = 0;
        databaseService.getUserByFamily(account.familyId).then( resp=> {
            this.familyMembers.push(resp.data)
            this.familyMembers[0].forEach( member => {
                account.booksCompleted = account.booksCompleted + member.booksCompleted
                account.moneyEarned = account.moneyEarned + member.moneyEarned
                account.pagesRead = account.pagesRead + member.pagesRead});
            // FIX THIS MESS!!!!
            let a = {
                famName: '',
                famPagesRead: 0,
                famBooksComp: 0,
                famMoney: 0
            }
            a.famName = resp.data.familyName
            this.test = parseInt(resp.data.data.moneyEarned);
            a.famPagesRead = parseInt(a.famPagesRead + resp.data.data.pagesRead);
            a.famBooksComp = a.famBooksComp + resp.data.booksCompleted;
            a.famMoney = a.famMoney + resp.data.moneyEarned

            this.totals.push(a);

            this.isLoading = false;
        })

            
        })})
        databaseService.getFamilyPagesRead(this.familyAccounts.familyId).then(response => {
            this.pagesRead = response;
            console.log(this.familyAccounts.familyId)
        })
        // this.familyAccounts.forEach( account => {
        // databaseService.getUserByFamily(account.familyId).then( response => {
        //     this.familyMembers.add(response.data)
        //     this.isLoading = false;
        //     console.log(this.familyMembers)
        // });
        // })
    },
    methods:{
    getTotalPagesRead(familyId) {
        databaseService.getFamilyPagesRead(familyId).then(el => {
            return el.data
        })
    },
    getTotalBooksCompleted(familyId) {
        databaseService.getFamilyBooksCompleted(familyId).then(el => {
            return el.data
        })
    },
     getTotalMoneyEarned(familyId) {
        databaseService.getFamilyMoneyEarned(familyId).then(el => {
            return el.data
        })

},   totRead(num){
            return Math.floor(num / 500) * 5
        }
    }
}
</script>

<style>
#bcd, #prd, #med{
font-family: Arial, Helvetica, sans-serif;
}
.rows{
    margin-left: 40px;
}
tHead{
    margin-left: 20px;
}

#innerNav{
  display: flex;
  align-content: center;
  justify-content: center;
  margin-bottom: 30px;
}

#site-links{
  display: flex;
  flex-grow: 1;
  padding-top: 10px;
  text-decoration: none;
  justify-content: flex-end;
  align-content: flex-end;
  /* justify-content: space-between; */
  font-family: 'abeatbyKai', sans-serif;
   
  
}
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


nav{
    grid-area: nav;
}

nav{
    display: flex;
    /* justify-content: space-between; */
    flex-grow: 1;
    background-color: rgb(255,117,24);
     -webkit-box-shadow: 0px 0px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 0px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 0px 20px rgba(50, 50, 50, 0.75);
}

main{
    display: flex;
    flex-direction: column;
    grid-area: main;
      -webkit-box-shadow: 0px 20px 20px rgba(50, 50, 50, 100);
    -moz-box-shadow:    0px 20px 20px rgba(50, 50, 50, 100);
    box-shadow:         0px 20px 20px rgba(50, 50, 50, 100);
    margin-top: 40px;
    border-radius: 5%;
}
#m{
    height: 80%;
    padding: 40px
}
.heading{
    display: flex;
    justify-content: center;
}

main{
    display: flex;
    flex-direction: column;
    /* background-color: rgb(150,165,60); */
    /* margin: 25px; */
    width: 100%;
    /* height: 80%; */
}

#name, #stats{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center ;
    align-items: center;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
      background-color: rgb(255,117,24);
    padding: 20px;
    padding-right: 0%;
    padding-left: 0%;
    margin-bottom: 40px;
    margin-top: 40px;
     -webkit-box-shadow: 10px 10px 10px 10px darkolivegreen;
    -moz-box-shadow:    10px 10px 10px 10px darkolivegreen;
    box-shadow:         10px 10px 10px 10px darkolivegreen;
    border-radius: 5vh;
    /* margin-left: 10px; */
}


#family{
    text-decoration: none;
    color: rgb(245,245,220);
}

#menu{
    display: flex;
    grid-area: menu;
    height: 100%;
     -webkit-box-shadow: 0px 20px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 20px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 20px 20px rgba(50, 50, 50, 0.75);
}

#menu-items{
    display: flex;
    flex-grow: 1;
    font-family: 'abeatbyKai', sans-serif;
    color: rgb(245,245,220);
    padding: 10px;
    height: 100vh;
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

/* li:nth-child(odd){
    background-color: darkolivegreen;
} */

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
    align-self: center;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
  text-shadow: 4px 4px darkolivegreen;
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
 th{
     margin-right: 20px;
 }
 tbody{
     display: flex;
     flex-direction: column;
     flex-grow: 1;
     width: 100vh;
     justify-content: space-between;
     align-content: space-between;
     font-size: 20px;
 }
 tr{
    display: flex;
    width: 100vh;
    justify-content: space-between;
    padding-right: 200px
     
 }
 td{
     display:flex;
     width: 100vh;
     padding-right: 100px;
     margin-top: 15px

 }
 thead{
     display: flex;
     flex-grow: 1;
     width: 100vh;
     font-size: 30px;
     justify-content: space-between;
     align-content: space-between;
     color:rgb(255,196,12);
    
 }
 #options{
    display: flex;
    flex-direction: row;
    /* margin-left: 75px; */
    justify-content: center;
    

}
#books{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 20px
}
#pages{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 20px
}
#moneyMoney{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 20px;
    margin-left: 20px
}
#new, #update{
      -webkit-box-shadow: 0px 0px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 0px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 0px 20px rgba(50, 50, 50, 0.75);
}

#home{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px;
  padding: 20px;
  padding-right: 50px;
  border-right: 4px solid rgb(150,165,60);
}

#home:hover{
  font-size: 25px;
}

#about{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px;
  padding: 20px;
  padding-right: 50px;
  margin-left: 30px;
  border-right: 4px solid rgb(150,165,60);
}

#about:hover{
  font-size: 25px;
}
#charities{
text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px;
  padding: 20px;
  padding-right: 50px;
  margin-left: 30px;
  border-right: 4px solid rgb(150,165,60);
}


#logout{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px !important;
  padding-top: 20px !important;
  margin-right: 10px !important;
  margin-left: 50px !important;
}
#logout:hover{
  font-size: 25px;
}
#catchphrase{
    display: flex;
    width: 600px;
    margin-right: 400px;
}

</style>