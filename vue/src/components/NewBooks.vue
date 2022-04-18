<template>
  <div class='newBooks'>
      <h2>
          {{newBooks.books}}
      </h2>
  </div>
</template>

<script>
export default {
    props: {
        newBooks: Object
    }

}
</script>

<style Scoped>
.newBooks {
    background: #fff;
    padding: 1.5em;
}
.newBooks:not(:last-child) {
    border-bottom: 1px solid #ddd;
}
.newBooks h2 {
    font-size: 1.3em;
    padding-bottom: 0.25rem;
}

</style>