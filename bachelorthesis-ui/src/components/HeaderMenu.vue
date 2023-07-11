<template>
  <header>
    <h2 class="logo">Student Events</h2>
    <nav class="navigation">
      <router-link to="/"><h1>Home</h1></router-link>
      <router-link to="/eventsPage"><h1>Events</h1></router-link>
      <router-link to="/about"><h1>About</h1></router-link>
      <router-link v-if="authenticatedUser()" to="/addEvent"><h1>Add Event</h1></router-link>
      <router-link v-if="!authenticatedUser()" to="/signUp"><h1>| Sign up</h1></router-link>
      <router-link v-if="!authenticatedUser()" to="/login"><h1>Log in</h1></router-link>
      <router-link v-if="authenticatedUser()" to="/myAccount"><h1>My Account</h1></router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'HeaderMenu',
  methods: {
    authenticatedUser () {
      return this.$store.state.isUserLoggedIn
    }
  }
}
</script>

<style scoped>
header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 15%;
  padding: 20px 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 99;
  background: rgba(0, 0, 0, 0.4);
}

.logo {
  position: relative;
  left: -50px;
  font-size: 2.8em;
  color: white;
  user-select: none;
}

.navigation h1 {
  display: inline-block;
  font-size: 1.7em;
  color: white;
  text-decoration: none;
  font-weight: 500;
  margin-left: 40px;
  padding-left: 30px;
}

.navigation h1:hover {
  color: #cde0ec;
}

.navigation .btnLogin-popup {
  width: 130px;
  height: 50px;
  background: transparent;
  border: 2px solid #fff;
  outline: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 1.5em;
  color: #fff;
  font-weight: 500;
  margin-left: 100px;
  transition: .5s;
}

.navigation .btnLogin-popup:hover {
  background: #fff;
  color: #162938;
}
</style>
