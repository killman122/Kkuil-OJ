import request from "@/utils/request"
import {USER_LOCAL_STORAGE_KEY, USER_REQUEST_HEADER_KEY} from "@/constant/user"

/**
 * @description 登录
 * @param data 登录信息
 */
export function login(
    data: Request.User.Login
): Promise<GlobalType.Result<string>> {
    return request({
        url: "/login",
        method: "POST",
        data
    })
}

/**
 * @description 授权
 */
export function auth(): Promise<GlobalType.Result<Store.UserStore.UserInfo>> {
    return request({
        url: "/auth",
        method: "GET",
        headers: {
            [USER_REQUEST_HEADER_KEY]: localStorage.getItem(
                USER_LOCAL_STORAGE_KEY
            )
        }
    })
}
