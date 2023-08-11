import { Route } from "@/router/route"

export const NAVIGATION_PARENT_NAME = "layout"

// 管理员导航栏
export const adminNavigation: Route.RouteRecordRawInfo[] = [
    {
        path: "question-manage",
        name: "question-manage",
        meta: {
            name: "题目管理",
            isNeedAuth: true
        },
        component: () =>
            import("@/views/Navigation/OjQuestionManage/OjQuestionManage.vue")
    }
]

// 普通导航栏
export const navigation: Route.RouteRecordRawInfo[] = [
    {
        path: "dashboard",
        name: "dashboard",
        meta: {
            name: "首页"
        },
        component: () =>
            import("@/views/Navigation/OjDashboard/OjDashboard.vue")
    }
]

// 主路由
export const routes: Route.RouteRecordRawInfo[] = [
    {
        path: "/",
        name: NAVIGATION_PARENT_NAME,
        component: () => import("@/layouts/MainLayout.vue"),
        redirect: "/dashboard",
        children: [
            ...navigation,
            ...adminNavigation,
            {
                path: "online-judge/:id",
                name: "online-judge",
                meta: {
                    name: "在线判题",
                    isNeedLogin: true,
                    isNotNav: true
                },
                component: () =>
                    import("@/views/Navigation/OjJudge/OjJudge.vue")
            }
        ]
    },
    {
        path: "/login",
        name: "login",
        component: () => import("@/views/OjLogin/OjLogin.vue")
    },
    {
        path: "/no-auth",
        name: "no-auth",
        component: () => import("@/views/OjNoAuth/OjNoAuth.vue")
    },
    {
        path: "/:pathMatch(.*)*",
        name: "not-found",
        component: () => import("@/views/OjNotFound/OjNotFound.vue")
    }
]
