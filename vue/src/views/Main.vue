
  <template>
  <div id="app">
    <head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Amaranth:wght@700&display=swap" rel="stylesheet">
</head>
    <div id="nav">
      <img id="logo" src="/offWhiteLogo.png">
      <img id="catchphrase" src="/logoText.png">
      <!-- <div id="text">
      <h1 id="logoText">FAMILY STORIES</h1>
      <h3 id="phrase">Growing minds, families, and communities one page at a time.</h3>
      </div> -->
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us</router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div>
      <router-view id="login" />
      </div>
    </div>
    <div id="promo">
      <p>JOIN TODAY AND GET AN EXTRA $5 FOR CHARITY UPON COMPLETING 500 PAGES!</p>
      </div>
    <!-- <slider /> -->
    <img id="familyReading" src="/shutterstock_1690275997.jpg">
  </div>
</template>

<script>
// import Slider from "./components/Slider.vue";
export default {
  name: "app",
  components: {
    // Slider
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&display=swap');
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
body {
  margin: 0px;

}

#nav{
  display: flex;
  /* background-color: rgb(64,224,208); */
  /* background-color: darkorange; */
 
}

 #logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
 }

 #images{
   height: 5px
 }

 #app{
   display: flex;
  flex-direction: column;
   background-color: rgb(255,117,24)
 }
 #nav{
   display: flex;
   align-content: center;
   /* flex-direction: column; */
   justify-content: space-between
 }

 #familyReading{
   height: 80%;
   width: 100%;
 }

 #text{
   display: flex;
   flex-direction: column
 }

 #logoText{
   display: flex;
   color: rgb(245,245,220);
   align-self: center;
   justify-content: flex-end;
   align-content: flex-end;
   align-content: space-between;
   font-size: 80px;
   font-family: 'Amaranth', sans-serif;
   align-items: stretch;
   /* -webkit-text-stroke: 2px rgb(150,165,60) */
 }  

 #promo{
   display: flex;
   flex-grow: 1;
   background-color: rgb(150,165,60);
   justify-self: center;
   justify-content: center;
   color: rgb(245,245,220);
   
 }

 #phrase{
   display: flex;
   flex-grow: 1;
   color: rgb(245,245,220);
   align-content: flex-start;
   justify-content: flex-start;
   align-self: flex-start;

 }

 #catchphrase{
   direction: flex;
   flex-grow: 1;
   height: 150px;
   width: 600px;
   justify-content: flex-start;
   align-content: flex-start;
 }

 #innerNav{
   display: flex;
   flex-direction: column;
   flex-grow: 1;
   justify-content: center;
   align-content: center;
   justify-content:space-between
 }

 #site-links{
   display: flex;
   align-items: stretch;
   align-content: flex-start;
   justify-content: center;
   margin-top: 10px;
 }

 #home{
   color: rgb(245,245,220);
   text-decoration: none;
   margin-right: 30px;
   padding-right: 30px;

 }
 #about{
   color: rgb(245,245,220);
   text-decoration: none;
   margin-right: 30px;
   padding-right: 30px;

 }
 #charities{
   color: rgb(245,245,220);
   text-decoration: none;
   margin-right: 34px;

 }

 #login{
   display: flex;
   align-content: flex-start;
   justify-content: flex-end;
   flex-grow: 1;
   height: 5px;
 }
</style>

<script>
export default {

}
</script>

<style>

</style>