<template>
  <body>
  <table class="table table-striped" v-for="event in content" v-bind:key="event.id">
    <thead>
    <tr>
      <th class="headers" scope="col" style="width:10%">Name</th>
      <th class="headers" scope="col" style="width:50%">What is the event about</th>
      <th class="headers" scope="col" style="width:10%">Start date&time</th>
      <th class="headers" scope="col" style="width:10%">End date&time</th>
      <th class="headers" scope="col" style="width:10%">City</th>
      <th class="headers" scope="col" style="width:10%">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td class="information">{{ event.name }}</td>
      <td class="information">{{ event.description }}</td>
      <td class="information">{{ event.startDateTime }}</td>
      <td class="information">{{ event.endDateTime }}</td>
      <td class="information">{{ event.city }}</td>
      <td>
        <button type="button" class="btn btn-danger" v-on:click="() => deleteEvent(event.id)">Delete</button>
      </td>
    </tr>
    </tbody>
  </table>
  </body>
</template>

<script>
import EventService from '@/services/event-service'
export default {
  name: 'MyAccount',
  components: {},
  data () {
    return {
      message: '',
      content: [{
        name: '',
        description: '',
        startDateTime: '',
        endDateTime: '',
        city: ''
      }]
    }
  },
  mounted () {
    this.loadAllEventsByUser()
  },
  methods: {
    loadAllEventsByUser () {
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
    },
    deleteEvent (id) {
      console.log(id)
      EventService.deleteEvent(id).then(
        response => {
          console.log(response)
          this.message = response.data
          this.loadAllEventsByUser()
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
body {
  position: relative;
  top: 0px;
  justify-content: center;
  align-items: center;
  min-height: 721px;
  background: url("../assets/myaccount.jpg");
  background-size: cover;
  background-position: center;
}
.table-striped {
  position: relative;
  top: 150px;
  left: 80px;
  width: 90%;
  font-family: "Book Antiqua";
}
.information {
  font-size: 16px;
  text-align: center;
}
.headers {
  font-size: 20px;
}
</style>
