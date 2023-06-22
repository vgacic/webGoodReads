<template>
        <div>
          <h2>Books</h2>
          <ul>
            <li v-for="book in books" :key="book.id">
              {{ book.title }}
            </li>
          </ul>
        </div>
      </template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      books: [],
    };
  },
  mounted() {
    this.fetchBooks();
  },
  methods: {
        fetchBooks() {
      fetch("https://localhost:8880/api/knjige")
        .then(response => response.json())
        .then(data => {
          this.books = data; // Assuming the response returns an array of book objects
        })
        .catch(error => {
          console.error('Error fetching books:', error);
        });
    }
  }
};
</script>

<style>
.book-list {
  list-style-type: none;
  padding: 0;
}

.book-item {
  margin-bottom: 10px;
  padding: 10px;
  background-color: #f51df5;
  border-radius: 5px;
}
</style>