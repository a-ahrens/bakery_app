<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link v-bind:to="{name: 'bakery_store'}">Store</router-link>
  </div>
</template>

<script>

export default {
  name: "home"
};
</script>
