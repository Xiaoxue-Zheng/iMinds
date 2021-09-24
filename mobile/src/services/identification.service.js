import StorageService from '@/services/storage.service';
import ApiService from './api.service.js'

const UNIQUE_CODE_KEY = "IMINDS-UNIQUE-CODE";

export default {

  async getUniqueCode() {
    let code = await StorageService.get(UNIQUE_CODE_KEY)
    return code;
  },

  async generateAndStoreUniqueCode() {
    return new Promise((resolve) => 
    {
      ApiService.post('/unique-codes', {'deviceId': '', 'appType':'IOS'})
      .then((res)=>  {
        StorageService.set(UNIQUE_CODE_KEY, res.data)
        resolve(res)
      }).catch(() => {
        resolve('ERROR')
      })
    })
  },
}