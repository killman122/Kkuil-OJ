import axios from "axios"

const BASE_URL: string = import.meta.env.VITE_REQUEST_BASE_URL
const BASE_PORT: number = import.meta.env.VITE_REQUEST_BASE_PORT
const BASE_TIMEOUT: number = import.meta.env.VITE_REQUEST_TIMEOUT
const BASE_PREFIX: string = import.meta.env.VITE_REQUEST_BASE_PREFIX

console.log(BASE_URL, BASE_PORT, BASE_TIMEOUT, BASE_PREFIX)

const request = axios.create({
    baseURL: BASE_URL + ":" + BASE_PORT + BASE_PREFIX,
    timeout: BASE_TIMEOUT
})

// 请求拦截器
request.interceptors.request.use(
    (config) => {
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
)

// 响应拦截器
request.interceptors.response.use(
    (response) => {
        return response.data
    },
    (error) => {
        return Promise.reject(error)
    }
)

export default request
