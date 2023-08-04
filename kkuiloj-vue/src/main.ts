import { createApp } from "vue"
import { createPinia } from "pinia"
import App from "@/App.vue"
import router from "@/router"
import ArcoVue from "@arco-design/web-vue"
import "@arco-design/web-vue/dist/arco.css"
import "@/assets/styles/index.css"

const app = createApp(App)
const pinia = createPinia()

app.use(pinia).use(router).use(ArcoVue).mount("#app")
