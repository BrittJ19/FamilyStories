<template>
   <div class='new-friends'>
     <div class= "friend-username">
          {{ friends.nickname }}
      </div>
    <div class="friend-userId">
        {{ friends.user_id }}
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

