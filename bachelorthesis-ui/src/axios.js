import axios from 'axios'

const axiosApiInstance = axios.create()
// Request interceptor for API calls
axiosApiInstance.interceptors.request.use(
  async config => {
    const accessToken = localStorage.getItem('access_token')
    if (accessToken) {
      config.headers = {
        Authorization: `Bearer ${accessToken}`
      }
    }
    return config
  },
  error => {
    Promise.reject(error)
  })

export default axiosApiInstance
