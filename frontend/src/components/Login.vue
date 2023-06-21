<template>
    <div>
      <h2>Login</h2>
      <form @submit.prevent="login">
        <div>
          <label for="email">Email:</label>
          <input type="email" id="email" v-model="email" required>
        </div>
        <div>
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <div>
          <button type="submit">Log In</button>
        </div>
      </form>
    </div>
  </template>


<script>
export default {
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    login() {
      
      console.log('Email:', this.email);
      console.log('Password:', this.password);
      
      
    }
  }
};
</script>

<style scoped>
h2 {
  text-align: center;
}
form {
  max-width: 300px;
  margin: 0 auto;
}
div {
  margin-bottom: 1rem;
}
label {
  display: block;
}
input {
  width: 100%;
  padding: 0.5rem;
}
button {
  padding: 0.5rem 1rem;
}
</style>