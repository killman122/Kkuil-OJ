<script setup lang="ts">
import { ref } from "vue"
import moment from "moment"
import { useRoute, useRouter } from "vue-router"
import { getQuestionDetail } from "@/api/question"
import QuestionDetailInfo = GlobalType.QuestionDetailInfo

const $route = useRoute()
const $router = useRouter()

// 问题日期格式
const QUESTION_DATE_FORMAT = "YYYY-MM-DD"

// 问题详情
const questionDetail = ref<QuestionDetailInfo>({
    id: "",
    title: "",
    description: "",
    difficulty: 0,
    modifiedTime: "",
    required: ""
})

/**
 * @description  获取问题详情
 */
const getQuestionDesc = async () => {
    const id = $route.params.id as string
    const result = await getQuestionDetail(id)
    if (!result.data) {
        await $router.replace({
            name: "not-found"
        })
    }
    questionDetail.value = result.data
}

getQuestionDesc()
</script>

<template>
    <div
        class="question-desc px-[15px] h-[calc(100vh-60px)] overflow-y-scroll hide-scrollbar"
    >
        <aside class="desc-top border-b-[1px] py-[10px]">
            <h1 class="desc-title font-bold text-[30px] mb-[10px]">
                {{ questionDetail.title }}
            </h1>
            <h2 class="text-[#ccc] text-[13px]">
                <span class="last-modified">
                    最后修改于:{{
                        moment(questionDetail.modifiedTime).format(
                            QUESTION_DATE_FORMAT
                        )
                    }}
                </span>
                <span class="question-difficulty">
                    难度: {{ questionDetail.difficulty }}
                </span>
            </h2>
        </aside>
        <main class="desc-main py-[10px]">
            <p class="text-[16px] leading-[30px]">
                {{ questionDetail.description }}
            </p>
        </main>
    </div>
</template>

<style scoped lang="scss"></style>
