import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddEvent from '@/components/AddEvent.vue'
import EventsPage from '@/components/EventsPage.vue'
import LoginForm from '@/views/LoginForm.vue'
import SignUp from '@/views/SignUp.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/addEvent',
    name: 'AddEvent',
    component: AddEvent
  },
  {
    path: '/eventsPage',
    name: 'EventsPage',
    component: EventsPage
  },
  {
    path: '/login',
    name: 'LoginForm',
    component: LoginForm
  },
  {
    path: '/signUp',
    name: 'SignUp',
    component: SignUp
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
