<template>
  <body>
  <header>
    <h2 class="logo">Student Events</h2>
    <nav class="navigation">
      <a href="#">Home</a>
      <a href="#">Events</a>
      <a href="#">About</a>
      <button class="btnLogin-popup">Login</button>
    </nav>
  </header>

  <video autoplay loop muted playsinline class="back-video">
    <source src="../assets/video.mp4" type="video/mp4">
  </video>

  <div class="text">
    <h1>ENJOY YOUR YOUTH</h1>
  </div>

  <div class="wrapper">
    <span class="icon-close">
      <i class="fa-solid fa-xmark"></i>
    </span>

    <div class="form-box login">
      <h2>Login</h2>
      <form action="#">
        <div class="input-box">
          <span class="icon">
            <i class="fa-solid fa-envelope"></i>
          </span>
          <input type="email" required>
          <label>Email</label>
        </div>

        <div class="input-box">
          <span class="icon">
            <i class="fa-solid fa-lock"></i>
          </span>
          <input type="password" required>
          <label>Password</label>
        </div>

        <div class="remember-forgot">
          <label><input type="checkbox">
            Remember me</label>
          <a href="#">Forgot Password?</a>
        </div>

        <button type="submit" class="btn">Login</button>

        <div class="login-register">
          <p>Don`t have an account? <a href="#" class="register-link"
          >Register</a></p>
        </div>

      </form>
    </div>

    <div class="form-box register">
      <h2>Registration</h2>
      <form action="#">
        <div class="input-box">
          <span class="icon">
            <i class="fa-solid fa-user"></i>
          </span>
          <input type="text" required v-model="request.firstname">
          <label>First Name</label>
        </div>

        <div class="input-box">
          <span class="icon">
            <i class="fa-solid fa-user"></i>
          </span>
          <input type="text" required v-model="request.lastname">
          <label>Last Name</label>
        </div>

        <div class="input-box">
          <span class="icon">
            <i class="fa-solid fa-envelope"></i>
          </span>
          <input type="email" required v-model="request.email">
          <label>Email</label>
        </div>

        <div class="input-box">
          <span class="icon">
            <i class="fa-solid fa-lock"></i>
          </span>
          <input type="password" required v-model="request.password">
          <label>Password</label>
        </div>

        <div class="remember-forgot">
          <label><input type="checkbox">
            I agree to the terms & conditions</label>
        </div>

        <button type="submit" class="btn" v-on:click="register">Register</button>

        <div class="login-register">
          <p>Already have an account? <a href="#" class="login-link"
          >Login</a></p>
        </div>
      </form>
    </div>

  </div>

  </body>
</template>

<script>
import UserService from '../services/user-service.js'
// @ is an alias to /src
export default {
  name: 'HomeView',
  components: {
  },
  data () {
    return {
      request: {
        firstname: '',
        lastname: '',
        email: '',
        password: ''
      }
    }
  },
  mounted () {
    const wrapper = document.querySelector('.wrapper')
    const loginLink = document.querySelector('.login-link')
    const registerLink = document.querySelector('.register-link')
    const btnPopup = document.querySelector('.btnLogin-popup')
    const iconClose = document.querySelector('.icon-close')

    console.log(registerLink)
    if (registerLink) {
      registerLink.addEventListener('click', () => {
        wrapper.classList.add('active')
      })
    }

    console.log(loginLink)
    if (loginLink) {
      loginLink.addEventListener('click', () => {
        wrapper.classList.remove('active')
      })
    }

    console.log(btnPopup)
    if (btnPopup) {
      btnPopup.addEventListener('click', () => {
        wrapper.classList.add('active-popup')
      })
    }

    console.log(iconClose)
    if (iconClose) {
      iconClose.addEventListener('click', () => {
        wrapper.classList.remove('active-popup')
      })
    }
  },
  methods: {
    register () {
      UserService.registerUser(this.request).then(
        response => {
          this.message = response.data.message
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

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}
.back-video {
  position: absolute;
  right: 0;
  bottom: 0;
  z-index: 0;
}

@media (min-aspect-ratio: 16/9) {
  .back-video {
    width: 100%;
    height: auto;
  }
}

@media (max-aspect-ratio: 16/9) {
  .back-video {
    width: auto;
    height: 100%;
  }
}

header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  padding: 20px 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 99;
  background: rgba(0,0,0,0.2);
}

.logo {
  font-size: 2.5em;
  color: white;
  user-select: none;
}

.navigation a {
  position: relative;
  font-size: 1.5em;
  color: white;
  text-decoration: none;
  font-weight: 500;
  margin-left: 40px;
}

.navigation a::after {
  content: '';
  position: absolute;
  left: 0;
  bottom: -6px;
  width: 100%;
  height: 3px;
  background: #fff;
  border-radius: 5px;
  transform-origin: right;
  transform: scaleX(0);
  transition: transform .5s;
}

.navigation a:hover::after {
  transform-origin: left;
  transform: scaleX(1);
}

.navigation .btnLogin-popup {
  width: 130px;
  height: 50px;
  background: transparent;
  border: 2px solid #fff;
  outline: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 1.3em;
  color: #fff;
  font-weight: 500;
  margin-left: 40px;
  transition: .5s;
}

.navigation .btnLogin-popup:hover {
  background: #fff;
  color: #162938;
}

.wrapper {
  position: relative;
  top: 30px;
  right: -100px;
  width: 400px;
  height: 440px;
  background: transparent;
  border: 2px solid rgba(255, 255, 255, .5);
  border-radius: 20px;
  backdrop-filter: blur(20px);
  box-shadow: 0 0 30px rgba(0, 0, 0, .5);
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  transform: scale(0);
  transition: transform .5s ease, height .2s ease;
}

.wrapper.active-popup {
  transform: scale(1);
}

.wrapper.active {
  height: 550px;
}

.wrapper .form-box {
  width: 100%;
  padding: 40px;
}

.wrapper .form-box.login {
  transition: transform .18s ease;
  transform: translateX(0);
}

.wrapper.active .form-box.login {
  transition: none;
  transform: translateX(-400px);
}

.wrapper .form-box.register {
  position: absolute;
  transition: none;
  transform: translateX(400px);
}

.wrapper.active .form-box.register {
  transition: transform .18s ease;
  transform: translateX(0);
}

.wrapper .icon-close {
  position: absolute;
  top: 0;
  right: 0;
  width: 45px;
  height: 45px;
  background: #162938;
  font-size: 2em;
  color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom-left-radius: 20px;
  cursor: pointer;
  z-index: 1;
}

.form-box h2 {
  font-size: 2.5em;
  color: #fff;
  text-shadow: #5d959c 3px 3px;
  text-align: center;
}

.input-box {
  position: relative;
  width: 100%;
  height: 50px;
  border-bottom: 2px solid #162938;
  margin: 30px 0;
}

.input-box label {
  position: absolute;
  top: 50%;
  left: 5px;
  transform: translateY(-50%);
  font-size: 1.3em;
  color: #fff;
  font-weight: 500;
  pointer-events: none;
  transition: .5s;
}

.input-box input:focus ~ label,
.input-box input:valid ~ label {
  top: -5px;
}

.input-box input {
  width: 100%;
  height: 100%;
  background: transparent;
  border: none;
  outline: none;
  font-size: 1.2em;
  color: #fff;
  font-weight: 200;
  font-style: italic;
  padding: 0 35px 0 5px;
}

.input-box .icon {
  position: absolute;
  right: 8px;
  font-size: 1.2em;
  color: #fff;
  line-height: 57px;
}

.remember-forgot {
  font-size: 1em;
  color: #fff;
  font-weight: 500;
  margin: -15px 0 15px;
  display: flex;
  justify-content: space-between;
}

.remember-forgot label input {
  accent-color: #162938;
  margin-right: 3px;
}

.remember-forgot a {
  color: #fff;
  text-decoration: none;
}

.remember-forgot a:hover {
  text-decoration: underline;
}

.btn {
  width: 100%;
  height: 45px;
  background: #162938;
  border: none;
  outline: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 1.2em;
  color: #fff;
  font-weight: 500;
}

.btn:hover {
  color: #5d959c;
}

.login-register {
  font-size: 1em;
  color: #fff;
  text-align: center;
  font-weight: 500;
  margin: 25px 0 10px;
}

.login-register p a {
  color: #fff;
  text-decoration: none;
  font-weight: 600;
}

.login-register p a:hover {
  text-decoration: underline;
}

.text h1{
  color: white;
  text-shadow: #2c3e50 2px 5px;
  position: relative;
  top: 250px;
  right: 170px;
  font-size: 60px;
  font-style: italic;
}
</style>
