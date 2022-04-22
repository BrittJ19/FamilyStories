<template>
  <div class="all">
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
        <router-link id="home" v-bind:to="{ name: 'login' }">Home </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
        </div>
        </div>
  </div>
    </div>
    <div class="ourStory">
        <h1>Our Story</h1>
       </div>
        <p>Family Stories was created in 2022 by a group of aspiring fullstack developers completing their final capstone with Tech Elevator. Over the course of 14 weeks, we've learned the necessary skills to complete this website and embark on our individual careers. Ayesha, Andre, Britt, Rashmi and Zachary worked collectively to create this application that helps families track the amount of reading each family member does. 
As being an active reader is important to both parents and children, both Parents and children can track the books that are being read, as well as the number of minutes spent reading by each family member. 
Books can be entered by entering the data for the book, or by searching an online API based on the ISBN.  Prizes can be awarded by reaching goals set by a parent.  Parents can control the prizes and their children's reading goals.
 </p>

  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
@import url('http://fonts.cdnfonts.com/css/abeatbykai');
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap');


.all{
    display: flexbox;
}
#left{
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  justify-content: flex-end;
  align-content: flex-end;
  margin-right: 20px
}

#innerNav{
  display: flex;
  align-content: center;
  justify-content: center;
  margin-bottom: 30px;
}
#logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
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
#banner{
  display: flex;
   background-color: rgb(255,117,24);
   flex-direction: column;
}
#nav{
  display: flex;
  background-color: rgb(255,117,24);
  /* flex-grow: 1; */
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
  padding-top: 20px;
  margin-right: 10px;
  margin-left: 50px;
}

#charities:hover{
  font-size: 25px;
}
#pic{
  display: flex;
}
#catchphrase{
   direction: flex;
   height: 160px;
   width: 560px;
   justify-content: flex-start;
   align-content: flex-start;
 }
 .ourStory{
    height: 50px;
   display: flex;
   background-color: rgb(150,165,60);
   color: darkolivegreen;
   font-family: 'abeatbyKai', sans-serif;
 }
 h1{
     margin-left: auto;
    margin-right: auto;
   
 }
 p{
     color: rgb(150,165,60);
     text-align: center;
     background-color: rgb(245,245,220);
     line-height: 50px;
 }

</style>