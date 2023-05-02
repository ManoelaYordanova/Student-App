import axios from 'axios'

class UserService {
  registerUser (request) {
    console.log(request)
    return axios.post('http://localhost:8080/api/v1/auth/register',
      {
        id: request.id,
        firstName: request.firstname,
        lastName: request.lastname,
        email: request.email,
        password: request.password
      })
  }
}

export default new UserService()
