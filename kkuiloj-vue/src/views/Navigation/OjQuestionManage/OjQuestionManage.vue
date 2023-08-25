<script setup lang="ts">
import type { AddQuestionProps } from "@/views/Navigation/OjQuestionManage/question-manage"
import { reactive, ref } from "vue"
import { Codemirror } from "vue-codemirror"
import { oneDark } from "@codemirror/theme-one-dark"
import type { EditorState } from "@codemirror/state"
import { json } from "@codemirror/lang-json"
import { useQuestionStore } from "@/stores/question-manage"
import TPageParams = GlobalType.TPageParams

// 编辑器默认扩展
const DEFAULT_EXTENSIONS = [oneDark]
const view = ref<EditorState>()
// 编辑器配置
const editorConfig = reactive({
    tabSize: 4,
    autofocus: true,
    indentTabSize: true,
    placeholder: "请开始你的答题......",
    extensions: [json(), ...DEFAULT_EXTENSIONS],
    isShowResult: false
})

const questionStore = useQuestionStore()

// 表单配置
const formConfig = {
    rowSelection: {
        type: "checkbox",
        showCheckedAll: true
    }
}

// 搜索信息
const searchInfo = ref<TPageParams<string>>({
    data: "",
    total: 0,
    current: 1,
    pageSize: 10
})

// 新增题目配置
const addQuestionConfig = reactive({
    // 是否显示新增
    isShowAddQuestionDrawer: false,
    // 是否正在提交
    isSubmitting: false
})

// 新增题目的表单项
const addQuestionForm = reactive<AddQuestionProps>({
    title: "",
    description: "",
    difficulty: null,
    required: ""
})

// 生成类型定义
const columns = [
    {
        title: "编号",
        dataIndex: "id"
    },
    {
        title: "题目名",
        dataIndex: "title"
    },
    {
        title: "题目描述",
        dataIndex: "description"
    },
    {
        title: "题目难度",
        dataIndex: "difficulty"
    },
    {
        title: "题目条件",
        dataIndex: "required"
    }
]

// 搜索题目
const handleSearch = async () => {
    const data:
        | GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
        | NonNullable<unknown> = await questionStore.getQuestionList(
        searchInfo.value
    )
    searchInfo.value.total = (
        data as GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
    ).total
}

// 页码发生变化时触发
const handlePageChange = async (page: number) => {
    searchInfo.value.current = page
    await questionStore.getQuestionList(searchInfo.value)
}

// 初始化题目列表
handleSearch()

// 获取题目难度列表
const listDifficulty = async () => {
    await questionStore.getQuestionDifficultyList()
}

// 点击打开新增题目抽屉
const handleOpenAddQuestionDrawer = async () => {
    addQuestionConfig.isShowAddQuestionDrawer = true
    await listDifficulty()
}

// 新增题目
const handleAddQuestion = async () => {
    addQuestionConfig.isSubmitting = true
    await questionStore.addQuestion(addQuestionForm)
    addQuestionConfig.isShowAddQuestionDrawer = false
    addQuestionConfig.isSubmitting = false
}

// 首字母大写
function capitalizeFirstLetter(str) {
    return str.charAt(0).toUpperCase() + str.slice(1)
}

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
</script>

<template>
    <div class="question-manage p-[20px]">
        <div class="top mb-[10px]">
            <a-input-search
                placeholder="请输入你想查看的记录编号"
                search-button
                class="w-[320px]"
                v-model="searchInfo.data"
                @press-enter="handleSearch"
            >
            </a-input-search>
            <a-button
                type="primary"
                class="ml-[10px]"
                @click="handleOpenAddQuestionDrawer"
                >新增
            </a-button>
        </div>
        <a-table
            :columns="columns"
            :data="questionStore.list"
            bordered
            hoverable
            stripe
            show-header
            :row-selection="formConfig.rowSelection"
            column-resizable
            :pagination="searchInfo"
            @page-change="handlePageChange"
        />
        <a-drawer
            closable
            esc-to-close
            :width="550"
            :height="340"
            :visible="addQuestionConfig.isShowAddQuestionDrawer"
            placement="right"
            @ok="handleAddQuestion"
            @cancel="() => (addQuestionConfig.isShowAddQuestionDrawer = false)"
            class="add-question-drawer"
            unmountOnClose
            :ok-loading="addQuestionConfig.isSubmitting"
        >
            <template #title>新增题目</template>
            <a-form :model="addQuestionForm" layout="vertical" class="w-full">
                <a-form-item
                    v-for="item in Object.keys(addQuestionForm)"
                    :key="item"
                    :field="item"
                    :label="capitalizeFirstLetter(item)"
                    required
                >
                    <a-input
                        v-if="item !== 'required' && item !== 'difficulty'"
                        v-model="addQuestionForm[item]"
                        :placeholder="`please enter ${item}...`"
                    />
                    <a-select
                        v-else-if="item === 'difficulty'"
                        v-model="addQuestionForm.difficulty"
                        :style="{ width: '100%' }"
                        placeholder="请选择题目难度"
                        value-key="value"
                    >
                        <a-option
                            v-for="item in questionStore.difficultyList"
                            :key="item.value"
                            :value="item.value"
                            :label="item.name"
                        >
                            {{ item.name }}
                        </a-option>
                    </a-select>
                    <div
                        v-else
                        class="flex-1 overflow-x-hidden overflow-y-scroll hide-scrollbar"
                    >
                        <codemirror
                            v-model="addQuestionForm[item]"
                            :placeholder="editorConfig.placeholder"
                            :autofocus="editorConfig.autofocus"
                            :indent-with-tab="editorConfig.indentTabSize"
                            :tab-size="editorConfig.tabSize"
                            :extensions="editorConfig.extensions"
                            class="hide-scrollbar h-[200px]"
                            @ready="handleReady"
                            @change="handleChange"
                        />
                    </div>
                </a-form-item>
            </a-form>
        </a-drawer>
    </div>
</template>

<style scoped lang="scss"></style>
