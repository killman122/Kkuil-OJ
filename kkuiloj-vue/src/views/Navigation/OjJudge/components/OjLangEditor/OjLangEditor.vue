<script setup lang="ts">
import { Codemirror } from "vue-codemirror"
import { reactive, Ref, ref, watch } from "vue"
import { javascript } from "@codemirror/lang-javascript"
import { java } from "@codemirror/lang-java"
import { oneDark } from "@codemirror/theme-one-dark"
import type { EditorState } from "@codemirror/state"
import KSkeleton from "@/components/KSkeleton/KSkeleton.vue"
import KSkeletonItem from "@/components/KSkeleton/components/KSkeletonItem.vue"
import InputEventDefinition = GlobalType.InputEventDefinition
import RunResult = GlobalType.RunResult

type NavigationProps = {
    active: string
    items: { name: string; label: string }[]
}

// 语言映射
const LANG_MAP_EDITOR = {
    javascript: javascript(),
    java: java()
}

// 编辑器默认扩展
const DEFAULT_EXTENSIONS = [oneDark]
const view = ref<EditorState>()

// 模态框的可见性
const visible = ref<boolean>(false)

// 编辑器配置
const editorConfig = reactive({
    tabSize: 4,
    autofocus: true,
    indentTabSize: true,
    placeholder: "请开始你的答题......",
    extensions: [javascript(), ...DEFAULT_EXTENSIONS],
    isShowResult: false
})

// 是否正在运行代码
const runInfo = reactive<RunResult>({
    isRunning: false,
    execResult: "",
    execMessage: "",
    execTime: 0,
    execMemory: 0
})

// 编辑器信息
const infos = reactive({
    cursor: 0,
    length: 0,
    lines: 0
})

// 导航信息
const navInfo = reactive<NavigationProps>({
    active: "test-case",
    items: [
        {
            name: "test-case",
            label: "测试用例"
        },
        {
            name: "test-case-result",
            label: "测试结果"
        }
    ]
})

// 用户代码提交的信息
const commitInfo = ref({
    code: `console.log('Hello, world!') \n dwadad`,
    lang: "javascript"
})

/**
 * @description 初始化
 * @param payload
 */
const handleReady = (payload) => {
    view.value = payload.state
    console.log(view.value)
}

/**
 * @description 书写代码
 * @param value
 * @param payload
 */
const handleChange = (value, payload) => {
    view.value = payload.state
}

/**
 * @description 切换语言
 * @param e
 */
const switchLang = (e: InputEventDefinition) => {
    editorConfig.extensions = [
        LANG_MAP_EDITOR[e.target.value],
        ...DEFAULT_EXTENSIONS
    ]
    commitInfo.value.lang = e.target.value
}

/**
 * @description 显示运行结果
 */
const showRunResult = () => {
    editorConfig.isShowResult = !editorConfig.isShowResult
}

watch(
    () => view,
    (newVal: Ref<EditorState>) => {
        const state = newVal.value
        const ranges = state.selection.ranges
        infos.cursor = ranges[0].anchor
        infos.length = state.doc.length
        infos.lines = state.doc.lines
    },
    {
        deep: true
    }
)

const handleClick = () => {
    visible.value = true
}
const handleBeforeOk = async () => {
    await new Promise((resolve) => setTimeout(resolve, 3000))
    return true
}
const handleCancel = () => {
    visible.value = false
}

/**
 * @description 运行代码
 */
const run = () => {
    editorConfig.isShowResult = true
    runInfo.isRunning = true
    setTimeout(() => {
        runInfo.isRunning = false
    }, 3000)
}
</script>

