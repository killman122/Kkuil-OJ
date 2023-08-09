<script setup lang="ts">
import OjLangEditor from "./components/OjLangEditor/OjLangEditor.vue"
import OjQuestionDesc from "./components/OjQuestionDesc/OjQuestionDesc.vue"
import DraggableResize from "@/components/DraggableResize/DraggableResize.vue"
</script>

<template>
    <div class="oj-judge h-[calc(100vh-60px)] overflow-hidden flex">
        <DraggableResize :default-scale="0.5">
            <template #left>
                <OjQuestionDesc />
            </template>
            <template #right>
                <OjLangEditor />
            </template>
        </DraggableResize>
    </div>
</template>

<style scoped lang="scss"></style>
