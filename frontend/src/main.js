import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

createApp(App).use(router).mount('#app')
/*new VueElement({
    el:'#app',
    router,
    template:'<App/>',
    components:{App}
})*/