<template>
  <div id="nav">
   <button> <router-link to="/">Home</router-link></button>
  <button ><router-link to="/logout">Log out</router-link></button>
   <button> <router-link to="/login">Log in</router-link></button>
   <button><router-link to="/register">Register</router-link></button>
   <button><router-link to="/homeAutor">Home autor </router-link></button>
   <button><router-link to="/homeCitalac">Home citalac</router-link></button>
   <button><router-link to="/homeAdministrator">Home admin</router-link></button>
 <!-- <button><router-link to="/profil">Profil</router-link></button>-->
    
 
  </div>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>