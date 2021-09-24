<template>
  <ion-menu content-id="main-content" type="overlay" color="primary">
    <ion-content>
      <ion-list>
        <ion-item router-direction="root" router-link="/" lines="none" detail="false" class="hydrated">
          <ion-label>Home</ion-label>
        </ion-item>
        <ion-item button @click="showUniqueCode">
          <ion-label>My Code</ion-label>
        </ion-item>
      </ion-list>
    </ion-content>
  </ion-menu>
</template>
<script>
import { IonMenu, IonContent, IonList, IonItem, IonLabel, modalController } from '@ionic/vue';
import UniqueCodeModal from "@/components/UniqueCodeModal.vue";

export default {
  name: 'Menu',
  components: {
    IonMenu,
    IonContent,
    IonList,
    IonItem,
    IonLabel,
  },
  setup() {
    const showUniqueCode = async () => {
      const modal = await modalController.create({
        component: UniqueCodeModal,
      });
      return modal.present();
    };
    return { showUniqueCode };
  }

}
</script>