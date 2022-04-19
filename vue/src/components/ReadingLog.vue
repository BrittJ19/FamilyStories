<template>
<div id="main">
  <div id="notBanner">
     <head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap" rel="stylesheet">
<link href="http://fonts.cdnfonts.com/css/abeatbykai" rel="stylesheet">             
</head>
  <div id="nav">
  <div id="register" class="text-center">
      <div id="heading">
      <h1>Record A Reading Session</h1>
      <p>{{message}}</p>
      </div>
    <form class="form-register" @submit.prevent>
    <div id="search" class="form-element">
              <!-- <button id="searchButton">Search Users to Add</button> -->
              <p>Reader</p>
              <select name="results" id="results" v-model="readingRecord.accountType" @change="onChange($event)">
                  <option disabled selected value>-- select an option --</option>
                  <option :value="userData.accountType">{{this.$store.state.user.username}}</option>
                <option :value ="user.accountType" v-for="user in childAccounts" v-bind:key="user.id">{{user.username}}</option>
              </select>
          </div> 
           <p id="title"> Book Title</p>
<input type="text" id="titleInput" name="titleInput" v-model="readingRecord.bookTitle">
           <div class="form-element">
              <p> Select book format</p>
                  <select id="selections" v-model="readingRecord.format">
                      <option disabled selected value>-- select an option --</option>
                      <option value="Paper">Paper</option>
                      <option value="Digital">Digital</option>
                      <option value="Audiobook">Audiobook</option>
                       <option value="Read Aloud (Reader)">Read Aloud (Reader)</option>
                      <option value="Read Aloud (Listener)">Read Aloud (Listener)</option>
                      <option value="Other">Other</option>
                  </select>
          </div> 
          <div>
            <p id="pages"> Pages Read</p>
<input type="number" id="pages" name="pages"
       min="5" max="100" step="5" v-model.number="readingRecord.pagesRead">
       </div>
          <div id="minutes">
          <p id="minutes"> Minutes Reading</p>
<input type="number" id="tentacles" name="minutes"
       min="5" max="100" step="5" v-model.number="readingRecord.time">
       </div>
       <div class="form-element">
              <p> Are you finish with this book?</p>
                  <select id="selections" v-model="readingRecord.completed">
                      <option disabled selected value>-- select an option --</option>
                      <option value=True>Yes</option>
                      <option value=False>No</option>
                  </select>
          </div> 
          <p>Notes</p>
          <input type="text" id="notes" name="notes" v-model="readingRecord.notes" maxlength="300">
      <!-- <h1 class="h3 mb-3 font-weight-normal">Create Account</h1> -->
      
      <!-- <router-link id="account" :to="{ name: 'login' }">Have an account?</router-link> -->
      <div id="submit-button">
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit" @click="addLog()">
        Log Reading
      </button>
      </div>
      <router-link v-bind:to="{ name: 'userProfile' }"><button id="back">Back</button></router-link>
    </form>
  </div>
  </div>
  </div>
  </div>
  <!-- </div>
  </div> -->
</template>

<script>
import authService from '../services/AuthService';
import databaseService from '../services/DatabaseService';

export default {
  name: 'register',
  data() {
    return {
        readingRecord: {
            userId: '',
            accountType: '',
            bookTitle: '',
            format: '',
            time: '',
            pagesRead: '',
            completed: '',
            notes:''

        },
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        accountType: '',
      },
      familyMember: {
          authorities: [],
          booksCompleted: '',
          familyName: '',
          id: '',
          moneyEarned: '',
          pagesRead: '',
          username: '',
      },
      account:[],
      allAccounts:[],
      familyMembers: [],
      familyAccounts: [],
      childAccounts: [],
      userData: {},
      message: '',
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
   created() {
         databaseService.getCurrentUser(this.$store.state.user.id).then( response => {
            this.currentUser= response.data;
            })
          this.isLoading = true;
        databaseService.getFamilyAccounts(this.$store.state.user.id).then(response => {
            this.familyAccounts = response.data;
            response.data.forEach( account => {
        databaseService.getUserByFamily(account.familyId).then( resp=> {
            this.familyMembers.push(resp.data)
            resp.data.forEach( user => {
                this.account.push(user.id)
            })
            this.account.forEach( resp => {
                databaseService.getCurrentUser(resp).then( response => {
                    this.allAccounts.push(response.data)
                    if(response.data.username == this.$store.state.user.username){
                    this.userData = response.data}
                    if(response.data.accountType == 'child'){
                        this.childAccounts.push(response.data)
                    }
                })
            })
           
        })
        this.account.forEach(id => {
            databaseService.getCurrentUser(id).then(response => {
                this.childAccounts.push(response.data)
            })
        })


            
        })})
     },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/family/addUser',
                query: { creation: 'creation' },
              });
              this.message = "Account created, use the search to add user to family."
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    logReading() {

    },
    onChange(event) {
              var optionText = event.target.options[event.target.options.selectedIndex].text;
                this.allAccounts.forEach( a => {
                    if(a.username == optionText){
                        this.readingRecord.userId = a.id
                    }
                })        

              },
               addLog() {
      databaseService.addReadingRecord(this.readingRecord.userId, this.readingRecord).then(resp => {
          if (resp.status == 200) {
              this.$router.push({
                  path: '/family'
              })
          }
      })


  }
  },
 
};
</script>

<style scoped>
#notBanner{
    display: flex;
    width: 100vh;
    flex-grow: 1;
}
#main{
    display: flex;
    height: 100vh;
}
#heading{
    display: flex;
    align-self: center;
    margin-top: 50px
    /* flex-grow: 1; */
    /* align-items: stretch; */
}
#nav{
    display: flex;
    /* width: 100vh; */
    align-self: center;
    flex-grow: 1;
    margin:400px
}
#select{
    display: flex;
    flex-grow: 1;
    align-self: center;
    align-content: center;

}
label{
    display: flex;
    flex-grow: 1;
}
body{
    /* background-color: rgb(245,245,220); */
    background-image: url("/background.jpg");
    background-size: 100vh;
    margin:0px
}
#register{
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    background-color: rgb(150,165,60);
    justify-content: center;
    align-self: center;
    /* margin: 100px; */
    height: 100vh;
    width: 100vh;
    /* margin-left: 300px;
    margin-right: 300px; */
    border-radius: 5%
}
form{
    padding-top: 0%;
    display: flex;
    flex-grow: 1;
    flex-direction: column;
    justify-content: flex-start;
    align-self: center;
    align-content: center;
    /* padding: 50px; */
}
.sr-only{
    padding: 5px
}

input{
    margin: 5px;
    height: 30px;
    border-radius: 5%;
    width: 200px
}
#submit{
    align-self: center;
}
label{
    margin-left: 35px;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
    font-size: 15px;
}
h1{
    display: flex;
    flex-grow: 1;
    margin-top: 15px;
    align-self: center;
    justify-content: center;
}
#submit{
    padding: 15px;
    border-radius: 10%;
}
#back{
    align-self: center;
  padding: 15px;
  border-radius: 10%;
  width: 120px;
}
.form-element{
  display: flex;
  flex-direction: column;
  align-self: center;
  align-content: center;
  margin: 10px
}
#selections{
  height: 30px;
}
.form-register{
    align-items: center;
    align-content: center;
    padding: 5px
}
p{
    align-self: center;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
}
#results{
    padding: 8px;
    width: 225px
}
#minutes{
    display: flex;
    flex-direction: column;
    align-self: center;
    width: 270px
}


</style>