import type { NavigationGuardNext } from "vue-router"
import { createRouter, createWebHistory } from "vue-router"
import { routes } from "@/router/routes"
import { useUserStore } from "@/stores/user"
import MessageUtil from "@/utils/MessageUtil"
import type { Route } from "@/router/route"

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

// 全局前置守卫
router.beforeEach(
    async (
        to: Route.TRouteLocationNormalized,
        from: Route.TRouteLocationNormalized,
        next: NavigationGuardNext
    ) => {
        const userStore = useUserStore()

        // 判断是否需要登录
        if (to.meta.isNeedLogin || to.meta.isNeedAuth) {
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
        return next()
    }
)

export { router }
