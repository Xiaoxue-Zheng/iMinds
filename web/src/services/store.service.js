import { ConstantService } from '@/services/constant.service';
import { ref } from 'vue';

export const StoreService = {
  store: ref({
    authenticationToken: null,
    authenticated: false,
    project: {}
  }),

  init () {
    const storeJSON = window.sessionStorage.getItem(
      ConstantService.STORAGE_KEY
    );

    if (storeJSON != null) {
      this.store.value = JSON.parse(storeJSON);
    }
  },

  get(key) {
    return this.store.value[key];
  },

  set(key, value) {
    this.store.value[key] = value;
    this.save();
  },

  clear(key) {
    this.set(key, null);
  },

  save() {
    const storeJSON = JSON.stringify(this.store.value);
    window.sessionStorage.setItem(ConstantService.STORAGE_KEY, storeJSON);
  }
};
