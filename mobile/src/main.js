import { createApp } from 'vue'
import App from './App.vue'
import router from './router';

import { IonicVue, modalController } from '@ionic/vue';
import ApiService from '@/services/api.service.js';
import StorageService from '@/services/storage.service.js';
import IdentificationService from "@/services/identification.service";

/* Core CSS required for Ionic components to work properly */
import '@ionic/vue/css/core.css';

/* Basic CSS for apps built with Ionic */
import '@ionic/vue/css/normalize.css';
import '@ionic/vue/css/structure.css';
import '@ionic/vue/css/typography.css';

/* Optional CSS utils that can be commented out */
import '@ionic/vue/css/padding.css';
import '@ionic/vue/css/float-elements.css';
import '@ionic/vue/css/text-alignment.css';
import '@ionic/vue/css/text-transformation.css';
import '@ionic/vue/css/flex-utils.css';
import '@ionic/vue/css/display.css';

/* Theme variables */
import './theme/variables.css';
import UniqueCodeModal from "./components/UniqueCodeModal.vue";

const app = createApp(App)
  .use(IonicVue)
  .use(router);
 
ApiService.init();

router.isReady().then(async () => {
  await StorageService.initialise();
  let uniqueCode = await IdentificationService.getUniqueCode()
  if (!uniqueCode){
    await IdentificationService.generateAndStoreUniqueCode()
    const modal = await modalController.create({
      component: UniqueCodeModal, 
    });
    modal.present();
  }
  app.mount('#app');
});