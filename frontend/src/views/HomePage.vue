<template>
    <h1>BookHaven</h1>
    <div>
      <h2>Books</h2>
      <ul v-if="knjige.length > 0">
        <li v-for="knjiga in knjige" :key="knjiga.id">
          {{ knjiga.naslov }}
        </li>
      </ul>
      <p v-else>No books found.</p>
    </div>
    

</template>

<script>
import axios from 'axios';

export default {
  name: 'HomePage',
  data() {
    return {
      knjige: [],
    };
  },
  mounted() {
    this.fetchKnjige();
  
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
    }
    }

  
};
</script>


