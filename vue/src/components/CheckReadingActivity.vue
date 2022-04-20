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
     <table style="table-layout:fixed">
          <thead style="display:table-header-group">
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
                               
                <td id="date">{{log.dateTime}}</td>
                  <td id="username" style="width: 20px">{{ log.username }}</td>
                  <td id="accountType" style="width: 20px">{{log.accountType}}</td>
                   <td id="title" style="width: 20px">{{log.bookTitle}}</td>
                   <td id="format" style="width: 20px">{{log.format}}</td>
                   <td id="time" style="width: 20px">{{log.timeReading}}</td>
                   <td id="pages" style="width: 20px">{{log.pagesRead}}</td>
                   <td id="finish" style="width: 20px">{{log.completed}}</td>
                   <td id="notes" style="width: 20px">{{log.notes}}</td>     
                   <!-- <button class="btn btn-xs btn-danger" @click="deleteEvent(event)">Delete</button>             -->
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
 }


/* table {
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
  margin: 10px;
} */
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