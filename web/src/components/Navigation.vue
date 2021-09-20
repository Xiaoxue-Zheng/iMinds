<template>
 <div id="nav" class="home-menu pure-menu pure-menu-horizontal">
    <h1>i-Minds</h1>
 </div>
</template>

<script>
import { StoreService } from '@/services/store.service';
import { SignInService } from '@/services/signin.service';
import router from '@/router';

export default {
  name: 'Navigation',
  data() {
    return {
      store: StoreService.store
    };
  },
  methods: {
    signOut() {
      SignInService.signOut();
      router.push('/signin');
    }
  }
};
</script>
