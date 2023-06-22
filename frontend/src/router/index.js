import { createRouter, createWebHashHistory } from 'vue-router';
import HomeAdministratorView from '../views/HomeAdministratorView.vue';
import HomeAutorView from '../views/HomeAutorView.vue';
import Login from '@/components/Login';
import Register from '@/components/Register';
import HomePage from '../views/HomePage.vue';
import LoggedIn from '../views/LoggedIn.vue';
import Logout from '@/components/Logout.vue';
import HomeCitalacView from '../views/HomeCitalacView.vue';





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
    component:HomeAdministratorView,
    meta:{
      title:'HomeCitalacView'
    }
  }


];

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router