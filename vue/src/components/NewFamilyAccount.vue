<template>
  <div>
      <h1>Create New Family Account</h1>
      <form>
          <div class="form-element">
              <label for="account-name"> Account Name:</label>
              <input id="meme-text" type="text" v-model="text1"/>
          </div>

          <div class="form-element">
              <label for="account-type"> Account Type:</label>
                  <select id="selections">
                      <option value="parent">Parent</option>
                      <option value="child">Child</option>
                  </select>
          </div>
          <div class="actions">
              <button type="submit">Submit</button>
          </div>
      </form>
  </div>
</template>

<script>
export default {
    name: "family-account",
    data() {
        return {
            familyAccount: {
                accountName: "",
                accountType: "",
                userId: this.$store.state.userId
            }
        }
    }

}
</script>

<style>

</style>