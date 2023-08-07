<script setup lang="ts">
import OjLangEditor from "./components/OjLangEditor/OjLangEditor.vue"
</script>

<template>
    <div class="oj-judge h-[calc(100vh-60px)] overflow-hidden flex">
        <aside
            class="question-description flex-[0] md:flex-[0.5] border-r-2 h-full"
        ></aside>
        <main class="code-editor flex-1 md:flex-[0.5] h-full">
            <OjLangEditor />
        </main>
    </div>
</template>

<style scoped lang="scss"></style>