<template>
    <div
        class="lang-editor flex flex-col text-[#fff] text-[13px] h-[calc(100vh-60px)]"
    >
        <nav class="h-[40px] flex items-center bg-[#22272e]">
            <div class="item ml-[10px]">
                <label for="lang">语言：</label>
                <select
                    id="lang"
                    class="border-[1px] rounded-[5px] text-[#adbabd] bg-transparent"
                    @change="switchLang"
                >
                    <option
                        v-for="lang in Object.keys(LANG_MAP_EDITOR)"
                        :key="lang"
                        :value="lang"
                    >
                        {{ lang }}
                    </option>
                </select>
            </div>
            <a-button
                class="reset ml-[10px]"
                size="small"
                type="primary"
                @click="handleClick"
            >
                重新开始
            </a-button>
            <a-modal
                v-model:visible="visible"
                @cancel="handleCancel"
                :on-before-ok="handleBeforeOk"
                ok-text="确定"
                cancel-text="取消"
                unmountOnClose
            >
                <template #title>是否重置代码</template>
                <div>
                    点击确定将删除您之前<b>所做题目记录</b
                    ><br />（仅限于当前题目的当前所选语言，对该题下的其他语言暂无影响）
                </div>
            </a-modal>
        </nav>
        <main
            class="flex-1 overflow-x-hidden overflow-y-scroll hide-scrollbar bg-[#282c34]"
        >
            <codemirror
                v-model="commitInfo.code"
                :placeholder="editorConfig.placeholder"
                :autofocus="editorConfig.autofocus"
                :indent-with-tab="editorConfig.indentTabSize"
                :tab-size="editorConfig.tabSize"
                :extensions="editorConfig.extensions"
                class="hide-scrollbar"
                @ready="handleReady"
                @change="handleChange"
            />
        </main>
        <aside class="relative cur-state text-white h-[85px]">
            <div class="z-10 absolute bottom-0 left-0 w-full">
                <div
                    class="flex items-center justify-between running bg-[#2a313d] px-[10px] py-[5px] h-[45px]"
                >
                    <b class="cursor-pointer" @click="showRunResult">
                        {{
                            editorConfig.isShowResult ? "隐藏示例" : "查看示例"
                        }}
                    </b>
                    <a-button
                        size="small"
                        type="primary"
                        @click="run"
                        :loading="runInfo.isRunning"
                    >
                        运行
                    </a-button>
                </div>
                <div
                    class="infos text-[13px] bg-[#22272e] flex items-center h-[40px]"
                >
                    <span class="item ml-[20px]">
                        总长度: {{ infos.length }}
                    </span>
                    <span class="item ml-[20px]">
                        行数: {{ infos.lines }}
                    </span>
                    <span class="item ml-[20px]">
                        光标: {{ infos.cursor }}
                    </span>
                </div>
            </div>
            <div
                class="result absolute overflow-hidden max-h-[200px] overflow-y-scroll hide-scrollbar top-0 left-0 w-full rounded-t-[8px] bg-[#222326] border-[1px] border-[#22272e] transition-all shadow-lg"
                :class="{
                    '-translate-y-full': editorConfig.isShowResult
                }"
            >
                <div
                    class="z-[9] sticky top-0 left-0 top h-[45px] bg-[#222326] w-full flex items-center justify-between text-[13px] px-[10px] border-b-[1px] border-[#0d1117]"
                >
                    <div class="nav">
                        <div class="flex space-x-2">
                            <a
                                v-for="item in navInfo.items"
                                :key="item.name"
                                :href="`#${item.name}`"
                                class="text-white rounded-md px-3 py-2 text-sm font-medium"
                                :class="
                                    navInfo.active === item.name
                                        ? 'bg-gray-900'
                                        : 'text-gray-300 hover:bg-gray-700 hover:text-white'
                                "
                                @click="navInfo.active = item.name"
                            >
                                {{ item.label }}
                            </a>
                        </div>
                    </div>
                    <i
                        class="iconfont icon-result-open cursor-pointer"
                        @click="editorConfig.isShowResult = false"
                    ></i>
                </div>
                <k-skeleton
                    :loading="runInfo.isRunning"
                    animated
                    :throttle="200"
                >
                    <template #template>
                        <k-skeleton-item animated variant="text" :rows="3" />
                    </template>
                    <template #default>
                        <div
                            class="show-data-area flex items-center min-h-[45px]"
                        >
                            暂无数据
                        </div>
                    </template>
                </k-skeleton>
            </div>
        </aside>
    </div>
</template>

<style scoped lang="scss"></style>
