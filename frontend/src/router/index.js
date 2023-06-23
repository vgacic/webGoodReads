import { createRouter, createWebHashHistory } from 'vue-router';
import HomeAdministratorView from '../views/HomeAdministratorView.vue';
import HomeAutorView from '../views/HomeAutorView.vue';
import Login from '@/components/Login.vue';
import Register from '@/components/Register.vue';
import HomePage from '../views/HomePage.vue';
import LoggedIn from '../views/LoggedIn.vue';
import Logout from '@/components/Logout.vue';
import HomeCitalacView from '../views/HomeCitalacView.vue';
import PretraziKnjiguPoNaslovu from '../views/PretraziKnjiguPoNaslovu.vue';
import PretraziKorisnikaPoId from '../views/PretraziKorisnikaPoId.vue';
import DodajKnjige from '../views/DodajKnjige.vue';



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
    path:'/homeAutor',
    name: 'HomeAutor',
    component:HomeAutorView,
    meta:{
      title:'HomeAutor'
    }
  },

  {
    path:'/homeAdministrator',
    name: 'HomeAdministrator',
    component:HomeAdministratorView,
    meta:{
      title:'HomeAdministrator'
    }
  },
  {
    path:'/homeCitalac',
    name: 'HomeCitalacView',
    component:HomeCitalacView,
    meta:{
      title:'HomeCitalacView'
    }
  },
  {
    path:'/search',
    name:'/PretragaKnjige',
    component:PretraziKnjiguPoNaslovu
  },
  {
    path:'/search1',
    name:'/PretragaKorisnikaPoId',
    component:PretraziKorisnikaPoId
  },
  {
    path:'/dodajKnjigu',
    name:'DodajKnjigu',
    component:DodajKnjige
  },


];

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router