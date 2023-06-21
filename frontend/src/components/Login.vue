<template>
    <div>
      <!-- Login form -->
      <form @submit="login">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required>
        
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required>
  
        <button type="submit">Log In</button>
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
      // Implement your login logic here
      // Access the email and password through `this.email` and `this.password`
      // You can make an API call to authenticate the user, handle validation, etc.
    }
  }
};
</script>

<style scoped>
/* Add your component-specific styles here */
form {
  display: flex;
  flex-direction: column;
  max-width: 300px;
  margin: 0 auto;
}

label {
  margin-bottom: 0.5rem;
}

input {
  padding: 0.5rem;
  margin-bottom: 1rem;
}

button {
  padding: 0.5rem 1rem;
}
</style>