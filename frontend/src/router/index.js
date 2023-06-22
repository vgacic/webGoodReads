import { createRouter, createWebHashHistory } from 'vue-router'
import HomeAdministratorView from '../views/HomeAdministratorView.vue'
import HomeAutorView from '../views/HomeAutorView.vue'
import HomeNeprijavljeniKorisnikView from '../views/HomeNeprijavljeniKorisnikView.vue'
import Login from '@/components/Login'
import Logout from '@/components/Logout'
import Register from '@/components/Register'
import HomePage from '../views/HomePage.vue'
import LoggedIn from '../views/LoggedIn.vue'



const routes = [
  {
    path: '/',
    name: 'home',
    component: HomePage
    
  },
  {
    path: '/profil',
    name:'profil',
    component: LoggedIn
    
  },
  {
    path: '/login',
    name:'login',
    component: Login
    
  },
  {
    path:'/logout',
    name:'logout',
    component: Logout,
    meta: {
      title: 'logout'
    }
  },
  {
    path:'/register',
    name:'register',
    component: Register,
    meta: {
      title: 'register'
    }
  },
  {
    path:'/HomeAutor',
    name: 'HomeAutor',
    component:HomeAutorView,
    meta:{
      title:'HomeAutor'
    }
  },

  {
    path:'/HomeAdministrator',
    name: 'HomeAdministrator',
    component:HomeAdministratorView,
    meta:{
      title:'HomeAdministrator'
    }
  }


];

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router