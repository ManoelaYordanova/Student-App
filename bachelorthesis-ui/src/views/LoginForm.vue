<template>
  <body>
  <section>
    <div class="form-box">
      <div class="form-value">
        <form action="">
          <h2>Login</h2>
          <div class="inputbox">
              <span class="icon">
              <i class="fa-solid fa-envelope"></i>
              </span>
            <input type="email" required v-model="request.email">
            <label for="">Email</label>
          </div>
          <div class="inputbox">
              <span class="icon">
              <i class="fa-solid fa-lock"></i>
              </span>
            <input type="password" required v-model="request.password">
            <label for="">Password</label>
          </div>

          <div class="forget">
            <label for=""><input type="checkbox">Remember me  <a href="#">Forget Password</a></label>
          </div>

          <button v-on:click="authenticate">Log in</button>

          <div class="register">
            <p>Don`t have an account <router-link to="/signUp">Register</router-link></p>
          </div>
        </form>
      </div>
    </div>
  </section>
  </body>
</template>

<script>
import UserService from '@/services/user-service'
export default {
  name: 'LoginForm',
  components: {
  },
  data () {
    return {
      request: {
        email: '',
        password: ''
      }
    }
  },
  mounted () {
  },
  methods: {
    authenticate () {
      UserService.authenticateUser(this.request).then(
        response => {
          localStorage.setItem('access_token', response.data.access_token)
          localStorage.setItem('refresh_token', response.data.refresh_token)
        }
      )
    }
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Book Antiqua";
  box-sizing: border-box;
}

section {
  position: relative;
  top: 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  width: 100%;
  background: url("../assets/water8.jpg")no-repeat;
  background-size: cover;
  background-position: center;
}

.form-box {
  position: relative;
  top: 50px;
  width: 400px;
  height: 450px;
  background: transparent;
  border: 2px solid rgba(255, 255, 255, 0.5);
  border-radius: 20px;
  backdrop-filter: blur(15px);
  display: flex;
  justify-content: center;
  align-items: center;
}

h2 {
  font-size: 2.2em;
  color: #fff;
  text-align: center;
}

.inputbox {
  position: relative;
  margin: 30px 0;
  width: 310px;
  border-bottom: 2px solid #fff;
}

.inputbox label {
  position: absolute;
  top: 50%;
  left: 5px;
  transform: translateY(-50%);
  color: #fff;
  font-size: 1.2em;
  pointer-events: none;
  transition: .5s;
}

input:focus ~ label,
input:valid ~ label {
  top: -5px;
}

.inputbox input {
  width: 100%;
  height: 50px;
  background: transparent;
  border: none;
  outline: none;
  font-size: 1.2em;
  padding: 0 35px 0 5px;
  color: #fff;
}

.inputbox .icon {
  position: absolute;
  right: 8px;
  color: #fff;
  font-size: 1.2em;
  top: 10px;
}
.forget {
  margin: -15px 0 15px;
  font-size: 1em;
  color: #fff;
  display: flex;
  justify-content: center;
}
.forget label input {
  margin-right: 3px;
}
.forget label a {
  color: #fff;
  margin-left: 20px;
  text-decoration: none;
}
.forget label a:hover {
  text-decoration: underline;
}
button {
  width: 100%;
  height: 50px;
  border-radius: 40px;
  background: #fff;
  border: none;
  outline: none;
  cursor: pointer;
  font-size: 1.2em;
  font-weight: 600;
}
button:hover {
  background: #BDB1A7;
  color: #fff;
}
.register {
  font-size: 1.2em;
  color: #fff;
  text-align: center;
  margin: 25px 0 10px;
}
.register p a {
  text-decoration: none;
  color: #fff;
  font-weight: 600;
  margin-left: 5px;
}
.register p a:hover {
  text-decoration: underline;
}
</style>
