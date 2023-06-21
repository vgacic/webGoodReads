<template>
  <div class="home">
  </div>
</template>

<script>
import axios from 'axios';
import Logout from '@/components/Logout.vue';


export default  {
  name: "HomeAdministratorView",
  components:{
    Logout,
  },
data(){

  return{
    knjige :[],
    korisnici:[],
    zanrovi:[],
    zahtevi:[],
  };
},
mounted(){
  this.getKnjige();
  this.getKorisnici();
  this.getZanrovi();
  this.getZahtevi();
},
methods:{
  getKnjige(){
    axios
    .get("http://localhost:8081/api/knjige",{withCredientials:true})
    .then((response)=>{
        this.knjige=response.data;
    })
    .catch((error)=>{
      console.log(error);
      alert("Failed to fetch knjige");
    });
  }
}
}


</script>


<style scoped>
/* Add your component-specific styles here */
h1 {
  text-align: center;
  margin-top: 2rem;
}

</style>