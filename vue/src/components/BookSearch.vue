<template>
  <div>
      <form class="bookSearch" v-on:submit.prevent="getbooks()">
          <input id="input" type="text" placeholder="Search Books">
          <div id="output"></div>
          
          <button>Submit</button>
      </form>
  </div>
</template>

<script>
export default {
    methods: {
        getbooks(){
document.getElementById('output').innerHTML="";
fetch("http://openlibrary.org/search.json?q="+document.getElementById("input").value)
.then(a => a.json()).then(resp => {
    for(var i=0;i<5;i++){
        document.getElementById("output").innerHTML+="<h2>"+resp.docs[i].title+"</h2>"+resp.docs[i].author_name[0]+"<br><img src='http://covers.openlibrary.org/b/isbn/"+resp.docs[i].isbn[0]+"-M.jpg'><br>";
    }
});
}
    }

}
</script>

<style scoped>
.bookSearch{
    text-align: center;
}
#output{
     background-color: rgb(245,245,220, .80);
}

</style>