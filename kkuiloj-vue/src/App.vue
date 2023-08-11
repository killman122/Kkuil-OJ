<script setup lang="ts">
// import { useUserStore } from "@/stores/user"
// import { router } from "@/router"
// import type { RouteRecordName } from "vue-router"
// import { adminNavigation } from "@/router/routes"
//
// const userStore = useUserStore()
//
// userStore.$subscribe(
//     () => {
//         if (userStore.isAuth) {
//             adminNavigation.forEach((route) => {
//                 router.removeRoute(route.name as RouteRecordName)
//             })
//         }
//     },
//     {
//         immediate: true,
//         deep: true
//     }
// )
</script>

<template>
    <div id="app">
        <RouterView />
    </div>
</template>
