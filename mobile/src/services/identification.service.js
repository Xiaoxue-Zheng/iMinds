import StorageService from '@/services/storage.service';
import ApiService from './api.service.js'

const UNIQUE_CODE_KEY = "IMINDS-UNIQUE-CODE";

export default {

  async getUniqueCode() {
    let code = await StorageService.get(UNIQUE_CODE_KEY)
    console.log(code)
    return code;
  },

  async generateAndStoreUniqueCode() {
    let uniqueCode = await ApiService.post('/unique-codes', {'deviceId': '', 'appType':'IOS'})
    console.log(uniqueCode)
    StorageService.set(UNIQUE_CODE_KEY, uniqueCode.data)
    return uniqueCode
  },


}