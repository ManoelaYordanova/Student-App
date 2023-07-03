import axios from '../axios'

const API_URL = 'http://localhost:8080/event'

class EventService {
  addEvent (eventRequest) {
    const accessToken = localStorage.getItem('access_token')

    console.log(eventRequest)
    return axios.post(API_URL + '/create',
      {
        name: eventRequest.name,
        city: eventRequest.city,
        startDateTime: eventRequest.startDateTime,
        endDateTime: eventRequest.endDateTime,
        description: eventRequest.description
      },
      {
        headers: {
          Authorization: `Bearer ${accessToken}`
        }
      })
  }

  getAllEvents () {
    return axios.get(API_URL + '/myEvents')
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
