import axios from 'axios'

const API_URL = 'http://localhost:8080'

class UserService {
  registerUser (request) {
    console.log(request)
    return axios.post(API_URL + '/api/v1/auth/register',
      {
        id: request.id,
        firstName: request.firstname,
        lastName: request.lastname,
        email: request.email,
        password: request.password
      })
  }

  authenticateUser (request) {
    console.log(request)
    return axios.post(API_URL + '/api/v1/auth/authenticate',
      {
        email: request.email,
        password: request.password
      })
  }

  loggedUser () {
    const token = localStorage.getItem('token')

    return axios.get(API_URL + '/api/v1/auth/authenticate',
      {
        headers: {
          Authorization: 'Bearer ' + token,
          'x-access-token': token
        }
      })
  }
}

export default new UserService()
