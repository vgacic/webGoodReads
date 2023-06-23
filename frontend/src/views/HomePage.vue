<template>
    <h1>BookHaven</h1>
    <div>
      <h2>Knjige</h2>
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
      </div>
      <h2>Pretraga knjiga po naslovu</h2>
      <input type="text" v-model="searchTerm" placeholder="Naziv knjige">
      <button @click="search">Search</button>
    <header>
      </header>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HomePage',
  data() {
    return {
      knjige: [],
      zanrovi:[],
      searchTerm:'',
    };
  },
  mounted() {
    this.fetchKnjige();
    this.fetchZanrovi();
   
  
  },
  methods: {
    fetchKnjige() {
      axios.get("http://localhost:8880/api/knjige")
        .then(response => {
          this.knjige = response.data; // Assuming the response returns an array of book objects
        })
        .catch(error => {
          console.error('Error fetching books:', error);
        });
    },

    fetchZanrovi(){
      axios.get("http://localhost:8880/api/zanrovi")
      .then(response=>{
        this.zanrovi=response.data;
      })
      .catch(error=>{
        console.error('Error fetching genres:',error);
      });

    },
    search(){
      if(this.searchTerm){
        this.$router.push({path:'/search',query:{searchTerm:this.searchTerm}});
      }
    },

},
};
</script>


<style scoped>


/* Add your component-specific styles here */
h1 {
  text-align: center;
  margin-top: 2rem;
}

/* Styling for the ul and li elements */
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


