import { createApp } from "vue"
import { createPinia } from "pinia"
import App from "@/App.vue"
import { router } from "@/router"
import ArcoVue from "@arco-design/web-vue"
import "@arco-design/web-vue/dist/arco.css"
import "@/assets/styles/index.css"
import DraggableResize from "@/components/DraggableResize/DraggableResize.vue"
import KSkeleton from "@/components/KSkeleton/KSkeleton.vue"
import KSkeletonItem from "@/components/KSkeleton/components/KSkeletonItem.vue"

const app = createApp(App)
const pinia = createPinia()

app.use(pinia)
    .use(router)
    .use(ArcoVue)
    .component("DraggableResize", DraggableResize)
    .component("KSkeleton", KSkeleton)
    .component("KSkeletonItem", KSkeletonItem)
    .mount("#app")
