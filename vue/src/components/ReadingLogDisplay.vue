<template>
  <div class = main>
      <div>
       <table>
          <thead>
              <th>Date</th>
              <th>Username</th>
              <th>Account Type</th>
              <th>Title</th>
              <th>Book Format</th>
              <th>Time</th>
              <th>Pages Read</th>
              <th>Book Finished</th>
              <th>Notes</th>
          </thead>
          <tbody>
              <tr v-for="log in logs" v-bind:key="log.recordId">
                  <td id="date">{{log.dateTime}}</td>
                  <td id="username">{{ log.username }}</td>
                  <td id="accountType">{{log.accountType}}</td>
                   <td id="title">{{log.bookTitle}}</td>
                   <td id="format">{{log.format}}</td>
                   <td id="time">{{log.timeReading}}</td>
                   <td id="pages">{{log.pagesRead}}</td>
                   <td id="finish">{{log.completed}}</td>
                   <td id="notes">{{log.notes}}</td>                 
                  <!-- <td id="books">{{family.booksCompleted}}</td>
                  <td id="pages">{{family.pagesRead}}</td>
                  <td id="money">$ {{family.moneyEarned}}</td> -->
                </tr>
          </tbody>
      </table>
  </div>
  </div>
</template>

<script>
import databaseService from '../services/DatabaseService'

export default {
    data() {
        return {
            logs: [],
            isLoading: ''
        };
    },
    created() {
        // this.isLoading = true;
        databaseService.getReadingLogs(this.$store.state.user.id).then( response => {
            this.logs = response.data;
            // this.isLoading = false;
        });
    }


}
</script>

<style scoped>
table{
  background-color: rgb(150,165,60); 
  font-family: 'abeatbyKai', sans-serif;
}
#time, #pages{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 20px;
}

</style>