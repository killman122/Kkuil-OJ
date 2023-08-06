<script setup lang="ts">
import { useRoute } from "vue-router"

const $route = useRoute()

console.log($route.params.id)
</script>

<template>
    <div class="oj-judge h-[calc(100vh-74px)] overflow-hidden flex">
        <aside
            class="question-description flex-[0.5] border-r-2 h-full"
        ></aside>
        <main class="code-editor flex-[0.5] h-full"></main>
    </div>
</template>

<style scoped lang="scss"></style>
