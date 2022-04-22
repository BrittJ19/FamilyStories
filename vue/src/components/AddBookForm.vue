<template>

<div>
  <form class="add-book-form" v-on:submit.prevent="addBook">
    <input class="title-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="author-input" type="text" placeholder="Author" v-model="book.author" />
    <input class="isbn-input" type="text" placeholder="ISBN" v-model="book.isbn" />
    <button>Add</button>
  </form>
</div>
</template>

<script>
import DatabaseService from '../services/DatabaseService';


export default {

    name: "add-book-form",
    data() {
        return {
            book: {
                title: '',
                author: '',
                isbn: ''
            },
            library: []
        }
    },
    created() {
        DatabaseService.getBook(this.$store.state.user.id).then(resp => {
            this.library=resp.data;
            this.library.forEach(element => {
                this.$store.commit('ADD_BOOK', element)
                console.log(resp.data)
            });
        })

    },
   
    methods: {
        addBook() {
            DatabaseService.createBook(this.$store.state.user.id,this.book)
             this.$store.commit('ADD_BOOK', this.book)
            // .then(resp =>{
            //     if(resp.status == 200) {
            //         this.$router.push({
            //             name:'myBooks'
            //         })
            //     }
            // });
            
            // // this.book = {
            // //     title: '',
            // //     author: '',
            // //     isbn: ''
            // };
        }
    },
    computed: {
        updateLibrary() {
            return this.$store.state.books
        }
    }
}
</script>

<style Scoped>
</style>