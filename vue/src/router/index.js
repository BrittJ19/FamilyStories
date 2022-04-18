import Vue from 'vue'
import Router from 'vue-router'
// import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Family from '../views/Family.vue'
import FamilyAccounts from '../views/FamilyAccounts.vue'
import AboutUs from '../views/AboutUs'
import Charities from '../views/Charities'
import Profile from '../views/Profile'
import Troubleshoot from '../views/Troubleshoot'
import FamilyAccountList from '../components/FamilyAccountList.vue'
import loading from '../components/loading.vue'
import addUser from '../components/AddUser'
import FindFriendsForm from '../views/Friends'
import CheckActivity from '../views/CheckActivity.vue'
import createAccount from '../views/CreateAccount.vue'
import BookSlider from '../components/BookSlider.vue'
import RecordReadingActivity from '../views/RecordReadingActivity.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Login,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/family",
      name: "family",
      component: Family
    },
    {
      path:"/family/newAccount",
      name: "newAccount",
      component: FamilyAccounts
    },
    {
      path:"/aboutus",
      name: "aboutUs",
      component: AboutUs
    },
    {
      path:"/charities",
      name:"charities",
      component: Charities
    },
    {
      path:"/profile",
      name:"userProfile",
      component: Profile
    },
    {
      path:"/troubleshoot",
      name:"troubleshoot",
      component: Troubleshoot
    },
    {

      path:"/familyAccountList",
      name:"familyAccountList",
      component: FamilyAccountList
    },
    {
      path:"/loading",
      name: "loading",
      component: loading
    },
    {
      path:"/family/addUser",
      name: "addUser",
      component: addUser
    },
    {
      path:"/friends",
      name:"friends",
      component: FindFriendsForm
    },
    { 
      path:"/checkactivity",
      name:"checkactivity",
      component: CheckActivity
    },
    {
      path:"/account/create",
      name: "createAccount",
      component: createAccount
    },
    {
    path:"/books/favorites",
    name: "favoriteBooks",
    component: BookSlider
    },
    {
    path:"/reading/record",
    name:"readingRecord",
    component: RecordReadingActivity
    }

  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
