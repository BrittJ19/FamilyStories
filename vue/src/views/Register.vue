<template>
<div id="main">
  <div id="banner">
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
      <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
 </div>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <!-- <h1 class="h3 mb-3 font-weight-normal">Create Account</h1> -->
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <!-- <router-link id="account" :to="{ name: 'login' }">Have an account?</router-link> -->
      <div id="submit-button">
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>
    </form>
  </div>
   <div id="option">
      <router-link id="account" :to="{ name: 'login' }">Have an account?</router-link>
      </div>
  </div>
  </div>
   <div id="promo">
      <p>JOIN TODAY AND GET AN EXTRA $5 FOR CHARITY UPON COMPLETING 500 PAGES!</p>
      </div> 
  </div>
  <img id="familyReading" src="/family2.jpg">
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
      },
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
                path: '/login',
                query: { registration: 'success' },
              });
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
#password{
  margin-right: 5px;
}
#option{
  display: flex;
  height: 10px;
  align-self: flex-end;
  margin-bottom: 10px
}

input{
  border: 4px solid rgb(150,165,60);
  padding: 10px
}
#account{
  display: flex;
  flex-grow: 1;
  padding-top: 10px;
  color: rgb(245,245,220);
  text-decoration: none;
  /* width: 100%; */
  justify-content: flex-start;
  align-content: flex-start;
  align-self: flex-start;
  font-family: 'abeatbyKai', sans-serif;
}

#familyReading{
  display: flex;
   height: 80%;
   width: 100%;
 }

 #submit-button{
  width: 100%;
  margin-left: 5px;
}

#buttons{
  display: flex;
  flex-direction: column;
  padding: 10px;
  align-items: stretch;
  height: 100%;
  font-family: 'abeatbyKai', sans-serif;
  justify-content: space-between;
  align-content: space-between;
}

#site-links{
 display: flex;
  flex-grow: 1;
  padding-top: 10px;
  text-decoration: none;
  justify-content: flex-end;
  align-content: flex-end;
  font-family: 'abeatbyKai', sans-serif;
  
}

#submit{
  /* display: flex; */
  border-radius: 7%;
  height: 100%;
  justify-content: flex-start;
  justify-self: flex-start;
  font-size: 15px;
  font-family: 'abeatbyKai', sans-serif;
  margin-left: 5px;
  padding: 20px
  /* padding: 12px; */
}


#main{
  display: flex;
  flex-direction: column;
}

#nav{
  display: flex;
  background-color: rgb(255,117,24);
  /* width: 100%; */
}

#register{
  display: flex;
  flex-direction: column;
  /* widows: 100%; */
  justify-content: flex-end;
  align-content: flex-end;
  align-self: flex-end;
  background-color: rgb(255,117,24);
  font-family: 'abeatbyKai', sans-serif;
  margin-right: 20px
  /* font-family: 'Montserrat Alternates', sans-serif;
  color: black; */
  
}

.form-register{
  display: flex;
  align-items: stretch;
  justify-content: center;
  align-content: center;
  align-self: center;
  height: 40px;
  margin-bottom: 30px;
}

/* .sr-only{
  display: flex;
  font-family: 'abeatbyKai', sans-serif;
} */

#left{
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  /* align-items: stretch; */
  justify-content: flex-end;
  align-content: flex-end;
}

#catchphrase{
   direction: flex;
   height: 160px;
   width: 520px;
   justify-content: center;
   align-content: center;
   align-self: center;
 }

#logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
 }

#promo{
   display: flex;
   flex-grow: 1;
   background-color: rgb(150,165,60);
   justify-self: center;
   justify-content: center;
   color: rgb(245,245,220);
   font-family: 'abeatbyKai', sans-serif;
 }

.sr-only{
display: flex;  
background-color: rgb(255,196,12);
padding: 10px;
margin: 5px;
/* height: 21px; */
justify-content: center;
align-content: center;
align-self: center;
border-radius: 10px;
border: 4px solid rgb(150,165,60);

}

#register{
  display: flex;
border-width: 10px;
border-color: rgb(79,134,247);
align-content: space-between;
}

#innerNav{
  display: flex;
  align-content: center;
  justify-content: center;
  margin-bottom: 25px;
  /* width: 100%; */
}

#home{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px;
  padding: 20px;
  padding-right: 70px;
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
  padding: 20px;
  margin-left: 30px;
}

#charities:hover{
  font-size: 30px;
}

.form-register{
  display: flex;
  justify-content: center;
  align-content: center;
  align-self: center;
  height: 30%;
}

input{
  display: flex;
  align-self: center;
  height: 60%;
  border-radius: 5%
}

#account{
  display: flex;
  text-decoration: none;
  color: rgb(255,196,12);
  /* margin: 10px; */
  flex-grow: 1;
  margin-right: 20px;
  /* margin: 5px; */
  /* margin-bottom: 50px; */
}

button{
  background-color: rgb(150,165,60);
  color: rgb(245,245,220);
}

buttons{
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}


</style>
