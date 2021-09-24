<template>
  <ion-app>
    <ion-split-pane content-id="main-content">
      <Menu></Menu>
      <ion-page id="main-content">
        <Header></Header>
        <ion-router-outlet />
      </ion-page>
    </ion-split-pane>
  </ion-app>
</template>

<script>
import { IonApp, IonRouterOutlet, IonSplitPane, IonPage } from '@ionic/vue';
import Menu from '@/components/Menu.vue';
import Header from '@/components/Header.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'App',
  components: {
    IonApp,
    IonPage,
    IonSplitPane,
    IonRouterOutlet,
    Menu,
    Header
  }
});
</script>
