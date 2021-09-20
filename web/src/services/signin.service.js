import ApiService from '@/services/api.service';
import { StoreService } from '@/services/store.service';

export const SignInService = {
  init () {
    const token = StoreService.get('authenticationToken');
    ApiService.setAuthentication(token);
  },

  async signIn(email, password) {
    const credentials = {
      username: email,
      password: password,
      rememberMe: true
    };
    return ApiService.post('authenticate', credentials).then(
      async response => {
        const token = response.data.id_token;
        this.storeAuthentication(token);
        return true;
      },
      error => {
        console.log(error);
        return false;
      }
    );
  },

  signOut() {
    this.storeAuthentication(null);
  },

  storeAuthentication(token) {
    StoreService.set('authenticationToken', token);
    ApiService.setAuthentication(token);

    const authenticated = token != null;
    StoreService.set('authenticated', authenticated);
  }

};
