<template>
<p>&copy;2023BookHaven</p>
<h1>Home admin</h1>
<h2>Sve knjige</h2>
      <ul v-if="knjige.length > 0">
        <li v-for="knjiga in knjige" :key="knjiga.id">
          {{ knjiga.naslov }}
        </li>
      </ul>
      <p v-else>No books found.</p>
      <h2>Zanrovi</h2>

      <ul v-if="zanrovi.length > 0">
        <li v-for="zanr in zanrovi" :key="zanr.id">
          {{ zanr.naziv }}
        </li>
      </ul>
      <p v-else>No genres found.</p>

      <h2>Korisnici</h2>
      <ul v-if="korisnici.length > 0">
        <li v-for="korisnik in korisnici" :key="korisnik.id">
         Ime:  {{ korisnik.ime }} <br> Prezime: {{ korisnik.prezime }}<br> Datum rodjenja: {{ korisnik.datumRodjenja }} <hr>
        </li>
      </ul>
      <p v-else>No users found.</p>

      <h2>Pretrazi korisnika po id</h2>
      <input type="text" v-model="searchTerm1" placeholder="ID korisnika">
      <button @click="search1">Search</button>


      <h2>Dodaj knjigu</h2>
      <button @click="dodajKnjigu">Dodaj Knjigu</button>

</template>

<script>
import axios from 'axios';
import Logout from '@/components/Logout.vue';
import Login from '@/components/Login.vue';


export default  {
  name: "HomeAdministratorView",

data(){

  return{
    knjige :[],
    korisnici:[],
    zanrovi:[],
 
  };
},

mounted(){
  this.fetchKnjige();
  this.fetchKorisnici();
  this.fetchZanrovi();

},
methods:{
  fetchKnjige() {
      axios.get("http://localhost:8880/api/knjige")
        .then(response => {
          this.knjige = response.data; 
        })
        .catch(error => {
          console.error('Error fetching books:', error);
        });
    },
  fetchKorisnici(){
    axios.get("http://localhost:8880/api/korisnici")
    .then((response)=>{
      this.korisnici=response.data;
    })
    .catch((error)=>{
        console.log('Error fetching users',error);
    });
  },
  fetchZanrovi(){
	axios.get("http://localhost:8880/api/zanrovi")
	.then((response)=>{
		this.zanrovi=response.data;
	})
	.catch((error)=>{
        console.log('Error fetching zanrovi',error);
	});

},
search1(){
  if(this.searchTerm1){
        this.$router.push({path:'/search1',query:{searchTerm1:this.searchTerm1}});
      }
},

dodajKnjigu(){
  this.$router.push({path:'/dodajKnjigu'});

}


}

};


</script>


<style scoped>
h1 {
  text-align: center;
  margin-top: 2rem;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  background-color: lightpink;
  padding: 0.5rem;
  margin-bottom: 0.5rem;
}

</style>