<script setup lang="ts">
import MainNavigation from "@/layouts/components/MainNavigation.vue"
</script>

<template>
  <div class="layout">
    <header class="header">
      <MainNavigation/>
    </header>
    <p class="content">
      <RouterView/>
    </p>
  </div>
</template>

<style scoped lang="scss"></style>
