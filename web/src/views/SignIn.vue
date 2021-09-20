<template>
  <div class="signin">
    <form @submit.prevent="signin">
      <h1>Log in</h1>
      <label for="email">Email address</label>
      <input
        id="email"
        type="text"
        name="email"
        v-model="email"
        autocomplete="username"
      />
      <label for="password">Password</label>
      <input
        id="password"
        type="password"
        name="password"
        v-model="password"
        autocomplete="current-password"
      />
      <div class="failure" v-show="failure">
        Could not log in, please check your details and try again.
      </div>
      <button @click="signin">Log in</button>
    </form>
  </div>
</template>

<script>
import { SignInService } from '@/services/signin.service';
import router from '@/router';

export default {
  data: function() {
    return {
      email: '',
      password: '',
      failure: false
    };
  },
  methods: {
    async signin() {
      this.failure = false;
      const success = await SignInService.signIn(this.email, this.password);
      if (success) {
        router.replace('/participant');
      } else {
        this.failure = true;
      }
    }
  }
};
</script>

<style scoped>
.signin {
  background: #f7f7f7;
  min-height: 100vh;
  text-align: center;
}

form {
  display: inline-block;
  margin: 4em auto;
  border: 1px solid #d5d5d5;
  background: #fff;
  padding: 1em 2em 2em 2em;
  width: 16em;
}

h1 {
  text-align: left;
  font-size: 1.6em;
  padding: 0;
  margin-bottom: 1em;
}

label {
  font-weight: bold;
  margin: 1em 0 0.2em 0;
  display: block;
  text-align: left;
}

input {
  display: block;
  margin-bottom: 2em;
  width: 100%;
  line-height: 1.6em;
  box-sizing: border-box;
}

.failure {
  font-weight: bold;
}

button {
  display: block;
  width: 100%;
  border: none;
  background: #008561;
  font-size: 1.1em;
  color: white;
  padding: 0.5em;
  margin-top: 2em;
}
</style>
