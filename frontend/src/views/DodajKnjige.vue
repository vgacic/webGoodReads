<template>
    <div>
      <h1>Add Book</h1>
      <form @submit.prevent="dodajKnjigu">
        <label>Title</label>
        <input v-model="knjiga.naslov" required>
        <label>Date</label>
        <input v-model="knjiga.datum" type="date" required>
        <label>ISBN</label>
        <input v-model="knjiga.isbn" required>
        <button type="submit">Add Book</button>
      </form>
      <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
      <p v-if="successMessage" class="success-message">{{ successMessage }}</p>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        knjiga: {
          naslov: '',
          datum: '',
          isbn: ''
        },
        errorMessage: '',
        successMessage: ''
      };
    },
    methods: {
      dodajKnjigu() {
        this.errorMessage = '';
        this.successMessage = '';
  
        axios.post('/api/autor/dodajKnjige', this.knjiga)
          .then(response => {
            this.successMessage = response.data;
            this.knjiga = {
              naslov: '',
              datum: '',
              isbn: ''
            };
          })
          .catch(error => {
            if (error.response && error.response.data) {
              this.errorMessage = error.response.data;
            } else {
              this.errorMessage = 'An error occurred while adding the book.';
            }
          });
      }
    }
  };
  </script>
  
  <style>
  .error-message {
    color: red;
  }
  
  .success-message {
    color: green;
  }
  </style>