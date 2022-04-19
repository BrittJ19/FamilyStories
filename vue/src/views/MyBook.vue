<template>
<div>
  <div id= "banner">
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
        <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        </div> 
        </div>
        </div>
    </div>
     <main>
        <div id= "myBooks">
        <h1>My Books</h1>
        <!-- <new-books v-for="(disBook,index) in books" v-bind:key="index"/>  -->
         <!-- <new-books v-for="disBook in book" v-bind:key="disBook.isbn"/>    -->
  </div>
  <div class ="bookShelf">
  <new-books v-for="(disBook,index) in $store.state.books" v-bind:key="index"
  v-bind:book="disBook"/>
   </div>
   <div id= "bookForm">
      <add-book-form/>
      </div>
      </main>
       </div>
       
 
  </div>
     
</template>

<script>
 import NewBooks from '../components/NewBooks.vue'
import AddBookForm from '../components/AddBookForm.vue'


export default {
    components: { AddBookForm,
     NewBooks
 }
}
 
</script>

<style scoped>
@import url('http://fonts.cdnfonts.com/css/abeatbykai');
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap');

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
#logo{
   width: 180px;
   height: 120px;
   display: flex;
   align-self: center;
  color: rgb(245,245,220);
  filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
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
#banner{
  display: flex;
   background-color: rgb(255,117,24);
   flex-direction: column;
}
#nav{
  display: flex;
  background-color: rgb(255,117,24);
  /* flex-grow: 1; */
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
#pic{
  display: flex;
}
#catchphrase{
   direction: flex;
   height: 160px;
   width: 560px;
   justify-content: flex-start;
   align-content: flex-start;
 }
 #myBooks{
   display: flex;
   flex-grow: 1;
   background-color: rgb(150,165,60);
   color: rgb(245,245,220);
   font-family: 'abeatbyKai', sans-serif;
   
}
h1{
  margin-left: 900px;
 
}
main{
    grid-area: main;
     background-color: rgb(245,245,220);
     background-size: 100vh;
    margin:0px
}
.new-books{
  border: 3px solid rgb(150,165,60);
  border-radius: 10px;
  background-color:white;
  margin-top: 10px;
  width: 250px;
  height: 350px;
  margin: 20px;
  margin-right: 40px;
  padding: 40px;
  justify-content: space-evenly;
}
.new-books:hover{

}
#bookForm{
  text-align: center;
  padding: 20px;
}
.bookShelf{
  max-height:  500px;
  border: 1px solid;
  display:flex;
  overflow-x: auto;
}
.bookShelf::-webkit-scrollbar{
  width: 0;
}




</style>