<script setup lang="ts">
import MainNavigation from "@/layouts/components/MainNavigation.vue"
import { onMounted } from "vue"
import { useUserStore } from "@/stores/user"

const userStore = useUserStore()

onMounted(() => {
    if (!userStore.isLogin) {
        userStore.setUserInfo()
    }
})
</script>

<template>
    <div class="layout">
        <header class="header">
            <MainNavigation />
        </header>
        <main class="content">
            <RouterView />
        </main>
        <div
            class="z-[999999] copyright fixed bottom-[10px] right-[10px] text-[#777] text-sm"
        >
            @Copyright 所有权归
            <a
                href="https://github.com/Kkuil"
                target="_blank"
                class="text-[#0094ff] hover:underline"
            >
                Kkuil
            </a>
            所有
        </div>
    </div>
</template>

<style scoped lang="scss"></style>
