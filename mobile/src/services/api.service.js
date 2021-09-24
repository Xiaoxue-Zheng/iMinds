import axios from 'axios'

export default {
  init () {
    axios.defaults.baseURL = process.env.VUE_APP_API_URL;
    axios.defaults.withCredentials = true
  },

  setAuthentication(jwtToken) {
    axios.interceptors.request.use(function (config) {
      config.headers.Authorization =  "Bearer " + jwtToken;
        return config;
    })
  },

  query (resource, params) {
    return axios.get(resource, { params: params }).catch(error => {
      throw new Error(`IMINDS ApiService ${error}`)
    })
  },

  getTemplateFromSlug (slug, resource) {
    if (slug === '') {
      return `${resource}`
    } else {
      return `${resource}/${slug}`
    }
  },

  get (resource, slug = '') {
    var template = this.getTemplateFromSlug(slug, resource)
    return axios.get(template).catch(error => {
      throw new Error(`IMINDS ApiService ${error}`)
    })
  },

  post (resource, params) {
    return axios.post(`${resource}`, params)
  },

  postFormData (url, formData) {
    return axios({
      method: 'post',
      url: url,
      data: formData,
      headers: { 'Content-Type': 'multipart/form-data' }
    })
  },

  update (resource, slug, params) {
    return axios.put(`${resource}/${slug}`, params)
  },

  put (resource, params) {
    return axios.put(`${resource}`, params)
  },

  delete (resource) {
    return axios.delete(resource).catch(error => {
      throw new Error(`IMINDS ApiService ${error}`)
    })
  }
}
