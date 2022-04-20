<template>
  <div class="book-search" v-on:submit.prevent="getBook">
 <input class="title-input" type="text" placeholder="Title" v-model="book.title" />
 <input class="author-input" type="text" placeholder="Author" v-model="book.author" />
 <input class="isbn-input" type="text" placeholder="ISBN" v-model="book.isbn" />
<input type="search" class="search-form" v-model="query">
<input type="submit" class= "btn btn-primary">
  </div>
</template>

<script>

export default {
    data(){
        return{
            query: {
                title: '',
                author: '',
                isbn: ''
            }
        }
        
    },
    methods: {
    

    }

}
</script>

<style>

</style>