<template>
<p></p>
</template>

<script>
import UserService from '@/services/user-service'

export default {
  name: 'LogOut.vue',
  components: {
  },
  data () {
  },
  mounted () {
    this.logout()
  },
  methods: {
    logout () {
      UserService.logout().then(
        response => {
          localStorage.removeItem('access_token', response.data.access_token)
          localStorage.removeItem('refresh_token', response.data.refresh_token)
          this.$store.commit('setIsUserLoggedIn', false)
          this.$router.push({ name: 'home' })
        }
      )
    }
  }
}
</script>

<style scoped>

</style>
