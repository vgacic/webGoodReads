<template>
  <header>
    <div class="container2">
      <div class="meniDeo">
        <div>
            <ul class="meni">

              <li id="pocetna"><a href="/homeAdministrator">Pocetna</a></li>
            </ul>
        </div>
        </div>
    </div>
  </header>
  <div class="home">
  </div>
<footer>
  <p>&copy;2023BookVerse</p>
  </footer>
</template>

<script>
import axios from 'axios';
import Logout from '@/components/Logout.vue';
import Login from '@/components/Login.vue';


export default  {
  name: "HomeAdministratorView",
  components:{
    Logout,
    Login,
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
    .get("http://localhost:8880/api/knjige",{withCredientials:true})
    .then((response)=>{
        this.knjige=response.data;
    })
    .catch((error)=>{
      console.log(error);
      alert("Failed to fetch knjige");
    });
  },
  getKorisnici(){
    axios
    .get("http://localhost:8880/api/korisnici",{withCredentials:true})
    .then((response)=>{
      this.korisnici=response.data;
    })
    .catch((error)=>{
        console.log(error);
        alert("Failed to fetch korisnici.")

    });
  },
  getZanrovi(){
	axios
	.get("http://localhost:8880/api/zanrovi",{withCredientials: true})
	.then((response)=>{
		this.zanrovi=response.data;
		
	
	})

	.catch((error)=>{

	console.log(error);
	alert("Failed to fetch zanrovi");
	})

},
getZahtevi(){
	axios
	.get("http://localhost:8880/api/zahtevi",{withCredientials: true})
	.then((response)=>{
		this.zahtevi=response.data;
		
	
	})

	.catch((erro)=>{

	console.log(error);
	alert("Failed to fetch zahtevi");
	});

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

</style>