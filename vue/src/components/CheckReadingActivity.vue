<template>
  <div>
      <head>
        <!-- <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap" rel="stylesheet"> -->
        <!-- <link href="http://fonts.cdnfonts.com/css/abeatbykai" rel="stylesheet">              -->
    <div id="nav">
      <img id="logo" src="/offWhiteLogo.png">
      <img id="catchphrase" src="/logoText.png"> 
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      </div>
      <div id="left">
        <!-- <img id="books" src="/books.png"> -->
      </div>  
      <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
  </div>
    
    </head>
  
    <table id="CheckActivity">
      <thead>
        <tr>
          <th>User</th>
          <th>Current Book</th>
          <th>Minutes Read</th>
          <th>Books Completed</th>
          <th>Prize Tracker</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Andre</td>
          <td>"Outwitting the Devil"</td>
          <td>44</td>
          <td>"The color purple"</td>
        </tr>
        <tr>
          <td>Ayesha</td>
          <td></td>
          <td></td>
          <td></td>
          

        </tr>
      </tbody>

    </table>


      
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#CheckActivity {
  
  font-family: Arial;
  border: 5px solid black;
  margin: 10px;

}
th {
  text-align: left;
  text-decoration: underline;
  border-bottom: 5px solid black;
  border: 10px;
  margin: 10px;
}

tbody {
  text-align: left;
  border-bottom: 5px solid black;
  margin: 10px;
}
#logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
 }
</style>