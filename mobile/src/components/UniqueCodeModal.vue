<template>
  <ion-header>
    <ion-toolbar>
      <ion-title>Your Unique Code</ion-title>
      <ion-button slot="end"  @click="closeModal">Close</ion-button>
    </ion-toolbar>
  </ion-header>
  <ion-content class="ion-padding">
          <!-- <div class="ion-text-center"> -->
    <ion-text color="primary" ><h1>{{ uniqueCode }}</h1></ion-text>
          <!-- </div> -->
    <span> Please share it with your researcher.</span>
  </ion-content>
</template>

<script>
import { IonContent, IonHeader, IonTitle, IonToolbar, modalController, IonButton, IonText } from '@ionic/vue';
import IdentificationService from "@/services/identification.service.js";

export default ({
  name: 'UniqueCodeModal',

  data() {
    return {
      uniqueCode: '',
    }
  },
  created() {
    IdentificationService.getUniqueCode()
    .then(response => {
        this.uniqueCode = response
    })
    .catch(error => {
        console.log(error)
    })
  },
  components: { IonContent, IonHeader, IonTitle, IonToolbar, IonButton, IonText },
  setup() {
    const closeModal = () => {
      modalController.dismiss();
    };
    return { closeModal };
  },
});
</script>