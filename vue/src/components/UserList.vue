<template>
    <div>
        <label for="serch-term">Search: </label>
        <input type="text" id="serch-term" v-model="searchTerm" @keyup="updateSearch"/>
    </div>
</template>

<script> 

// import databaseService from '@/services/DatabaseService'

export default {
    name: 'user-search',
    data() {
        return {
            searchTerm: ''
        }
    },
    methods: {
        updateSearchFilter() {
            this.$store.commit('UPDATE_SEARCH', this.searchTerm);
        }
    }

    // name: 'user-list',
    // created() {
    //     databaseService.getUsers().then( response => {
    //         this.$store.commit('USER_LIST', response.data);
    //     })
    // },
    // computed: {
    //     filteredUsers() {
    //         const searchedUser = this.$store.users.find(
    //             user => user.username == this.$store.state.searchedUser
    //         );

    //         return searchedUser;

    //     }
    // }

    }
</script>


<style scoped>
    label {
        display: inline;
    }

    #serch-term {
        width: 70%;
    }
</style>