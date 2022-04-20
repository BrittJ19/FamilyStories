<template>
   <div class='new-friends'>
     <div class= "friend-username">
          {{ book.title }}
      </div>
    <div class="friend-userId">
        {{ friend.user_id }}
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
.new-friends{
    display: inline-flex;
    flex-direction: column;
    margin-right: 50%;
}
</style>

