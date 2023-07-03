<template>
  <table class="table table-striped" v-for="event in content" v-bind:key="event.id">
    <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">What is the event about</th>
      <th scope="col">Start date&time</th>
      <th scope="col">End date&time</th>
      <th scope="col">City</th>
      <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">{{ event.name }}</th>
      <td>{{ event.description }}</td>
      <td>{{ event.startDateTime }}</td>
      <td>{{ event.endDateTime }}</td>
      <td>{{ event.city }}</td>
      <td>
        <button type="button" class="btn btn-danger">Delete</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import EventService from '@/services/event-service'
export default {
  name: 'MyAccount',
  components: {},
  data () {
    return {
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
          this.content = response.data()
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
.table-striped {
  position: relative;
  top: 150px;
  left: 80px;
  width: 90%;
}
</style>
