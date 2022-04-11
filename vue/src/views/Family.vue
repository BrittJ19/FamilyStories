<template>
  <div class ="family">
      <p>
          <router-link v-bind:to="{ name: 'parentAccount' }">Add a Parent Account</router-link>&nbsp;|&nbsp;
          <router-link v-bind:to="{name: 'childAccount' }"> Add a Child Account</router-link>
      </p>
      </div>
</template>

<script>
export default {

}
</script>

<style>

</style>