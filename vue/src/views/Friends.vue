<template>
<div id='friend-page'>
<div id= "banner">
    <head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap" rel="stylesheet">
  <link href="http://fonts.cdnfonts.com/css/abeatbykai" rel="stylesheet">
</head>
  <div id="nav">
      <img id="logo" src="/offWhiteLogo.png">
      <img id="catchphrase" src="/logoText.png"> 
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      <div id="left">
        <!-- <img id="books" src="/books.png"> -->
      <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
        </div>
        </div>
    </div>
</div>
 <main>
        <div id= "myfriends">
        <h1>My Friends</h1>
        <!-- <new-books v-for="(disBook,index) in books" v-bind:key="index"/>  -->
         <!-- <new-books v-for="disBook in book" v-bind:key="disBook.isbn"/>    -->
  <div class ="">
    <div id='friends-list'>
    <friends-list/>
</div>
</div>
  <new-books v-for="(friendo,index) in $store.state.friends" v-bind:key="index"
  v-bind:friend="friendo"/>
   </div>
   <div id= "friend-form">
      <find-friends-form/>
      </div>
      </main>



</div>


</template>


<script>
import FindFriendsForm from '../components/FindFriendsForm.vue'
import FriendsList from '../components/FriendsList.vue'
export default {


  components: {FindFriendsForm, FriendsList}
 

}
</script>

<style scoped>
#banner{
    display: flex;
    flex-grow: 1;
    background-color: rgb(255,117,24);
    justify-content: center;
}
#friends-list{
  display: inline-flex;
  flex-direction: column;
  margin-right: 500px;
}

</style>