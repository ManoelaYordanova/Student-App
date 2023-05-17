import axios from 'axios'

const API_URL = 'http://localhost:8080/event'

class EventService {
  addEvent (eventRequest) {
    console.log(eventRequest)
    return axios.post(API_URL + '/create',
      {
        name: eventRequest.name,
        city: eventRequest.city,
        startDateTime: eventRequest.startDateTime,
        endDateTime: eventRequest.endDateTime,
        description: eventRequest.description
      })
  }

  getAllEvents () {
    return axios.get(API_URL + '/load')
  }

  getEventsPage (currentPage, perPage) {
    return axios.get(API_URL + '/page',
      {
        params:
          {
            currentPage: currentPage,
            perPage: perPage
          }
      })
  }
}

export default new EventService()
