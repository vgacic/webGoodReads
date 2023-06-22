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