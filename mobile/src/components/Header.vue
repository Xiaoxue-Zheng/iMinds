<template>
  <ion-header>
    <ion-toolbar>
      <ion-buttons slot="start">
        <ion-menu-button>
        </ion-menu-button>
        <ion-title><strong>i-Minds</strong></ion-title>
      </ion-buttons>
    </ion-toolbar>
  </ion-header>
</template>
<script>
import { IonHeader, IonToolbar, IonMenuButton, IonButtons, IonTitle } from '@ionic/vue';

export default ({
  name: 'Header',
  setup() {
    
  },
  components: {
    IonToolbar,
    IonHeader,
    IonMenuButton,
    IonButtons,
    IonTitle,
  },
  data() {
    return {

    }
  }
})
</script>
