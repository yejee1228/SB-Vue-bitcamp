import Vue from 'vue'
import App from './App.vue'
import vueRouter from 'vue-router'
import axios from 'axios'
import vuex from 'vuex'
import vuexEs6 from 'es6-promise'
import router from './router'
import {store} from './store'

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
  vueRouter,
  vuex,
  vuexEs6,
  router,
  store
}).$mount('#app')

