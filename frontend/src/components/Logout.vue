<template>
    <div>
      <h2>Logout</h2>
      <button @click="logout">Log Out</button>
    </div>
  </template>

<script>
export default {
  methods: {
    logout() {
      // Perform your logout logic here
      // You can clear user authentication, remove tokens, etc.
      // Remember to handle success and error cases accordingly
      console.log('User logged out');
    }
  }
};
</script>

<style scoped>
h2 {
  text-align: center;
}
button {
  padding: 0.5rem 1rem;
}
</style>