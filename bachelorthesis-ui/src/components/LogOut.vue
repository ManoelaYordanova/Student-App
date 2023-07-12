<template>
<p></p>
</template>

<script>

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
      localStorage.removeItem('access_token')
      localStorage.removeItem('refresh_token')
      this.$store.commit('setIsUserLoggedIn', false)
      this.$router.push({ name: 'home' })
    }
  }
}
</script>

<style scoped>

</style>
