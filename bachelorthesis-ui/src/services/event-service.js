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

  getEventsPage (currentPage, perPage, name) {
    return axios.get(API_URL + '/search/event',
      {
        params:
          {
            currentPage: currentPage,
            perPage: perPage,
            name: name
          }
      })
  }

  getSearchedEventByName (name) {
    return axios.get(API_URL + '/search/event/name',
      {
        params:
          {
            name: name
          }
      })
  }

  deleteEvent (id) {
    return axios.delete(API_URL + '/myEvents/delete',
      {
        params:
          {
            id: id
          }
      })
  }
}

export default new EventService()
