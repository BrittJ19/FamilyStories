<template>
  <div>
     <div id="banner">
    <head></head>

    <div id=nav>
        <img id="logo" src="/offWhiteLogo.png">
        <img id="catchphrase" src="/logoText.png">  
    </div>
        
      <div id="innerNav">
        <div id="site-links">
          <router-link id="home" v-bind:to="{ name: 'userProfile' }">Home </router-link>
          <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
          <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
      <div id="promo">
          <h3>Charities</h3>
      <!-- <router-link id="link" :to="{ name: 'register' }"><p>Check Activity</p></router-link> -->
        </div>
    </div>
    <main>
      <div id=Charities>
        <a href="https://bookaid.org/donate/"><img id="logo1" src="/BookAid.png"></a>
        <a href="https://worldliteracyfoundation.org/donate/"><img id="logo2" src="/WLF-LOGO.png"></a>
        <a href="https://secure.roomtoread.org/page/83444/donate/1?ea.tracking.id=Header_Donate_Button&en_og_source=Web"><img id="logo3" src="/roomtoreadlogocolor.png"></a>
        <a href="https://secure.rif.org/page/19541/donate/1?&s_src=main_button&_ga=2.86790161.86917382.1650394505-2144341308.1650394505"><img id="logo4" src="/RIF.jpg"></a>  
      
      </div>
    </main>   
  </div>  
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#banner{
  display: flex;
   background-color: rgb(255,117,24);
   flex-direction: column;
}

#nav{
  display: flex;
  background-color: rgb(255,117,24);
  
}
#catchphrase{
   direction: flex;
   /* flex-grow: 1; */
   height: 150px;
   width: 600px;
   justify-content: flex-start;
   align-content: flex-start;
 }
 
 #promo{
   display: flex;
   /* flex-grow: 1; */
   background-color: rgb(150,165,60);
   justify-self: center;
   justify-content: center;
   font-family: 'abeatbyKai', sans-serif;
   margin-top: 10px;
 }
 h3{
   font-size: 25pt;
   color: rgb(245,245,220);
 }
 #site-links{
  display: flex;
  flex-grow: 1;
  padding-top: none;
  text-decoration: none;
  justify-content: flex-end;
  align-content: flex-end;
  /* justify-content: space-evenly; */
  font-family: 'abeatbyKai', sans-serif; 
}
 #Charities{
  /* display:flex; */
  flex-direction: column;
  background-color: rgb(245,245,220);
  text-align: center;
  /* display: grid; */

    /* width: 100vh; */

    /* grid-template-columns: 1fr 1fr 1fr 1fr;

    grid-template-areas: 
    "logo1 text text ."
    "logo2 text text ."
    "logo3 text text ."
    "logo4 text text ."
    ; */

   
 }
</style>