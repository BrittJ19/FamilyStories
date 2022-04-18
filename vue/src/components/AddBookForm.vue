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


export default {
   
    name: "add-book-form",
    data() {
        return {
            book: {
                title: '',
                author: '',
                isbn: ''
            }
        }
    },
    methods: {
        addBook() {
            this.$store.commit('ADD_BOOK', this.book);
            this.book = {
                title: '',
                author: '',
                isbn: ''
            };
        }
    }
}
</script>

<style Scoped>
.add-book-form {
    margin: 20px;
}

.add-book-form input, .add-book-form button {
    margin: 10px;
    font-size: 1rem;
}

</style>