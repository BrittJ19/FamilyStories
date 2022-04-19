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
          <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
          <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
          <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
      <div id="promo">
          <h3>Check Activity</h3>
      <!-- <router-link id="link" :to="{ name: 'register' }"><p>Check Activity</p></router-link> -->
        </div>
    </div>
      <div id="CheckActivity">
      
      </div>   
  </div> 
  
  <main> 
    <div id=Check>  
     <table>
          <thead>
              <th>Username</th>
              <th>Account Type</th>
              <th>Title</th>
              <th>Book Format</th>
              <th>Time</th>
              <th>Pages Read</th>
              <th>Book Finished</th>
              <th>Notes</th>
          </thead>
          <tbody>
              <tr v-for="log in logs" v-bind:key="log.recordId">
                  <td id="username">{{ log.username }}</td>
                  <td id="accountType">{{log.accountType}}</td>
                   <td id="title">{{log.bookTitle}}</td>
                   <td id="format">{{log.format}}</td>
                   <td id="time">{{log.timeReading}}</td>
                   <td id="pages">{{log.pagesRead}}</td>
                   <td id="finish">{{log.completed}}</td>
                   <td id="notes">{{log.notes}}</td>     
                   <button class="btn btn-xs btn-danger" @click="deleteEvent(event)">Delete</button>            
                  <!-- <td id="books">{{family.booksCompleted}}</td>
                  <td id="pages">{{family.pagesRead}}</td>
                  <td id="money">$ {{family.moneyEarned}}</td> -->
                </tr>
          </tbody>
      </table>
    </div>
  </main>
 
</div>
      
    
</template>

<script>
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
export default {

}
</script>

<style scoped>

#Check{
  display: flex;
   background-color: rgb(245,245,220);
   text-align: center;
   
 }
table {
  font-family: Arial;
  border: 5px solid black;
  margin: 10px;
}
th {
  text-align: left;
  text-decoration: underline;
  border-left: 1px solid black;
  margin: 10px;
}
td{
  border-left: 1px solid black;
}

tbody {
  text-align: left;
  border-bottom: 1px solid black;
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
   flex-grow: 1;
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
 /* #left{
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  justify-content: flex-end;
  align-content: flex-end;
  margin-right: 20px
} */
 
#banner{
  display: flex;
   background-color: rgb(255,117,24);
   flex-direction: column;
}

#nav{
  display: flex;
  background-color: rgb(255,117,24);
  
}
/* #innerNav{
  display: flex;
  align-content: right;
  justify-content: center;
  margin-bottom: 30px;
} */
#site-links{
  display: flex;
  /* flex-grow: 1; */
  padding-top: none;
  text-decoration: none;
  justify-content: flex-end;
  /* align-content: flex-end; */
  /* justify-content: space-evenly; */
  font-family: 'abeatbyKai', sans-serif; 
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
</style>