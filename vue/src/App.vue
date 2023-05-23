<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import { v4 as uuidv4 } from 'uuid';

export default {
  created() {
    const deviceId = localStorage.getItem('deviceId');
    if (!deviceId) {
      const newDeviceId = uuidv4();
      localStorage.setItem('deviceId', newDeviceId);
    }

    console.log('Device ID: ', deviceId);
  }
}
</script>
