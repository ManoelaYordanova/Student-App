<template>
  <body>
  <div class="container" @submit.prevent="loggedUser">
    <form>
      <h1>Describe and share your event</h1>
      <div class="grid-date-time">
          <input placeholder="Event's name" type="text" id="name" required v-model="eventRequest.name">
          <input placeholder="City" type="text" id="name" required v-model="eventRequest.city">
          <input type="datetime-local" min="2023-04-28" max="2023-12-31" required v-model="eventRequest.startDateTime">
          <input type="datetime-local" id="endDate" min="2023-04-28" max="2023-12-31" required v-model="eventRequest.endDateTime">
      </div>
      <textarea placeholder="Event description" rows="5" cols="33" v-model="eventRequest.description"></textarea>
      <button id="button" class="button" type="submit" v-on:click="addEvent">Add</button>
    </form>
  </div>
  </body>
</template>

<script>
import EventService from '@/services/event-service'
export default {
  name: 'AddEvent',
  components: {
  },
  data () {
    return {
      eventRequest: {
        name: '',
        city: '',
        startDateTime: '',
        endDateTime: '',
        description: ''
      }
    }
  },
  mounted () {
  },
  methods: {
    addEvent () {
      EventService.addEvent(this.eventRequest).then(
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
  position: relative;
  top: 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: url("../assets/water3.jpg");
  background-size: cover;
  background-position: center;
}

.container form {
  position: relative;
  top: 50px;
  left: 220px;
  width: 830px;
  height: 550px;
  display: flex;
  justify-content: center;
  box-shadow: 20px 20px 50px rgba(0, 0, 0, 0.5);
  border-radius: 15px;
  background: rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(10px);
  flex-wrap: wrap;
  padding: 10px 20px 10px 20px;
}

.container form h1 {
  color: #111111;
  text-shadow: #BBB3AC 3px 3px;
  font-weight: 500;
  margin-top: 10px;
  margin-left: 20px;
  height: 50px;
  width: 500px;
  text-align: center;
}

.container form input {
  width: 290px;
  height: 40px;
  padding-left: 10px;
  outline: none;
  border: none;
  font-size: 15px;
  margin-bottom: 10px;
  background: none;
  border-bottom: 2px solid #111111;
}

.container form input::placeholder {
  color: #111111;
  font-size: 18px;
}

.grid-date-time {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}

.container form #endDate, #endTime, #choose, #button {
  margin-left: 20px;
}

.container form textarea {
  background: none;
  border: none;
  border-bottom: 2px solid #111111;
  color: #111111;
  font-weight: 200;
  font-size: 15px;
  padding: 10px;
  outline: none;
  min-width: 600px;
  max-width: 600px;
  min-height: 80px;
  max-height: 80px;
}
textarea::-webkit-scrollbar-track {
  width: 1em;
}
textarea::-webkit-scrollbar-thumb {
  background-color: rgba(194,194,194,0.713);
}
.button {
  position: relative;
  bottom: 10px;
  right: 10px;
  height: 40px;
  width: 600px;
  border: 2px solid #111111;
  border-radius: 20px;
  background: #BBB3AC;
  font-size: 18px;
  color: #111111;
}
.button:hover {
  background: #8c776b;
  color: #fff;
}
#choose {
}
</style>
