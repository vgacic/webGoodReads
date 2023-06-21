import { createRouter, createWebHashHistory } from 'vue-router'
import HomeAdministratorView from '../views/HomeAdministratorView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeAdministratorView,
    meta: {
      title: 'home'
    }
  },
  {
    path: '/login',
    component: Login
  },
  {
    path:'/logout',
    component: Logout
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
