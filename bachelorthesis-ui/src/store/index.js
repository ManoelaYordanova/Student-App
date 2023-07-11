import { createStore } from 'vuex'

export default createStore({
  state: {
    isUserLoggedIn: !!localStorage.getItem('access_token')
  },
  getters: {
  },
  mutations: {
    setIsUserLoggedIn (state, value) {
      state.isUserLoggedIn = value
    }
  },
  actions: {
  },
  modules: {
  }
})
