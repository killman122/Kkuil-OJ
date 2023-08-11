// 路由类型定义
import { RouteLocationNormalized, RouteRecordRaw } from "vue-router"

declare namespace Route {
    //  路由元信息类型定义
    type RouteMetaRaw = {
        name?: string
        isNeedAuth?: boolean
        isNeedLogin?: boolean
        isNotNav?: boolean
    }
    type RouteRecordRawInfo = RouteRecordRaw & {
        meta?: RouteMetaRaw
    }
    // 为了让 TS 识别 meta 字段
    type TRouteLocationNormalized = RouteLocationNormalized & {
        meta: RouteMetaRaw
    }
}
