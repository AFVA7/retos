<template>
  <form @submit.prevent="login">
    <div class="mb-3">
      <label for="username" class="form-label">Username</label>
      <input
        type="text"
        class="form-control"
        id="username"
        v-model="username"
        required
      />
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input
        type="password"
        class="form-control"
        id="password"
        v-model="password"
        required
      />
    </div>
    <button type="submit" class="btn btn-primary w-100">Login</button>
  </form>
</template>

<script setup lang="ts">

import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const username = ref('');
const password = ref('');

const router = useRouter();

const login = async () => {
  if(username.value === '' && password.value === '') {
    alert('Please enter username and password');
  } else {
    const token = await axios.post('http://authorizer:8080/login', {
      usuario: username.value,
      clave: password.value
    });

    if(token) {
      localStorage.setItem('token', token.data);
      router.push('/welcome');
    } else {
      alert('Invalid username or password');
    }
  }

}

</script>
