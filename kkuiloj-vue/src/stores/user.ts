import {defineStore} from "pinia"
import {auth} from "@/api/user"
import {USER_LOCAL_STORAGE_KEY} from "@/constant/user"

export const useUserStore = defineStore("user", {
    state(): { info: Store.UserStore.UserInfo } {
        return {
            info: {
                id: null,
                username: null,
                role: null,
                token: null
            }
        }
    },
    actions: {
        async setUserInfo() {
            const result = await auth()
            if (result.data) {
                this.info = result.data
                // 刷新token
                localStorage.setItem(
                    USER_LOCAL_STORAGE_KEY,
                    result.data.token as string
                )
                return true
            }
            return false
        }
    },
    getters: {
        isLogin(): boolean {
            return !!this.info.username
        },
        isAuth(): boolean {
            return this.info.role === "admin"
        }
    }
})
