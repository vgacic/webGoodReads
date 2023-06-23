<template>
<div>
<h1>Trazena knjiga</h1>

      <ul v-if="knjigePoNaslovu.length > 0">
        <li v-for="knjiga in knjigePoNaslovu" :key="knjiga.naslov">
          
           <p>Naziv: {{ knjiga.naslov }}</p>
           <p>Datum izdavanja: {{ knjiga.datum }}</p>
          <p> ISBN: {{ knjiga.isbn }}</p>

        </li>
      </ul>
      <p v-else>No books found.</p>
</div>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      knjigePoNaslovu:[],
    };
  },
  created() { 
      const searchTerm=this.$route.query.searchTerm;


      if(searchTerm)
      {
        axios.get(`http://localhost:8880/api/pretrazi/${searchTerm}`)
        .then(response=>{
          this.knjigePoNaslovu=[response.data];
        })
      
      .catch(error=>{
        console.error('Error fetching books by title',error);
      });
    }
  }

};
</script>


<style scoped>

h1 {
  text-align: center;
  margin-top: 2rem;
  color: lightpink;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  background-color: peachpuff;
  padding: 0.5rem;
  margin-bottom: 0.5rem;
}
</style>






