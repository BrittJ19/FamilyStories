<template>
  <div>
      <img src="https://cdn.dribbble.com/users/411641/screenshots/4405331/media/1b59c76446403889df4947b5c028680c.gif">
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
body{
    background-image: url("/loadingGif.gif");
    background-size: 100vh;
}
div{
    display: flex;
}
img{
    display: flex;
    justify-content: center;
    align-content: center;
    align-self: center;
    flex-grow: 1;
}
</style>

