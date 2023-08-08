<script setup lang="ts">
import { useUserStore } from "@/stores/user"
import { router } from "@/router"
import MessageUtil from "@/utils/MessageUtil"
import type { NavigationGuardNext, RouteLocationNormalized } from "vue-router"
import { adminNavigation, NAVIGATION_PARENT_NAME } from "@/router/routes"

// 为了让 TS 识别 meta 字段
type TRouteLocationNormalized = RouteLocationNormalized & {
    meta: {
        isNeedLogin?: boolean
        isNeedAuth?: boolean
    }
}

const userStore = useUserStore()

// 全局前置守卫
router.beforeEach(
    async (
        to: TRouteLocationNormalized,
        from: RouteLocationNormalized,
        next: NavigationGuardNext
    ) => {
        // 判断是否需要登录
        if (to.meta.isNeedLogin) {
            if (!userStore.isLogin) {
                try {
                    await userStore.setUserInfo()
                } catch (error) {
                    console.log(error)
                    next({ name: "login" })
                }
            }
            if (!userStore.isLogin) {
                MessageUtil.error({
                    content: "请先登录",
                    showIcon: true,
                    closable: true,
                    duration: 3000
                })
                return next({ name: "login" })
            }
            // 判断是否需要授权
            if (to.meta.isNeedAuth) {
                if (!userStore.isAuth) {
                    MessageUtil.error({
                        content: "请先授权",
                        showIcon: true,
                        closable: true,
                        duration: 3000
                    })
                    return next({ name: "no-auth" })
                }
            }
        }
        return next()
    }
)

userStore.$subscribe(
    () => {
        console.log(userStore.isAuth)
        if (userStore.isAuth) {
            adminNavigation.forEach((item) => {
                router.addRoute(NAVIGATION_PARENT_NAME, item)
                console.log(router.options.routes)
            })
        }
    },
    {
        deep: true
    }
)
</script>

<template>
    <div id="app">
        <RouterView />
    </div>
</template>
