<template>
  <div>
      <div class="loading" v-if="isLoading">
              <img src="/loadingGif.gif"/>
          </div>
      <table>
          <thead>
              <th>Family Name</th>
              <th>Books Read</th>
              <th>Pages Read</th>
              <th>Charity Money Earned</th>
          </thead>
          <tbody>
              <tr v-for="family in family" v-bind:key="family.familyId">
                  <td id="familyName">{{ family.familyName }}</td>
                  <td id="books">{{family.booksCompleted}}</td>
                  <td id="pages">{{family.pagesRead}}</td>
                  <td id="money">$ {{family.moneyEarned}}</td>
                </tr>
          </tbody>
      </table>
      <div id="options">
          <router-link v-bind:to="{ name: 'newAccount' }"><button id="new">Create New Family Account</button></router-link>
        <router-link v-bind:to="{name: 'addUser'}"><button id="update">Add User to Family Account</button></router-link>
      </div>
  </div>
</template>

<script>
import databaseService from '../services/DatabaseService'

export default {
    data() {
        return {
            family: [],
            isLoading: ''
        };
    },
    created() {
        this.isLoading = true;
        databaseService.getFamily(this.$store.state.user.id).then( response => {
            this.family = response.data;
            this.isLoading = false;
            this.$store.commit('SET_FAMILY_STATS', response.data)
        });
    }
};
</script>

<style scoped>
#options{
    display: flex;
    flex-direction: row;
    /* margin-left: 75px; */
    justify-content: center;

}
#new{
    padding: 10px;
}
div{
    display: flex;
    flex-direction: column;
    align-content: stretch;
    width: 100vh;
    /* height: 100vh; */
}
table{
    display: flex;
    flex-grow: 1;
    width: 100%;
    justify-content: space-between;
    align-content: space-between;
    margin: 0px

    /* margin-right: 95px */
    /* display: flex;
    flex-direction: column;
    align-content: center;
    align-self: center;
    height: 30%; */
    /* width: 100vh; */
    /* font-size: 20px; */

}

tr{
    /* border: 4px solid rgb(255,196,12) */
/* display: flex;
width: 100vh;
justify-content: space-between; */

/* height: 100vh; */

}
table, td {
  border: 2px solid rgb(255,196,12);
}
th{
    margin-left: 0;
}
thead{
    width: 100vh;
    justify-content: space-between;
    align-content: space-between;
}
td{
    width: 100vh;
    justify-content: space-between;
    align-content: space-between;
}
/* th{
    border: 4px solid rgb(255,196,12)
    /* padding: 20px; 
} 
td{
    border: 4px solid rgb(255,196,12)
    /* display: flex; */
    /* padding: 20px; */


#familyName{
    /* margin-left: 10px */
}
/* #pages{
    padding-right: 140px
} */
#money{

}
#familyName{
    font-family: 'abeatbyKai', sans-serif;
}
img{
    margin-right: 250px
}
#update{
    padding: 10px
}




</style>