<template>
<div id="main">
  <div id="banner">
     <head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap" rel="stylesheet">
<link href="http://fonts.cdnfonts.com/css/abeatbykai" rel="stylesheet">             
</head>
  <div id="navC">
  <div id="reg" class="text-center">
      <div id="heading">
      <h1>CREATE NEW ACCOUNT</h1>
      <p>{{message}}</p>
      </div>
    <form class="fr" @submit.prevent="register">
      <!-- <h1 class="h3 mb-3 font-weight-normal">Create Account</h1> -->
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="in"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="in"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="in"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
       <div class="form-element">
              <label for="account-type" id="aType"> Account Type:</label>
                  <select id="types" v-model="user.accountType">
                      <option value="parent">Adult</option>
                      <option value="child">Child</option>
                      <option value="other">Other</option>
                  </select>
          </div> 
      <!-- <router-link id="account" :to="{ name: 'login' }">Have an account?</router-link> -->
      <div id="submit-button">
      <button id="sub" class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>
      <router-link v-bind:to="{ name: 'addUser' }"><button id="back">Back</button></router-link>
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

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        accountType: '',
      },
      message: '',
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
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
  },
};
</script>

<style scoped>
body{
    /* background-color: rgb(245,245,220); */
    background-image: url("/background.jpg");
    background-size: 100vh;
    margin:0px
}
#reg{
    display: flex;
    flex-direction: column;
    background-color: rgb(150,165,60);
    justify-content: center;
    margin: 100px;
    height: 60vh;
    margin-left: 300px;
    margin-right: 300px;
    border-radius: 5%;
    
}
.fr{
    padding-top: 0%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-self: center;
    width: 30%
    /* padding: 50px; */
}
.sr-only{
    padding: 15px
}

.in{
    margin: 20px;
    height: 30px;
    border-radius: 5%;
}
#sub{
    align-self: center;
      margin-left: auto;
    margin-right: auto;
   
}
label{
    margin-left: 35px;
    color: rgb(245,245,220);
    font-family: 'abeatbyKai', sans-serif;
    font-size: 20px;
}
h1{
    display: flex;
    margin-top: 50px;
    align-self: center;
    justify-content: center;
    margin-left: 200px
}
#submit{
    padding: 100px;
    border-radius: 10%;
}
#back{
  /* padding: 15px;
  border-radius: 10%;
  width: 140px;
  margin-left: 40px; */
  display: flex;
  align-self: center;
  justify-content: center;
  align-content: center;
   margin-left: auto;
    margin-right: auto;
    width: 130px

}
.form-element{
  display: flex;
  flex-direction: column;
}
#types{
  height: 30px;
    margin-left: auto;
    margin-right: auto;
    width: 355px
}
#aType{
  padding: 5px;
    margin-left: auto;
    margin-right: auto;
}
button{
  display: flex;
  align-self: center;
}
#navC{
  
}


</style>