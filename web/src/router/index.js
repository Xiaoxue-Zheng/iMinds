import { createRouter, createWebHistory } from 'vue-router';
import Participant from '../views/Participant.vue';
import SignIn from '../views/SignIn.vue';
//import { StoreService } from '@/services/store.service';

const routes = [
  {
    path: '/',
    name: 'Participant',
    component: Participant,
  },
  {
    path: '/participant',
    name: 'Participant',
    component: Participant,
  },
  {
   path: '/signin',
   name: 'SignIn',
   component: SignIn,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

//router.beforeEach((to, from, next) => {
//  const authenticated = StoreService.get('authenticated');
//  if (to.name !== 'SignIn' && !authenticated) {
//    next({
//      name: 'SignIn'
//    });
//  } else {
//    next();
//  }
//})

export default router;
