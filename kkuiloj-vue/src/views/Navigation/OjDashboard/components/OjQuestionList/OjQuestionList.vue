<script setup lang="ts">
import { useRouter } from "vue-router"
import { reactive, ref, watchEffect } from "vue"
import { useQuestionStore } from "@/stores/question-manage"
import InputEventDefinition = GlobalType.InputEventDefinition
import TPageParams = GlobalType.TPageParams
import QuestionInfo = Store.QuestionStore.QuestionInfo

const $router = useRouter()
const questionStore = useQuestionStore()

// 分页信息
const pageInfo = reactive<TPageParams<string>>({
    total: 0,
    current: 1,
    pageSize: 10,
    data: ""
})

// 题目列表
const list = ref<QuestionInfo[]>([
    {
        id: "1",
        title: "题目名称",
        description: "题目描述",
        difficulty: 0,
        required: "样例输出"
    }
])

/**
 *
 * 获取题目列表
 *
 */
const getQuestionList = async () => {
    const data:
        | GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
        | NonNullable<unknown> = await questionStore.getQuestionList(pageInfo)
    pageInfo.total = (
        data as GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
    ).total

    list.value = (
        data as GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
    ).data
}

watchEffect(async () => {
    await getQuestionList()
})

/**
 * 跳转到题目详情页
 * @param e 事件对象
 */
const gotoQuestionDetail = (e: InputEventDefinition) => {
    $router.push(`/online-judge/${e.target.dataset.id}`)
}
</script>

<template>
    <div class="question-list">
        <ul
            role="list"
            class="divide-y divide-gray-100"
            @click="gotoQuestionDetail"
        >
            <li
                v-for="question in list"
                :key="question.id"
                class="cursor-pointer py-5 hover:bg-gray-50"
                :title="question.title"
                :data-id="question.id"
            >
                <div class="flex justify-between gap-x-6 pointer-events-none">
                    <div class="flex min-w-0 gap-x-4">
                        <div class="min-w-0 flex-auto">
                            <h2
                                class="text-sm font-semibold leading-6 text-gray-900"
                            >
                                {{ question.title }}
                            </h2>
                            <p
                                class="description w-full overflow-hidden overflow-ellipsis line-clamp-2"
                            >
                                {{ question.description }}
                            </p>
                        </div>
                    </div>
                    <div
                        class="hidden shrink-0 sm:flex sm:flex-col sm:items-end"
                    >
                        <div class="mt-1 flex items-center gap-x-1.5">
                            <p class="text-xs leading-5 text-gray-500">
                                难度：{{ question.difficulty }}
                            </p>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <a-pagination
            class="flex-center"
            :total="pageInfo.total"
            :current="pageInfo.current"
            :page-size="pageInfo.pageSize"
            @change="(page: number) => (pageInfo.current = page)"
        />
    </div>
</template>

<style scoped lang="scss"></style>
