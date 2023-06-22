<template>
    <div>
<h1>Registration</h1>
<form @submit="registerUser" class="pink-form">
    <label for="ime">Ime:</label>
    <input type="text" id="ime" v-model="registerData.ime" required>
    <br>
    <br>

    <label for="prezime">Prezime:</label>
    <input type="text" id="prezime" v-model="registerData.prezime" required>

    <br>
    <br>

    <label for="email">Email:</label>
    <input type="text" id="email" v-model="registerData.email" required>

    <br>
    <br>

    <label for="korisnickoIme">Korisnicko ime:</label>
    <input type="text" id="korisnickoIme" v-model="registerData.korisnickoIme" required>

    <br>
    <br>

    <label for="lozinka">Lozinka:</label>
    <input type="text" id="lozinka" v-model="registerData.lozinka" required>

    <br>
    <br>

    <label for="ponovljenaLozinka">Ponovljena lozinka:</label>
    <input type="text" id="ponovljenaLozinka" v-model="registerData.ponovljenaLozinka" required>



    <button type="submit">Register</button>
    </form>
    
<p>{{ registrationStatus }}</p>
</div>
</template>


<script>
import axios from 'axios';

export default {
  data:function() 
    
  {
    return {
      registerData:{
    "ime" : '',
    "prezime": '',
    "email": '',
    "korisnickoIme": '',
    "lozinka": '',
    "ponovljenaLozinka":''
       
      },
      registrationStatus:'',
    };
  },
  methods: {
registerUser(event){
    event.preventDefault();

    axios.post('http://localhost:8880/api/registracija',this.registerData)
    .then(response=>{
    this.registrationStatus=response.data;
    alert("Uspesna registracija");})

    .catch(error=>{
        if(error.response&&error.response.data){
            this.registrationStatus=error.response.data;
        }
        else
        {
            this.registrationStatus='Greska prilikom registracije';
            alert("Greska");
        }
    })


  }
}
}


</script>
<style>
.pink-form {
  background-color: pink;
  padding: 20px;
  border-radius: 10px;
}

.form-group {
  margin-bottom: 10px;
}

.form-group label {
  display: block;
  font-weight: bold;
}

.form-group input[type="text"],
.form-group input[type="date"] {
  padding: 5px;
  border-radius: 5px;
  border: none;
}

.pink-form button[type="submit"] {
  padding: 10px 20px;
  background-color: #ff77a9;
  border: none;
  color: white;
  font-weight: bold;
  cursor: pointer;
}
</style>
<style scoped>
h4 {
    text-align: center;
    margin: 0;
    padding: 0;
    font-weight: 800;
    font-size: 18px;
}
p {
    text-align: center;
    font-size: 14px;
    padding-bottom: 10px;
}
.login-box {
    width: 400px;
    height: auto;
    background-color: white;
    margin-top: 60px;
    border-radius: 5px;
    padding: 40px;
    margin: auto;
    margin-top: 60px;
    border: 1px solid #E4E6E7;
    box-shadow: 0px 2px 5px rgba(0,0,0,0.4);
}
</style>