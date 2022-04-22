<template>
<div>
 <div id="banner">
    <head></head>

    <div id=nav>
        <img id="logo" src="/offWhiteLogo.png">
        <img id="catchphrase" src="/logoText.png">  
    </div>
        
      <div id="inner">
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
<!--style="table-layout:fixed" -->
<!-- style="display:table-header-group" -->
  <main id="m"> 
    <div id="name">  
     <table id="table1">
          <thead id="tHead">
              <th style="width: 20px">Date</th>
              <th style="width: 20px">Username</th>
              <th style="width: 20px">Account Type</th>
              <th style="width: 20px">Title</th>
              <th style="width: 20px">Book Format</th>
              <th style="width: 20px">Time</th>
              <th style="width: 20px">Pages Read</th>
              <th style="width: 20px">Book Finished</th>
              <th style="width: 20px">Notes</th>
          </thead>
          <tbody id="tBody">
              <tr v-for="log in logs" v-bind:key="log.recordId">
                  <td id="username" class="rowz">{{ log.username }}</td>
                  <td id="accountType" class="rowz">{{log.accountType}}</td>
                   <td id="title" class="rowz">{{log.bookTitle}}</td>
                   <td id="format" class="rowz">{{log.format}}</td>
                   <td id="time" class="rowz">{{log.timeReading}}</td>
                   <td id="pages1" class="rowz">{{log.pagesRead}}</td>
                   <td id="finish" class="rowz">{{log.completed}}</td>
                   <td id="notes" class="rowz">{{log.notes}}</td>     
                               
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
#m{
    height: 80%;
    padding: 40px
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
 #tBody{
   display: flex;
   align-content: center;
   margin-left: 1400px
 }
 #table1{
     display: flex;
     flex-grow: 1;
     width: 100%;
     flex-direction: column;
     justify-content: space-between;
     justify-content: center;
     align-items: center;
      background-color: rgb(245,245,220);
      text-align: center;
     
 }
  tr{
    display: flex;
    width: 100vh;
    justify-content: space-between;
    padding-right: 200px
     
 }
 #rowz{
   display: flex;
 }
#name{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center ;
    align-items: center;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
      background-color: rgb(150,165,60);
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


#Check{
  display: flex;
   background-color: rgb(245,245,220);
   text-align: center;
   
 }
 table{
   all: initial;
 }
 thead{
   all: initial;
 }
 th{
   all: initial;
 }
 td{
   all: initial;
 }
 main{
   all: initial;
 }
 tr{
   all: initial;
   justify-content: center;
   align-content: center;
 }


table {
  display: flex;
  flex-direction: column;
  text-align: center;
  font-family: Arial;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  flex-grow: 1;
  
}
thead{
  text-align: center;
  flex-grow: 1;
  /* display: flex;
  align-self: center;
  align-content: space-evenly; */
}
th {
  text-align: center;
  text-decoration: underline;
  margin: 10px;
}
td{
padding-left: 20px;
padding-right: 20px;
text-align: center;
}

tbody {
  display: flex;
  align-self: center;
  text-align: center;
  justify-content: center;
  align-content: center;
  margin: 10px;
  width: 100%;
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