<template>
  <div>
      <div>
              <nav>
        <img id="logo" src="/offWhiteLogo.png">  
        <img id="catchphrase" src="/logoText.png"> 
        <div id="innerNav">
        <div id="site-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home </router-link>
        <router-link id="about" v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        <router-link id="charities" v-bind:to="{name: 'charities'}"> Charities We Work With </router-link>
        <router-link id="logout" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">Logout</router-link>
        </div> 
 </div>
      </nav>
      <div id="mainD">
          <div id="header">
          <h1 id="pageTitle">Donate Prize Money</h1>
          </div>
          <form id="formD">
              <p id="chooseAccount">Choose an account</p>
              <select name="results" id="results" v-model="user" @change="onChange()">
                  <option disabled selected value>-- select an option --</option>
                <option :value ="user" v-for="user in availableAccounts" v-bind:key="user.id">{{user.username}}</option>
              </select>
              <div id="form-element" v-if="canRedeem === false">
                  <p>Sorry, you do not have any money to donate. Keep reading! Only</p>
                  <p id = "amount">  {{this.pagesToGo}} </p>
                  <p> pages until you have money to donate.</p>
              </div>
              <div id="choose">
                  <select id="selections" v-if="canRedeem">
                      <option disabled selected value>-- select a charity --</option>
                      <option value=True>Book Aid International</option>
                      <option value=False>World Literacy Foundation</option>
                       <option value=True>Literacy For Incarcerated Teens</option>
                      <option value=False>Reading Is Fundamental</option>
                      <option value=False>Room To Read</option>
                  </select>
              </div>
              <button id="redeem" class="btn btn-lg btn-primary btn-block" type="submit" v-if="canRedeem">
        Donate
      </button>
      <button @click="$router.go(-1)" id="redeem" type="button" >Back</button>
          </form>
      </div>
      </div>

  </div>
</template>

<script>
import databaseService from '../services/DatabaseService'
export default {
     name: "redeem",
    data() {
        return {
            familyAccounts: [],
            canRedeem: '',
            currUser: {},
            user: {},
            pagesRead: '',
            pagesToGo: 0,
            availableAccounts: [],
            familyMembers: [],
            account: [],
            allAccounts: [],
            inconsequential: '',
            childAccounts: [],
            unique: []
        }
    },
   created(){
            this.isLoading = true;
            // databaseService.getCurrentUser(this.$store.state.user.id).then( resp => {
            //     this.availableAccounts.push(resp.data)
            // })
        databaseService.getFamilyAccounts(this.$store.state.user.id).then(response => {
            this.familyAccounts = response.data;
            response.data.forEach( account => {
        databaseService.getUserByFamily(account.familyId).then( resp=> {
            this.familyMembers.push(resp.data)
            resp.data.forEach( user => {
                this.account.push(user.id)
            })
              this.account.forEach( resp => {
                databaseService.getCurrentUser(resp).then( response => {
                    this.allAccounts.push(response.data)
                    if(response.data.username == this.$store.state.user.username){
                    this.userData = response.data}
                    if(response.data.accountType == 'child'){
                         if(!this.availableAccounts.includes(response.data)){
                            this.availableAccounts.push(response.data)
                        }
                        const uniqueIds = [];
                        this.unique = this.availableAccounts.filter(el => {
                            const isDuplicate = uniqueIds.includes(el.id);

                            if(!isDuplicate) {
                                uniqueIds.push(el.id);
                                return true;
                            }
                        })
                    }
                })
            })
            databaseService.getCurrentUser(this.$store.state.user.id).then(response => {
                                this.availableAccounts.push(response.data)
                            })

           
        })
            
        })})

   },
   methods:{
       onChange() {
           if (this.user.pagesRead >= 500){
               this.canRedeem = true;
           }else {
               this.canRedeem = false;
           }

           this.pagesToGo = 500 - this.user.pagesRead
       }
   }

    }
</script>

<style>
#chooseAccount{
    padding-bottom: 20px;
    margin-left: 40px;
}
#mainD{
    display: flex;
    background-color: rgb(150,165,60);
    text-align: center;
    flex-direction: column;
    justify-content: center;
    padding: 40px;
    margin: 100px;
    border-radius: 5vh;
    margin-left: 200px;
    margin-right: 200px;
      -webkit-box-shadow: 10px 10px 10px 15px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    10px 10px 10px 15px rgba(50, 50, 50, 0.75);
    box-shadow:         10px 10px 10px 15px rgba(50, 50, 50, 0.75); 
}
#header{
    display: flex;
text-align: center;
}
p{
    color: rgb(245,245,220);
    margin: 10px;
}
h1{
    text-align: center;
    justify-content: center;
}
#formD{
    display: flex;
    flex-direction: column;
    background-color: rgb(255,117,24);
    padding: 100px;
    width: 80%; 
   align-self: center;
   border-radius: 5vh;
     -webkit-box-shadow: 10px 10px 10px 15px rgba(50, 50, 50, 0.75);
    -moz-box-shadow:    10px 10px 10px 15px rgba(50, 50, 50, 0.75);
    box-shadow:         10px 10px 10px 15px rgba(50, 50, 50, 0.75); 
}
p{
    padding-right: 20px;
}
#results{
    height: 30px;
    width: 215px;
    align-self: center;
    align-content: center;

}
#form-element{
    display: flex;
    flex-direction: column;
    padding: 5px
}
#choose{
    padding: 40px;
    align-self: center;
}
#selections{
    height: 30px;
}
#amount{
    font-weight: bold;
    font-size: 40px;
}
#redeem{
    background-color: darkolivegreen;
    border: 4px solid rgb(255,196,12);
    width: 215px;
    align-self: center;
    margin-right: 20px;
    
}
#redeem:hover{
    background-color: rgb(255,196,12);
    height: 50px;

}

</style>