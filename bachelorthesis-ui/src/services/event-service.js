import axios from 'axios'

const API_URL = 'http://localhost:8080/event'

class EventService {
  addEvent (eventRequest) {
    console.log(eventRequest)
    return axios.post(API_URL + '/create',
      {
        name: eventRequest.name,
        startDate: eventRequest.startDate,
        endDate: eventRequest.endDate,
        startTime: eventRequest.startTime,
        endTime: eventRequest.endTime,
        description: eventRequest.description
      })
  }

  getAllEvents () {
    return axios.get(API_URL + '/load')
  }
}

export default new EventService()
