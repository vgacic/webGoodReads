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
.log {
    display: flex;
    justify-content: center;
    place-items: center;
    height: 100vh;
  }
  
  .login-form {
    width: 300px;
    padding: 20px;
    background-color: #f2f2f2;
    border-radius: 5px;
  }
  
  .login-form input {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
  }
  
  .login-form button {
    width: 100%;
    padding: 8px;
    background-color: lightpink;
    border: none;
    border-radius: 3px;
    color: white;
    font-weight: bold;
  }
  
  .login-form button:hover {
    background-color: #e7cfd9;
  }
  
  .motive {
    position: relative;
    width: 100%;
    height: 50px;
  }
  
  .motive:before,
  .motive:after {
    content: "";
    position: absolute;
    top: 0;
    width: 100%;
    height: 100%;
  }
  
  .motive:before {
    background-color: lightpink;
    transform: skewY(-3deg);
  }
  
  .motive:after {
    background-color: #f2f2f2;
    transform: skewY(3deg);
  }
</style>