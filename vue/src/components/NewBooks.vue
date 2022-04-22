<template>
  <div class='new-books'>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <div class= "book-title">
          {{ book.title }}
      </div>
    <div class="book-author">
       By: {{ book.author }}
    </div> 
     </div>
</template>

<script>
export default {
    name: 'new-book',
    props: ["book"]
    
}
</script>

<style Scoped>
@import url('http://fonts.cdnfonts.com/css/abeatbykai');
@import url('https://fonts.googleapis.com/css2?family=Amaranth:wght@700&family=Montserrat+Alternates:wght@100&display=swap');

.new-books{
    font-family: 'abeatbyKai', sans-serif;
    font-size: 20px;
    text-align: center;
   
}
.book-title{
    
    font-weight: bold;
    font-size: 25px;
}


</style>