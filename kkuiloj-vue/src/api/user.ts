import request from "@/utils/request"

/**
 * @description 登录
 * @param data 登录信息
 */
export function login(
    data: Request.User.Login
): Promise<GlobalType.Result<string>> {
    return request({
        url: "/user/login",
        method: "POST",
        data
    })
}

/**
 * @description 授权
 */
export function auth(): Promise<GlobalType.Result<Store.UserStore.UserInfo>> {
    return request({
        url: "/user/auth",
        method: "GET"
    })
}
