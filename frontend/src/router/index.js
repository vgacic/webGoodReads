import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '@/components/Login.vue';
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },

  {
    path: '/',
    name:'login',
    component: Login,
    meta:{
      title:'Login'}

  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
