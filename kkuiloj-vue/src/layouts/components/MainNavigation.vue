<script setup lang="ts">
import { useUserStore } from "@/stores/user"
import { useRoute, useRouter } from "vue-router"
import { USER_LOCAL_STORAGE_KEY } from "@/constant/user"
import { computed } from "vue"
import { router } from "@/router"
import { NAVIGATION_PARENT_NAME } from "@/router/routes"
import { Route } from "@/router/route"

const $router = useRouter()
const $route = useRoute()
const userStore = useUserStore()
const mapOption = {
    login: () => {
        switchRoute("login")
    },
    logout: () => {
        localStorage.removeItem(USER_LOCAL_STORAGE_KEY)
        switchRoute("login")
    }
}

/**
 * @description 切换路由
 * @param name
 */
function switchRoute(name: string) {
    $router.push({ name })
}

/**
 * @description 处理菜单选择
 * @param value
 */
const handleSelect = (value: string) => {
    mapOption[value]()
}

/**
 * @description 获取导航菜单
 */
const navigation = computed(() => {
    return (
        router.options.routes.filter(
            (route) => route.name === NAVIGATION_PARENT_NAME
        )[0].children as Route.RouteRecordRawInfo[]
    ).filter((route) => !route.meta?.isNotNav)
})
</script>

<template>
    <div class="navigation border-b-[1px] flex items-center px-[10px]">
        <img
            src="/assets/logo.png"
            alt="logo"
            title="回到首页"
            class="h-[45px] cursor-pointer"
            @click="switchRoute('layout')"
        />
        <a-menu
            mode="horizontal"
            :default-selected-keys="[navigation[0].name]"
            :selected-keys="[$route.name]"
        >
            <a-menu-item
                v-for="{ name, meta } in navigation"
                :key="name"
                @click="switchRoute(name as string)"
            >
                {{ meta.name }}
            </a-menu-item>
        </a-menu>
        <a-dropdown @select="handleSelect">
            <a-avatar
                class="cursor-pointer"
                :title="userStore.info.username ?? '未登录'"
            >
                {{ userStore.info.username ?? "未登录" }}
            </a-avatar>
            <template #content>
                <a-doption v-if="!userStore.isLogin" value="login">
                    登录
                </a-doption>
                <a-doption v-else value="logout">退出登录</a-doption>
            </template>
        </a-dropdown>
    </div>
</template>

<style scoped lang="scss"></style>
