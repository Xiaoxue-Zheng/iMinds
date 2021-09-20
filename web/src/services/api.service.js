import axios from 'axios';
import { API_URL } from './config';

var authenticationToken = null;

export default {
  init () {
    axios.defaults.baseURL = API_URL
    axios.defaults.withCredentials = true;
    axios.interceptors.request.use(function(config) {
      config.headers.Authorization = 'Bearer ' + authenticationToken;
      return config;
    });
  },

  setAuthentication(newToken) {
    authenticationToken = newToken;
  },

  query(resource, params) {
    return axios.get(resource, { params: params }).catch(error => {
      throw new Error(`ApiService ${error}`);
    });
  },

  getTemplateFromSlug(slug, resource) {
    if (slug === '') {
      return `${resource}`;
    } else {
      return `${resource}/${slug}`;
    }
  },

  get(resource, slug = '') {
    var template = this.getTemplateFromSlug(slug, resource);
    return axios.get(template).catch(error => {
      throw new Error(`ApiService ${error}`);
    });
  },

  post(resource, params) {
    return axios.post(`${resource}`, params);
  },

  postFormData(url, formData) {
    return axios({
      method: 'post',
      url: url,
      data: formData,
      headers: { 'Content-Type': 'multipart/form-data' }
    });
  },

  update(resource, slug, params) {
    return axios.put(`${resource}/${slug}`, params);
  },

  put(resource, params) {
    return axios.put(`${resource}`, params);
  },

  delete(resource) {
    return axios.delete(resource).catch(error => {
      throw new Error(`ApiService ${error}`);
    });
  }
};
