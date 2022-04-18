<template>
      <div class="container">
          <head>
              <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.0/css/all.css">
          </head>
      <nav>
        <img id="logo" src="/offWhiteLogo.png">  
        <img id="catchphrase" src="/logoText.png"> 
      <router-link id="logout" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>
      <div id="menu">
          <ul id="menu-items">
              <router-link id="family" v-bind:to="{ name: 'family' }"><li>Family<i id="famIcon" class="fa-solid fa-people-roof"></i></li></router-link>
              <li>Add a Book <i id="b" class="fa-solid fa-book-bookmark"></i> </li>
              <li>Log Reading <i id="l" class="fa-solid fa-book-open"></i></li>
              <li>Reading Activity <i id="ra" class="fa-solid fa-book-open-reader"></i></li>
              <li>Prizes <i id="p" class="fa-solid fa-trophy"></i></li>
              <li>Friends <i id="f" class="fa-solid fa-user-group"></i></li>
          </ul>
      </div>
      <main>
          <div id="name">
            <h1>{{username}}</h1>
              </div>
              <div id="headline">
          <div id="image">
              <span id="profile-image">
                  <img id="avatar" src="/avatar.jpg">
              </span>
              <profile-picture id="pp"/>
          </div>
          <div id="icons">
              <div id="pagesRead">
                  <p>Pages Read</p>
              <i class="fa-solid fa-file-lines"></i>
              <h6>{{currentUser.pagesRead}}</h6>
              </div>
              <div id="booksComp">
                  <p>Books Completed</p>
              <i class="fa-solid fa-book"></i>
              <h6>{{currentUser.booksCompleted}}</h6>
              </div>
              <div id="moneyEarned">
                  <p>Charity Money Earned</p>
              <i class="fa-solid fa-sack-dollar"></i>
              <h6>${{currentUser.moneyEarned}}</h6>
              </div>
          </div>
              </div>
              <div id="favoriteBooks">
                  
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
        };
    },
     created() {
         databaseService.getCurrentUser(this.$store.state.user.id).then( response => {
            this.currentUser= response.data;
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

#booksComp{
    margin-right: 50px;
}

#catchphrase{
    display: flex;
    width: 600px
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
    font-size: 25px
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
    margin-right: 0px;
}
#logout{
    text-decoration: none;
   color: rgb(245,245,220);
   margin: 20px;
   font-size: 25px;
   font-family: 'abeatbyKai', sans-serif;
}

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
    border-bottom: 4px solid rgb(255,196,12);
    display: flex;
    justify-content: space-between;
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
    width: px;
    height: 200px;
    margin-left: 20px;
    border: 4px solid rgb(255,196,12);
    margin-right: 60px;
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
 }
</style>