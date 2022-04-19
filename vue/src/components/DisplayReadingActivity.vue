<template>
  <main>
      <div class = "container"><img id="logo" src="offWhiteLogo.png"></div>
      <div class = "reader"><h3> {{reader}}<h3><br>
      <h3> {{reader.title}}<h3><br>
      <h3> {{reader.format}}<h3><br>
      <h3> {{reader.numberOfPagesRead}}<h3><br>
      <h3> {{reader.minutesRead}}<h3><br>
      <h3> {{reader.notes}}<h3>
      </div>
  </main>
</template>

<script>
export default {
     name: "display-reading",
  props: ["reader"],
  methods: {
    
  }

}
</script>

<style scoped>
.container{
  background-color: rgb(255,117,24);
  }
  
  #logo{
     width: 180px;
     height: 120px;
     display: flex;
     align-self: center;
    color: rgb(245,245,220);
    filter: opacity(0.5) drop-shadow(0,0,0 rgb(150,165,60));
   }
.reader{
    font-family: 'Square Peg', cursive;
    font-weight: normal;
    color:ivory;
}
</style>