<template>
  <body>
  <div class="container">
    <div class="card" v-for="event in content" v-bind:key="event.id">
      <div class="card-text">
        <h2>{{event.name}}</h2>
        <p>{{event.description}}</p>
      </div>
      <div class="card-stats">
          <h1>{{event.startDate}}</h1>
          <h1>{{event.endDate}}</h1>
          <h1>{{event.startTime}}</h1>
          <h1>{{event.endTime}}</h1>
    </div>
    </div>
  </div>
  </body>
</template>

<script>
import EventService from '@/services/event-service'
export default {
  name: 'EventsPage',
  components: {
  },
  data () {
    return {
      content: []
    }
  },
  mounted () {
    this.loadAllEvents()
  },
  methods: {
    loadAllEvents () {
      EventService.getAllEvents().then(
        response => {
          console.log(response)
          this.content = response.data
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
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
  background: url("../assets/water.jpg");
  background-size: cover;
  background-position: center;
}
.container {
  position: relative;
  top: 120px;
  width: 100%;
  height: 1000px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
  align-items: flex-start;
  gap: 20px 10px;
  padding: 40px;
  background: #42b983;
}
.card {
  display: grid;
  grid-template-columns: 400px;
  grid-template-rows: 310px 80px;
  grid-template-areas: "text" "stats";

  border-radius: 18px;
  background: #f68871;
  box-shadow: 5px 5px 15px rgba(0,0,0,0.9);
  text-align: center;
  transition: 0.5s ease;
}
.card-text {
  grid-area: text;
  margin: 15px;
}
.card-text p {
  color: #5d959c;
  font-size: 18px;
  font-weight: 300;
  padding: 25px;
}
.card-text h2 {
  margin-top: 0px;
  font-size: 26px;
  font-weight: 600;
}
.card-stats {
  grid-area: stats;
  background-color: #111111;
  border-bottom-left-radius: 15px;
  border-bottom-right-radius: 15px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
}
.card-stats h1 {
  font-size: 14px;
  color: #fff;
  padding: 10px;
}
</style>
