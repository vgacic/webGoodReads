<template>
    <div>
    <h1>Trazeni korisnik</h1>
    
    <ul v-if="korisniciPoId.length > 0" class="user-list">
        <li v-for="korisnik in korisniciPoId" :key="korisnik.id" class="user-item">
              
               <p>ID: {{korisnik.id}}</p>
               <p>Ime: {{korisnik.ime}}</p>
               <p>Prezime: {{korisnik.prezime}}</p>
              <p>Korisnicko ime: {{korisnik.korisnickoIme}}</p>
               <p>E-mail: {{korisnik.email}}</p>
              <p>Lozinka: {{korisnik.lozinka}}</p>
              <p>Datum rodjenja: {{korisnik.datumRodjenja}}</p>
              <p>Opis: {{korisnik.opis}} </p>
              <p>Uloga: {{korisnik.uloga}}</p>
               <p>Police: {{korisnik.police}}</p>
              <p>Aktivan: {{korisnik.aktivan}}</p>
              <p>Password: {{korisnik.password}}</p>
    
            </li>
          </ul>
          <p v-else>No users found.</p>
    </div>
    </template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      korisniciPoId:[],
    };
  },
  created() { 
      const searchTerm1=this.$route.query.searchTerm1;


      if(searchTerm1)
      {
        axios.get(`http://localhost:8880/api/korisnik?id=${searchTerm1}`)
        .then(response=>{
          this.korisniciPoId=[response.data];
        })
      
      .catch(error=>{
        console.error('Error fetching users',error);
      });
    }
  }

};
</script>

<style scoped>
.section-title {
  color: lightpink;
  font-size: 24px;
  margin-top: 1rem;
}

.user-list {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.user-item {
  background-color: lightpink;
  padding: 1rem;
  margin-bottom: 1rem;
}

.user-item p {
  color: blaxk;
  margin-bottom: 0.5rem;
}

.no-users {
  color: lightpink;
  font-style: italic;
}
</style>