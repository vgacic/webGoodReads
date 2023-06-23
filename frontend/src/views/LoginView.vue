<template>
  <form>
      <label>Email</label>
      <input v-model="LoginDto.email"/>
      <label>Lozinka</label>
      <input v-model="LoginDto.lozinka"/>
      <button v-on:click="prijava()">Prijavi se</button>
  </form>
</template>

<script>
export default {
name: 'PrijaviSe',
data: function () {
  return {
    LoginDto: {
      email: '',
      lozinka: ''
    }
  }
},
methods: {
  prijava: function () {
    fetch('http://localhost:8880/api/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(this.LoginDto)
    }).then(response => {
      if (response.ok) {
        return response.json()
      }
    }).then(body => {
      this.$router.push('/profil?id=' + body.id)
    }).catch(error => {
      console.error(error)
    })
  }
  }
}
</script>


<style>
/* Add your component-specific styles here */
form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
  color: lightpink;
  margin-top: 1rem;
}

.input-field {
  background-color: lightpink;
  border: none;
  padding: 0.5rem;
  margin-bottom: 1rem;
}

.submit-button {
  background-color: lightpink;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  cursor: pointer;
}

.submit-button:hover {
  background-color: #ff7b9c;
}
</style>