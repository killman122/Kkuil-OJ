<script setup lang="ts">
import { Codemirror } from "vue-codemirror"
import { reactive, Ref, ref, watch } from "vue"
import { javascript } from "@codemirror/lang-javascript"
import { java } from "@codemirror/lang-java"
import { oneDark } from "@codemirror/theme-one-dark"
import type { EditorState } from "@codemirror/state"

// 语言映射
const LANG_MAP_EDITOR = {
    javascript: javascript(),
    java: java()
}
const DEFAULT_EXTENSIONS = [oneDark]
const view: Ref<EditorState | undefined> = ref<EditorState>()
// 编辑器配置
const editorConfig = reactive({
    tabSize: 4,
    autofocus: true,
    indentTabSize: true,
    placeholder: "请开始你的答题......",
    extensions: [javascript(), ...DEFAULT_EXTENSIONS]
})
// 编辑器信息
const infos = reactive({
    cursor: 0,
    length: 0,
    lines: 0
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
 * @param state
 */
const handleChange = (value, payload) => {
    view.value = payload.state
}

/**
 * @description 切换语言
 * @param e
 */
const switchLang = (e: Event) => {
    editorConfig.extensions = [
        LANG_MAP_EDITOR[e.target.value],
        ...DEFAULT_EXTENSIONS
    ]
    commitInfo.value.lang = e.target.value
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
</script>

<template>
    <div class="lang-editor flex flex-col" style="height: calc(100vh - 60px)">
        <nav
            class="h-[40px] flex items-center bg-[#22272e] text-[#fff] text-[13px]"
        >
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
        </nav>
        <main class="flex-1 overflow-y-scroll hide-scrollbar bg-[#282c34]">
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
        <aside
            class="cur-state w-full bg-[#22272e] text-white flex items-center p-[10px]"
        >
            <div class="infos text-[13px]">
                <span class="item ml-[20px]"> 总长度: {{ infos.length }} </span>
                <span class="item ml-[20px]"> 行数: {{ infos.lines }} </span>
                <span class="item ml-[20px]"> 光标: {{ infos.cursor }} </span>
            </div>
        </aside>
    </div>
</template>

<style scoped lang="scss"></style>
