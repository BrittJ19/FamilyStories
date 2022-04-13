<template>
<div id="main">
  <div id="banner">
   <head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap" rel="stylesheet">
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
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <!-- <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1> -->
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <div id="buttons">
      <button id="submit" type="submit">Sign  In</button>
      <router-link id="needAccount" :to="{ name: 'register' }">Need an account?</router-link>
      </div>
    </form>
  </div>
  </div>
  </div>
  <div id="promo">
      <p>JOIN TODAY AND GET AN EXTRA $5 FOR CHARITY UPON COMPLETING 500 PAGES!</p>
      </div> 
  </div>
  <img id="familyReading" src="/shutterstock_1690275997.jpg">
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push({ name: 'userProfile', params: {username: response.data.user.username}});
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap');

#promo{
   display: flex;
   flex-grow: 1;
   background-color: rgb(150,165,60);
   justify-self: center;
   justify-content: center;
   color: rgb(245,245,220);
   font-family: 'Montserrat Alternates', sans-serif;
   font-weight: bold;
   
 }

#submit{
  display: flex;
  border-radius: 10%;
  height: 150%;
  justify-content: flex-start;
  justify-self: flex-start;
}

#buttons{
  display: flex;
  flex-direction: column;
  padding: 10px;
  align-items: stretch;
  height: 150%;
}

#needAccount{
  display: flex;
  flex-grow: 1;
  padding-top: 10px;
  padding-bottom: 10px;
  color: rgb(245,245,220);
  text-decoration: none;
  width: 100%;
  justify-content: flex-start;
  align-content: flex-start;
  align-self: flex-start;
  font-family: 'Montserrat Alternates', sans-serif;
  font-weight: bold;
}

#left{
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  align-items: stretch;
  justify-content: flex-end;
  align-content: flex-end;
}

#innerNav{
  display: flex;
  align-content: center;
  justify-content: center;
  margin-bottom: 30px;
}

#site-links{
  display: flex;
  flex-grow: 1;
  padding-top: 10px;
  justify-content: space-between;
  text-decoration: none;
  justify-content: space-between;
  justify-content: space-evenly;
  font-family: 'Montserrat Alternates', sans-serif;
  font-weight: bold;
  
}

.form-signin{
  display: flex;
  align-items: stretch;
  justify-content: center;
  align-content: center;
  align-self: center;
  height: 40px;
  margin-bottom: 30px;
}

.sr-only{
  display: flex;
}

#login{
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  justify-content: flex-end;
  background-color: rgb(255,117,24);
  /* font-family: 'Montserrat Alternates', sans-serif;
  color: black; */
  
}

input{
  border: 2px solid rgb(150,165,60);
}

#catchphrase{
   direction: flex;
   flex-grow: 1;
   height: 160px;
   width: 560px;
   justify-content: flex-start;
   align-content: flex-start;
 }

#logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
 }

#familyReading{
  display: flex;
   height: 80%;
   width: 100%;
 }

#banner{
  display: flex;
   background-color: rgb(255,117,24);
   flex-direction: column;
}

#main{
  display: flex;
  flex-direction: column;
}

#nav{
  display: flex;
  background-color: rgb(255,117,24);
  flex-grow: 1;
}

#familyReading{
  widows: 100px;
}

#home{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px
}

#about{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px
}

#charities{
  text-decoration: none;
  color: rgb(245,245,220);
  font-size: 20px;
}

/* 
#familyReading{
  height: 80%;
  width: 80%
}

h1{
  display: flex;
  color: white;
  justify-self: center;
}

#nav{
  display: flex;
   flex-direction: column;
}

#main{
  display: flex;
   flex-direction: column;
   background-color: rgb(255,117,24)
}

router-link{
  margin: 5px;
  padding: 5px;
}

.sr-only{
  display: flex;
  justify-content: center;
  align-self: center;
}

#login{
  display: flex;
  align-content: space-between;
  background-color: rgb(255,117,24)
}

.form-signin{
  display: flex;
  align-self: center;
  align-content: center;
  justify-content: center;
  height: 30%;
  justify-content: space-between;
  margin: 20px;
}

button{
  display: flex;
  margin: 10px;
  height: 80%;
  width: 110px;
  align-self: center;
  background-color: rgb(150,165,60);
  border-radius: 10px;
  color: rgb(245,245,220);
  font-size: 20px
}

#needAccount{
  display: flex;
  margin: 10px;
  text-decoration: none;
  color: rgb(245,245,220);
  align-content: center;
  justify-content: center;
  align-self: center;
}

input{
  border: 4px solid rgb(150,165,60)
} */
</style>
