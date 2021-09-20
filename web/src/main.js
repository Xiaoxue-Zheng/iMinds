import Purecss from 'purecss-sass'

import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ApiService from '@/services/api.service';
import { StoreService } from '@/services/store.service';
import { SignInService } from '@/services/signin.service';

ApiService.init()
SignInService.init()
StoreService.init()


createApp(App).use(store).use(router).mount("#app");
