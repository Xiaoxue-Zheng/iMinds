<template>
  <ion-page>
    <ion-content>
      <slot></slot>
    </ion-content>
  </ion-page>
</template>
<script>
import { IonPage, IonContent } from "@ionic/vue";
export default {
  name: "Page",
  components: {
    IonContent,
    IonPage
  }
}
</script>