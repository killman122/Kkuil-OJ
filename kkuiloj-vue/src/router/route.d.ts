// 路由类型定义
import { RouteRecordRaw } from "vue-router"

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
}
