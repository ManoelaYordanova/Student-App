import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import * as axios from 'axios'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all'

createApp(App).use(store).use(axios).use(router).mount('#app')
