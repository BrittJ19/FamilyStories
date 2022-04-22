<template>
      <div class="container">
          <head>
              <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.0/css/all.css">
          </head>
      <nav>
        <img id="logo" src="/offWhiteLogo.png">  
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
              <router-link id="family" v-bind:to="{ name: 'family' }"><li>Family<i id="famIcon" class="fa-solid fa-people-roof"></i></li></router-link>
             <router-link id="books" v-bind:to="{name:'myBooks'}"><li>My Books <i id="b" class="fa-solid fa-book-bookmark"></i> </li></router-link> 
              <router-link id="log" v-bind:to="{ name: 'readingLog' }"><li>Log Reading <i id="l" class="fa-solid fa-book-open"></i></li></router-link>
              <router-link id="log" v-bind:to="{ path: '/checkactivity' }"><li>Reading Activity <i id="ra" class="fa-solid fa-book-open-reader"></i></li></router-link>
<<<<<<< HEAD
              <router-link id="family" v-bind:to="{ name: 'donate' }"><li>Prizes <i id="p" class="fa-solid fa-trophy"></i></li></router-link>
              <li>Friends <i id="f" class="fa-solid fa-user-group"></i></li>
=======
              <li>Prizes <i id="p" class="fa-solid fa-trophy"></i></li>
               <router-link id="friends" v-bind:to="{name:'friends' }"><li>My Friends<i id="f" class="fa-solid fa-user-group"></i></li></router-link>
>>>>>>> 067e29e2feaf66797ea49a82fb93a27ccb06c543
          </ul>
      </div>
      <main id="profileMain">
          <div id="name">
            <h1 id="username">{{username}}</h1>
              </div>
              <div id="headline">
          <div id="image">
              <span id="profile-image">
                  <img id="avatar" src="/newAvatar2.png">
              </span>
              <profile-picture id="pp"/>
          </div>
          <div id="icons">
              <div id="pagesRead">
                  <p>Pages Read</p>
                  <h6>{{currentUser.pagesRead}}</h6>
              <i id="pageIcon" class="fa-solid fa-file-lines"></i>
              </div>
              <div id="booksComp">
                  <p>Books Completed</p>
                  <h6>{{currentUser.booksCompleted}}</h6>
              <i id="bookIcon" class="fa-solid fa-book"></i>
              </div>
              <div id="moneyEarned">
                  <p id="char">Charity Money Earned</p>
                  <h6>${{currentUser.moneyEarned}}</h6>
              <i id="money" class="fa-solid fa-sack-dollar"></i>
              </div>
          </div>

              </div>
              <div id="profileBody">
                  <div id="favs">

                  <div id="FavBook">
                  <p class="tops">Desert Island Books </p>
                  <p>Game of Thrones Series</p>
                  <p></p>
                  </div>
                  <div id="ReadingPlace">
                  <p class="tops">Favorite Reading Spot </p>
                  <p>My bed</p>
                  <p></p>
                  </div>
                  <div id="childrensBook">
                  <p class="tops">Favorite Children's Book </p> 
                  <p>The Giving Tree</p>
                  <p></p>
                  </div>
                  </div>
                    <div id="why">
                    <p id="subheading">Why I love reading </p> 
                    <p>I love reading because I get to visualize the characters and settings with my own imagination. For this reason the experience of a book is different for 
                    everyone who reads it.</p> 
              </div>
                  
              </div>
            

      </main>
      </div>
</template>

<script>
import ProfilePicture from './ProfilePicture.vue'
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
import databaseService from '../services/DatabaseService'
export default {
     data() {
        return {
            family: [],
            isLoading: '',
            username: this.$store.state.user.username,
            currentUser: [],
            pagesRead: '',
            booksCompleted: '',
            moneyEarned: '',
            moneyDonated: ''
        };
    },
     created() {
         databaseService.getCurrentUser(this.$store.state.user.id).then( response => {
            this.currentUser= response.data;
            })
         databaseService.getUserPagesRead(this.$store.state.user.id).then( response => {
             this.pagesRead= response.data;
         }) 
         databaseService.getUserBooksCompleted(this.$store.state.user.id).then( response => {
             this.booksCompleted = response.data;
         }) 
         databaseService.getUserMoneyEarned(this.$store.state.user.id).then( response => {
             this.moneyEarned = response.data;
         }) 
         databaseService.getUserMoneyDonated(this.$store.state.user.id).then( response => {
             this.moneyDonated = response.data;
         })
     },
  components: { ProfilePicture },

}
</script>

<style>


/* .container{
    display: grid;

    width: 100vh;

    grid-template-columns: 1.5fr 1fr 4fr 1fr;

    grid-template-areas: 
    "nav nav nav nav"
    "menu . main ."
    ;
} */


#profileMain{
    padding: 20px
}

#avatar{
    display: flex;
    margin-right: 25px;

    /* object-fit: fill; */
    
}
#char{
    width: 200px
}
.tops{
    font-size: 30px; 
   padding: 15px;
   /* background-color: rgb(255,117,24); */
    margin: 10px;
    border-radius: 0;
    border-radius: 5%;
    font-weight: bold;
    text-shadow: 4px 4px darkolivegreen;
    
}
#favs{
    display: flex;
    align-self: center;
    flex-grow: 1;
    width: 100%;
    justify-content: space-evenly;
    align-content: space-between;
    
    
}
#FavBook{
    background-color: rgb(255,117,24);
    font-size: 15px; 
    text-align: center;
    margin: 15px;
      -webkit-box-shadow: 0px 0px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 0px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 0px 20px rgba(50, 50, 50, 0.75); 
    border-radius: 10%;

}
#ReadingPlace{
   background-color: rgb(255,117,24);
    font-size: 15px; 
    text-align: center; 
    margin: 15px;
      -webkit-box-shadow: 0px 0px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 0px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 0px 20px rgba(50, 50, 50, 0.75); 
    border-radius: 10%;
}
#childrensBook{
    background-color: rgb(255,117,24);
    font-size: 15px; 
    text-align: center; 
    margin: 15px;
      -webkit-box-shadow: 0px 0px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 0px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 0px 20px rgba(50, 50, 50, 0.75); 
    border-radius: 10%;
}
#profileBody{
    display: flex;
    flex-direction: column;
    color: rgb(245,245,220);
}

