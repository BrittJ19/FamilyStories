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
              <router-link id="books" v-bind:to="{name:'myBooks'}"><li>My Books <i id="b" class="fa-solid fa-book-bookmark"></i> </li></router-link>
              <router-link id="log" v-bind:to="{ name: 'readingLog' }"><li>Log Reading <i id="l" class="fa-solid fa-book-open"></i></li></router-link>
              <router-link id="log" v-bind:to="{ path: '/checkactivity' }"><li>Reading Activity <i id="ra" class="fa-solid fa-book-open-reader"></i></li></router-link>
              <router-link id="log" v-bind:to="{ path: '/prize/donate' }"><li>Prizes <i id="p" class="fa-solid fa-trophy"></i></li></router-link>
              <router-link id="books" v-bind:to="{name:'friends'}"><li>Friends <i id="f" class="fa-solid fa-user-group"></i></li></router-link>
          </ul>
      </div>
      <main id="m">
          <div id="name">

              <h1 class="heading">Reading Activity</h1>
               <table id="tab"> 
        <thead id="tHead">
              <th>Date</th>
              <th>Username</th>
              <th>Account Type</th>
              <th>Title</th>
              <th>Book Format</th>
              <!-- <th>Time</th> -->
              <th>Pages Read</th>
              <th>Book Finished</th>
              <th>Notes</th>
          </thead>
          <tbody>
              <tr id = "tr" v-for="log in logs" v-bind:key="log.recordId">
                  <td id="user">{{log.dateTime}}</td>
                  <td id="userN">{{log.username}}</td>
                  <td id="famFam">{{log.accountType}}</td>
                  <td id="book">{{log.bookTitle}}</td>
                  <td id="frmMat">{{log.format}}</td>
                  <!-- <td id="tme">{{log.timeReading}}</td> -->
                   <td id="pages1">{{log.pagesRead}}</td>
                   <td id="finish">{{log.completed}}</td>
                   <td id="note">{{log.notes}}</td>     
                               
                  <!-- <td id="books">{{family.booksCompleted}}</td>
                  <td id="pages">{{family.pagesRead}}</td>
                  <td id="money">$ {{family.moneyEarned}}</td> -->
                </tr>
          </tbody>
      </table>
              </div>
              <!-- <family-account-list id="list" /> -->
      </main>
      </div>
</template>

<script>
import moment from 'moment'
import databaseService from '../services/DatabaseService'
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
export default {
  data() {
        return {
            logs: [],
            isLoading: '',
            formattedDate:[]
        };
    },
    created() {
        // this.isLoading = true;
        databaseService.getReadingLogs(this.$store.state.user.id).then( response => {
            this.logs = response.data;
           this.logs.forEach( log => {
             if(log.dateTime) {
               log.dateTime = moment(String(log.dateTime)).format('MM/DD/YYYY')
             }
           })
            // this.isLoading = false;
        });
    }

}
</script>

<style scoped>
#userN{
    margin: 0%;
    margin-left: 30px;
    margin-top: 30px;
}
#famFam{
    margin-left: 70px;
}
#book{
    margin-left: 30px;
    padding-left: 30px;
    padding-right: 40px;
}
#tme{
    text-align: left;
    margin-left: 40px;
    padding-right: 70px
}
#finish{
    margin-left: 60px;
    padding-right: 50px;
}
#note{
    margin-left: 80px;
    padding: 0;
}
#frmMat{
   
}

#pages1{
    margin-right: 40px;
}

#bcd, #prd, #med, #pages1, #tme, #fmat{
font-family: Arial, Helvetica, sans-serif;
/* text-align: left; */
}
.rows{
    /* margin-left: 40px; */
}
#tHead{
    /* margin-left: 20px; */
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
    padding: 40px;
    align-self: center;
    justify-self: center;
}
.heading{
    display: flex;
    justify-content: center;
}

main{
    display: flex;
    flex-direction: column;
    align-content: center;
    /* background-color: rgb(150,165,60); */
    /* margin: 25px; */
    /* width: 100%; */
    /* height: 80%; */
}

#name, #stats{
    /* display: flex; */

    flex-direction: column;
    justify-content: center;
    align-content: center ;
    align-items: center;
    color: rgb(150,165,60);
    font-family: 'abeatbyKai', sans-serif;
      background-color: rgb(245,245,220);
    /* padding-right: 40px;
    padding-left: 40px; */
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
    color: rgb(255,117,24);
    font-size: 50px;
    font-family: 'abeatbyKai', sans-serif;
    color:rgb(255,196,12);
  /* text-shadow: 4px 4px darkolivegreen; */
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
 #tab{
     margin-right: 150px;

     /* display: flex;
     flex-direction: column; */
     /* justify-content: space-between; */
     /* align-items: center;
     table-layout:fixed; */
 }
 th{
     margin-right: 30px;
 }

 /* tbody{ */
     /* display: flex;
     flex-direction: column; */
     /* flex-grow: 1; */
     /* font-size: 18px;
 } */
 td{
     /* display:flex; */
     /* width: 100vh; */
     margin: 0%;
     margin-top: 30px
     
     /* padding-right: 100px; */

 }

 thead{
     display: flex;
     flex-grow: 1;
     /* width: 100vh; */
     font-size: 30px;
     justify-content: space-between;
     align-content: space-between;
     color:rgb(255,196,12);
    
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
    /* margin-left: 20px */
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
td{
    padding-left: 10px;
    padding-right: 10px;
}

</style>