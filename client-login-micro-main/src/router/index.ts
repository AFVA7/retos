import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
   {
    path: '/',
    name: 'Login',
    component: LoginView
   },
   {
    path: '/welcome',
    name: 'Welcome',
    component: () => import('../views/GreetingView.vue')
   }
  ]
})

export default router