#why{
    border-radius: 5vh;
    padding: 20px;
    text-align: center;  
       -webkit-box-shadow: 0px 0px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 0px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 0px 20px rgba(50, 50, 50, 0.75); 
}
#subheading{
    font-weight: bold;
    font-size: 30px; 
    text-shadow: 4px 4px darkolivegreen;
}
/* #FavBook{
     background-color: rgb(255,117,24);
    margin: 10px;
    border-radius: 15%;
  
}
#ReadingPlace{
     background-color: rgb(255,117,24);
    margin: 10px
}
#childrensBook{
     background-color: rgb(255,117,24);
    margin: 10px
} */
#why{
     background-color: rgb(255,117,24);
    margin: 10px
}
#pageIcon{
    filter: drop-shadow(2px 5px 1px darkolivegreen);
    color: rgb(255,196,12);
    margin-left: 5px;
}
#bookIcon{
    filter: drop-shadow(2px 5px 1px darkolivegreen);
    color: rgb(255,196,12);
}
#money{
    filter: drop-shadow(2px 5px 1px darkolivegreen);
    font-size: 40px;
    color: rgb(255,196,12);
}
#booksComp{
    margin-right: 50px;
    margin-left: 5px;
}

#catchphrase{
    display: flex;
    width: 600px;
    margin-right: 400px;
}

p{
    font-size: 25px;
    font-family: 'abeatbyKai', sans-serif;
}

#pagesRead{
    margin-right: 60px;
    
}

#famIcon{ 
font-size: 25px;
/* margin-left: 5px    */
}
#b{
    font-size: 25px;
}
#l {
   font-size: 25px 
}
#ra{
    font-size: 25px
}
#p{
    font-size: 25px
}
#f{
    font-size: 25px
}
#username{
    text-align: center;
    justify-content: center;
}

#headline{
    display: flex;
}
#icons{
display: flex;
color: rgb(245,245,220);
font-size: 40px;
align-content: center;
justify-content: center;
justify-content: space-between;
margin-left: 50px;
margin-right: 50px;
}
#moneyEarned{
    margin:0%;
}
/* #logout{
    text-decoration: none;
   color: rgb(245,245,220);
   margin: 20px;
   font-size: 25px;
   font-family: 'abeatbyKai', sans-serif;
} */

/* nav{
    grid-area: nav;
} */

nav{
    display: flex;
    justify-content: space-between;
    flex-grow: 1;
    background-color: rgb(255,117,24);
    padding: 20px
    
}

main{
    grid-area: main;
}

main{
    display: flex;
    flex-direction: column;
    background-color: rgb(150,165,60);
    /* margin: 25px; */
    width: 100%;
    /* height: 80%; */
    /* margin-top: 40px */
}

#name{
    display: flex;
    width: 100%;
    justify-content: flex-start;
    align-content: flex-start;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
}

#family, #log, #books, #friends{
    text-decoration: none;
    color: rgb(245,245,220);
}

#menu{
    display: flex;
    grid-area: menu;
    height: 100%;
}

#menu-items{
    display: flex;
    flex-grow: 1;
    font-family: 'abeatbyKai', sans-serif;
    color: rgb(245,245,220);
    padding: 10px;
    border-radius: 8vh;
}

li{
    padding:15px;
    border-bottom: 4px solid rgb(255,196,12);
    background-color: darkolivegreen;
    display: flex;
    justify-content: space-between;
    margin: 20px;
     -webkit-box-shadow: 5px 5px 5px 5px rgb(255,117,24);
    -moz-box-shadow:    5px 5px 5px 5px rgb(255,117,24);
    box-shadow:         5px 5px 5px 5px rgb(255,117,24);
    border-radius: 2vh;
}

li:hover{
    padding: x;
    background-color: rgb(255,196,12);
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
    /* background-color: darkolivegreen; */
}

body{
    /* background-color: rgb(245,245,220); */
    background-image: url("/background.jpg");
    background-size: 100vh;
    margin:0px
}

#pp{
    margin-left: 20px;
}

#profile-image{
    display: flex;
    background-color: white;
    flex-grow: 1;
    justify-content: center;
    height: 200px;
    margin-left: 40px;
    border: 4px solid rgb(255,196,12);
    margin-right: 60px;
     -webkit-box-shadow: 0px 20px 20px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    0px 20px 20px rgba(50, 50, 50, 0.75);
    box-shadow:         0px 20px 20px rgba(50, 50, 50, 0.75);
}

h1{
    /* margin-left: 20px; */
    font-size: 45px;
    display: flex;
    width: 100vh;
    justify-content: flex-start;
    margin-left: 55px
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

 #avatar{
     margin-left: 25px;
 }
 h6{
     margin-top: 10px;
    font-size: 40px;
    margin-left: 5px;
    margin-bottom: 30px;
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
</style>