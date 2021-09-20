<template>
 <div id="nav" class="home-menu pure-menu pure-menu-horizontal">
    <router-link class="pure-menu-heading" to="/">i-Minds</router-link>
    <ul class="pure-menu-list">
        <li v-if="!store.authenticated" class="pure-menu-item"><router-link class="pure-menu-link" to="/signin">Sign in</router-link></li>
        <li v-if="store.authenticated" v-on:click="signOut" class="pure-menu-item"><a href="#" class="pure-menu-link">Sign out</a></li>
    </ul>
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
