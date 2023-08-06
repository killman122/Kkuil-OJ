<script setup lang="ts">
import OjQuestionList from "./components/OjQuestionList/OjQuestionList.vue"
</script>

<template>
  <div class="dashboard p-[10px]">
    <aside
        class="w-[50%] border-2 rounded-[15px] p-[10px] overflow-scroll hide-scrollbar"
    >
      <OjQuestionList/>
    </aside>
  </div>
</template>

<style scoped lang="scss"></style>
