<template>
 <div>
     <find-friends-form/>
 </div>


</template>


<script>
import FindFriendsForm from '../components/FindFriendsForm.vue'
export default {

    name: "friends",
  components: {FindFriendsForm},
  methods: {

} 

}
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

#search-button{
  width: 100%;
  margin-left: 5px;
}

#promo{
   display: flex;
   flex-grow: 1;
   background-color: rgb(150,165,60);
   justify-self: center;
   justify-content: center;
   color: rgb(245,245,220);
   font-family: 'abeatbyKai', sans-serif;
   margin-top: 10px;
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
  padding: 10px;
  border-radius: 10%;
  /* padding: 20px;
  color: rgb(245,245,220);
  margin-right: 5px; */
  padding-right: 18px;
  padding-left: 18px;
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
  border-radius: 5%
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

</style>