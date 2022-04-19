<template>
  <div class='new-books'>
     <div class= "book-title">
          {{ book.title }}
      </div>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <div class="book-author">
        {{ book.author }}
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



</style>