<template>
   <div class='new-friends'>
     <div class= "friend-username">
          {{ book.title }}
      </div>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <div class="friend-userId">
        {{ frined.user_id }}
    </div> 
    <div class="friend-favorite-book">
        {{ friend.favorite_book }}
    </div>
  </div>
</template>

<script>

export default {
    name:'new-friend',
    props:["friend"]
}
</script>

<style scoped>

</style>

