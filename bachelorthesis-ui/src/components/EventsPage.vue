<template>
  <body>
  <div class="box">
    <form>
      <i class="fa-solid fa-magnifying-glass" id="icon"></i>
      <input class="search" type="text" v-model="searchEvent">
      <button v-on:click="loadAllEvents">Search</button>
    </form>
  </div>
  <div class="container">
    <div class="card" v-for="event in content" v-bind:key="event.id">
      <div class="card-text">
        <h2 class="name">{{ event.name }}</h2>
        <h2 class="city">Location: {{ event.city }}</h2>
        <p>{{ event.description }}</p>
      </div>
      <div class="card-stats">
        <div class="stat">
          <h1>{{ event.startDateTime }}</h1>
        </div>
        <div class="stat border">
          <h1>{{ event.endDateTime }}</h1>
        </div>
      </div>
    </div>
  </div>
  <nav aria-label="Page navigation example">
    <ul class="pagination">
      <li class="page-item"><a class="page-link" v-on:click="loadPrevious">Previous</a></li>
      <template v-for="item in totalPages" v-bind:key="item">
        <li class="page-item"><a class="page-link" v-on:click="loadPage(item)">{{item}}</a></li>
      </template>
      <li class="page-item"><a class="page-link" v-on:click="loadNext">Next</a></li>
    </ul>
  </nav>
  </body>
</template>

<script>
import EventService from '@/services/event-service'

export default {
  name: 'EventsPage',
  components: {},
  data () {
    return {
      searchEvent: '',
      content: [],
      currentPage: 1,
      perPage: 6,
      totalItems: 0,
      totalPages: 0
    }
  },
  mounted () {
    this.loadAllEvents()
  },
  methods: {
    loadAllEvents () {
      EventService.getEventsPage(this.currentPage, this.perPage, this.searchEvent).then(
        response => {
          console.log(response)
          this.content = response.data.events
          this.totalItems = response.data.totalItems
          this.totalPages = response.data.totalPages
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        }
      )
    },
    loadPrevious () {
      if (this.currentPage !== 1) {
        this.currentPage -= 1
        this.loadAllEvents()
      }
    },
    loadPage (page) {
      this.currentPage = page
      this.loadAllEvents()
    },
    loadNext () {
      if (this.totalPages > this.currentPage) {
        this.currentPage += 1
        this.loadAllEvents()
      }
    },
    pageEvents () {
      EventService.getEventsPage().then(
        response => {
          console.log(response)
          this.content = response.data
        },
        error => {
          this.content =
            (
              error.response && error.response.data) ||
              error.message ||
              error.toString()
        }
      )
    },
    loadSearchedEventByName (name) {
      EventService.getSearchedEventByName().then(
        response => {
          console.log(response)
          this.searchedEvents = response.data
        },
        error => {
          this.searchedEvents =
            (
              error.response && error.response.data) ||
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
  justify-content: center;
  align-items: center;
  min-height: 1200px;
  background: url("../assets/water.jpg");
  background-size: cover;
  background-position: center;
}

.container {
  position: relative;
  top: 140px;
  width: 100%;
  height: 1000px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
  align-items: flex-start;
  gap: 20px 10px;
  padding: 40px;
}

.card {
  display: grid;
  grid-template-columns: 400px;
  grid-template-rows: 330px 70px;
  grid-template-areas: "text" "stats";

  border-radius: 18px;
  background: #74bbcc;
  box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.9);
  text-align: center;
  transition: 0.5s ease;
}

.card-text {
  grid-area: text;
  margin: 15px;
}

.card-text .name {
  font-size: 22px;
  font-weight: 600;
}

.card-text .city {
  padding: 15px;
  font-size: 18px;
}

.card-text p {
  color: white;
  font-size: 18px;
  font-weight: 300;
  padding: 2px;
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

.card-stats .stat {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 5px;
  color: #fff;
}

.card-stats .border {
  border-left: 1px solid #fff;
}

.card-stats h1 {
  font-size: 16px;
  color: #fff;
  padding: 10px;
}
.pagination {
  width: 400px;
  position: relative;
  top: 95px;
  left: 630px;
}
.pagination:hover {
  cursor: pointer;
}
.box {
  position: relative;
  top: 140px;
  left: 550px;
  width: 600px;
}
form {
  background: #fff;
  width: 500px;
  height: 30px;
  display: flex;
}
form input {
  flex: 1;
  border: none;
  outline: none;
}
form button {
  background: #74bbcc;
  padding: 0px 50px;
  border: none;
  outline: none;
  color: #fff;
  letter-spacing: 1px;
  cursor: pointer;
  font-size: 18px;
}
form button:hover {
  box-shadow: 10px 5px 5px #111111;
}
form #icon{
  align-self: center;
  padding: 10px 20px;
  color: #777;
}
.searchedEvent {
  position: relative;
  top: 30px;
}
</style>
