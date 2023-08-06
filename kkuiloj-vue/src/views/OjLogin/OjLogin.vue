<script setup lang="ts">
import { reactive } from "vue"
import _ from "lodash"
import MessageUtil from "@/utils/MessageUtil"
import CryptoUtil from "@/utils/CryptoUtil"
import { login } from "@/api/user"
import { USER_LOCAL_STORAGE_KEY } from "@/constant/user"
import { useRouter } from "vue-router"
import { useUserStore } from "@/stores/user"

const $router = useRouter()
const userInfo = reactive({
    username: "",
    password: ""
})
const userStore = useUserStore()

/**
 * @description 登录
 */
const handleLogin = _.throttle(async () => {
    MessageUtil.clear()
    if (userInfo.username.trim() === "") {
        return MessageUtil.error("用户名不能为空")
    }
    if (userInfo.password.trim() === "") {
        return MessageUtil.error("密码不能为空")
    }
    MessageUtil.loading("登录中...")
    const encryptPwd = CryptoUtil.md5(userInfo.password)
    const result: GlobalType.Result<string> = await login({
        ...userInfo,
        password: encryptPwd
    })
    if (!result.data) {
        MessageUtil.clear()
        return MessageUtil.error(result.message ?? "登录失败")
    }
    MessageUtil.clear()
    MessageUtil.success("登录成功")
    handleReset()
    await $router.push({
        name: "layout"
    })
    // 保存token
    localStorage.setItem(USER_LOCAL_STORAGE_KEY, result.data)
}, 500)

/**
 * @description 重置用户填写信息
 */
const handleReset = () => {
    userInfo.username = ""
    userInfo.password = ""
}
</script>

<template>
    <div class="login-or-registry flex h-screen">
        <div class="cover flex-[0] md:flex-[60%] bg-black h-full flex-center">
            <img class="mx-auto h-[200px]" src="/assets/logo.png" alt="logo" />
        </div>
        <div class="form flex-[40%] h-full">
            <div
                class="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8"
            >
                <div class="sm:mx-auto sm:w-full sm:max-w-sm">
                    <img
                        class="mx-auto h-[60px] w-auto"
                        src="/assets/logo.png"
                        alt="logo"
                    />
                    <h2
                        class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900"
                    >
                        Kkuil-OJ 在线判题系统
                    </h2>
                </div>

                <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
                    <form
                        class="space-y-6"
                        method="POST"
                        @submit.prevent="handleLogin"
                    >
                        <div>
                            <label
                                for="username"
                                class="block text-sm font-medium leading-6 text-gray-900 cursor-pointer"
                            >
                                用户名
                            </label>
                            <div class="mt-2">
                                <input
                                    id="username"
                                    name="username"
                                    type="text"
                                    autocomplete="username"
                                    placeholder="请输入用户名"
                                    required
                                    maxlength="10"
                                    v-model="userInfo.username"
                                    class="block w-full pl-[10px] rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                />
                            </div>
                        </div>

                        <div>
                            <div class="flex items-center justify-between">
                                <label
                                    for="password"
                                    class="block text-sm font-medium leading-6 text-gray-900 cursor-pointer"
                                >
                                    密码
                                </label>
                            </div>
                            <div class="mt-2">
                                <input
                                    id="password"
                                    name="password"
                                    placeholder="请输入密码"
                                    type="password"
                                    autocomplete="current-password"
                                    required
                                    maxlength="8"
                                    v-model="userInfo.password"
                                    class="block w-full pl-[10px] rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                />
                            </div>
                        </div>

                        <div>
                            <button
                                type="submit"
                                class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
                            >
                                登录/注册
                            </button>
                        </div>
                    </form>

                    <p class="mt-[15px] text-center text-sm text-gray-500">
                        账号已被注册，则视为登录账号；反之，则视为注册账号。
                    </p>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss"></style>
