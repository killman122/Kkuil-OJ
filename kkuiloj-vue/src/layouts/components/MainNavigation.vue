<script setup lang="ts">
import {onMounted} from "vue"
import {adminNavigation, navigation, NAVIGATION_PARENT_NAME} from "@/router/routes"
import {router} from "@/router"
import {useUserStore} from "@/stores/user"
import {useRouter} from "vue-router"

const $router = useRouter()
const userStore = useUserStore()

onMounted(async () => {
  if (userStore.isAuth) {
    adminNavigation.forEach((item) => {
      router.addRoute(NAVIGATION_PARENT_NAME, item)
    })
  }
})

// 切换路由
function switchRoute(name: string) {
  $router.push({name})
}
</script>

<template>
  <div class="navigation border-b-[1px] flex items-center">
    <a-menu mode="horizontal" :default-selected-keys="[navigation[0].name]">
      <a-menu-item key="0" class="h-[45px]" disabled>
        <img
            src="/assets/logo.png"
            alt="logo"
            title="logo"
            class="w-full h-full"
        />
      </a-menu-item>
      <a-menu-item
          v-for="{ name, meta } in navigation"
          :key="name"
          @click="switchRoute(name as string)"
      >
        {{ meta.name }}
      </a-menu-item>
    </a-menu>
    <a-avatar
        class="mr-[10px] cursor-pointer"
        :title="userStore.info.username ?? '未登录'"
        @click="userStore.isLogin ? null : switchRoute('login')"
    >
      {{ userStore.info.username ?? "未登录" }}
    </a-avatar>
  </div>
</template>

<style scoped lang="scss"></style>
