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
        <!-- <img id="books" src="/books.png"> -->
      <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'login' }">Home </router-link>
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
      <div
      class="alert alert-creation"
      role="alert"
      v-if="this.$route.query.creation"
      >Thank you for registering, use the search to add new user to family account.</div>
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
      <div id="submit-button">
      <button id="submit" type="submit">Sign  In</button>
      </div>
    </form>
  </div> 
    <div id="options">
      <router-link id="needAccount" :to="{ name: 'register' }">Need an account?</router-link>
      <router-link id="troubleshoot" :to="{ name: 'troubleshoot'}">Can't remember username or password?</router-link>
      </div>
  </div>
 </div>
  <div id="promo">
      <router-link id="link" :to="{ name: 'register' }"><p>JOIN TODAY AND GET AN EXTRA $5 FOR CHARITY UPON COMPLETING 500 PAGES!</p></router-link>
      </div> 
  </div>
  <img id="familyReading" src="/family2.jpg">
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
@import url('http://fonts.cdnfonts.com/css/abeatbykai');
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap');

#options{
  display: flex;
  height: 10px;
  align-self: flex-end;
  margin-bottom: 10px
}

#submit-button{
  margin-top: 0px;
  /* width: 100%; */
  margin-left: 5x;
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

 #link{
   text-decoration: none;
   color: rgb(245,245,220);
 }

#submit{
  /* display: flex;
  border-radius: 10%;
  width: 100%;
  height: 0;
  justify-content: center;
  justify-self: center;
  align-self: center; */
  background-color: rgb(150,165,60);
  font-size: 15px;
  font-family: 'abeatbyKai', sans-serif;
  color: rgb(245,245,220);
  padding: 12px;
  border-radius: 10%;
  /* padding: 20px;
  color: rgb(245,245,220);
  margin-right: 5px; */
  padding-right: 18px;
  padding-left: 18px;
}

#submit:hover{
  height: 55px;
  width: 100px;
  border: 2px solid rgb(255,196,12);
}

#troubleshoot{
  display: flex;
  flex-grow: 1;
  text-decoration: none;
  color: rgb(255,196,12);
  height: 10px;
}

/* #books{
  height: 400px;
  width: 180px;
} */

/* #buttons{
  display: flex;
  flex-direction: column;
  padding: 10px;
  font-family: 'abeatbyKai', sans-serif;
} */

#needAccount{
  display: flex;
  flex-grow: 1;
  height: 5px;
  padding-bottom: 10px;
  color: rgb(255,196,12);
  text-decoration: none;
  justify-content: flex-start;
  align-content: flex-start;
  align-self: flex-start;
  font-family: 'abeatbyKai', sans-serif;
  margin-bottom: 100px;
  margin-left: 7px;
  margin-right: 50px
}

#pic{
  display: flex;
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

.form-signin{
  display: flex;
  align-items: stretch; 
  flex-wrap: wrap;
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
  /* flex-grow: 1; */
  justify-content: flex-end;
  align-content: flex-end;
  align-self: flex-end;
  background-color: rgb(255,117,24);
  font-family: 'abeatbyKai', sans-serif;
  /* font-family: 'Montserrat Alternates', sans-serif;
  color: black; */
  
}

.sr-only{
display: flex;  
background-color: rgb(255,196,12);
border: 4px solid rgb(150,165,60);
padding: 10px;
margin: 5px;
justify-content: center;
align-content: center;
align-self: center;
border-radius: 10px;
/* color: rgb(245,245,220); */
}

input{
  border: 4px solid rgb(150,165,60);
  border-radius: 5%;
  height: 32px;
  display: flex;
  justify-content: center;
  align-content: center;
  align-self: center;
  margin-right: 10px;
}

#catchphrase{
   direction: flex;
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
  /* display: flex; */
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
  /* flex-grow: 1; */
}

#familyReading{
  widows: 100px;
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

/* input{
  height: 32px;
  display: flex;
  justify-content: center;
  align-content: center;
  align-self: center;
} */

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
