<template>
 <main>
    <div class = "container"><img id="logo" src="offWhiteLogo.png"></div>
  
    
  <form class = "containerTwo" id = "menu" v-on:submit.prevent="addReadingActivity">
    <div>
    <h2>Record Reading Activity</h2>
    </div>
    <div>
      <label class = "form-element" for="reader" >Reader</label>
      <input type="text" v-model="readingActivity.reader" id="reader" name="reader" placeholder= "Your name.."><br>
    </div>

    <div>
    <label  class = "form-element" for="title">Title</label>
    <input type="text" v-model="readingActivity.title" id="title" name="title" placeholder= "Book name.."><br>
    </div>

    <div>
    <label class = "form-element"  for="format">Format</label>
    <select id="format" name="format" v-model="readingActivity.format">
    <option value="paper">Paper</option>
    <option value="digital">Digital</option>
    <option value="audioBook">Audio Book</option>
    <option value="readAloud">Read Aloud (Reader)</option>
    <option value="readAloudListener">Read Aloud (Listener)</option>
    <option value="other">Other</option>
    </select><br>
    </div>

     <div>
    <label  class = "form-element" for="page">Number of Pages Read</label>
    <input type="number" v-model.number="readingActivity.pages" id="page" name="page"><br>
    </div>

    <div>
    <label  class = "form-element" for="minutes">Minutes Read</label>
    <input type="number" v-model.number="readingActivity.minutes" id="minutes" name="minutes"><br>
    </div>

    <div>
    <label  class = "form-element" for="notes">Notes</label>
    <input type="text" v-model="readingActivity.notes" id="notes" name="notes"><br>
    </div>

    <div>
    <button class = "actions"  type="submit" value= "submit">Add Activity</button> 
    </div>
  </form>

  
  </main>
</template>

<script>
export default {

}
</script>

<style scoped>

  body{
  background-image: url('/shutterstock_1690275997.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 1600px 1000px;
  height: 700px;
  }
  h2{
    font-family: 'Square Peg', cursive;
    font-weight: normal;
    color:ivory;
  }

  #menu {
      text-decoration: none;
     color: rgb(245,245,220);
     margin: 20px;
     font-size: 25px;
     font-family: 'Square Peg', cursive;
     border-style: hidden;
    background-color: hsla(120,100%,25%,0.3);
    padding-top: 50px;
    padding-right: 30px;
    padding-bottom: 50px;
    padding-left: 80px;
  
  }
  input {
  width: 20%;
  border: 1px solid rgb(255,117,24);
  padding: 10px 10px;
  border-radius: 6px;
  background-color: rgb(245, 230, 185);
  font-size: 15px;
  cursor: pointer;
}
select{
  width: 20%;
  padding: 10px 10px;
  border: 1px solid rgb(255,117,24);
  border-radius: 6px;
  background-color: rgb(245, 230, 185);
  font-size: 15px;
  cursor: pointer;
}
button {
  background-color: darkgreen;
  border-radius: 6px;
  border: 1px solid ;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  font-size: 15px;
}

  .container{
  background-color: rgb(255,117,24);
  }
  .containerTwo{
    font-family: 'abeatbyKai', sans-serif ;
    width: 500px;
    border-radius: 10px; 
  
  }

  #logo{
     width: 180px;
     height: 120px;
     display: flex;
     align-self: center;
    color: rgb(245,245,220);
    filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
   }
  
   
  
  </style>
