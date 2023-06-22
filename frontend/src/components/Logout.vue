<template>
    <div>
      <h2>Logout</h2>
      <button @click="logout">Log Out</button>
    </div>
  </template>

<script>
export default {
  name: 'OdjaviSe',

  methods: {
    logout() {
     /* fetch("http://localhost:8880/api/logout"),{
        method:'POST'
      }*/

      localStorage.clear();
      this.$router.push('/login');
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