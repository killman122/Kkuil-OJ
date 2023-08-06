import {fileURLToPath, URL} from "node:url"

import {defineConfig} from "vite"
import vue from "@vitejs/plugin-vue"
import AutoImport from "unplugin-auto-import/vite"
import Components from "unplugin-vue-components/vite"
import {ArcoResolver} from "unplugin-vue-components/resolvers"

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        AutoImport({
            resolvers: [ArcoResolver()]
        }),
        Components({
            resolvers: [
                ArcoResolver({
                    sideEffect: true
                })
            ]
        })
    ],
    server: {
        port: 3170,
        proxy: {
            "^/api": {
                target: "http://127.0.0.1:3171",
                changeOrigin: true
            }
        }
    },
    // 为了在 .env 文件中使用 import.meta.env.VITE_XXX 的形式
    envPrefix: "VITE_",
    resolve: {
        alias: {
            "@": fileURLToPath(new URL("./src", import.meta.url))
        }
    }
})
