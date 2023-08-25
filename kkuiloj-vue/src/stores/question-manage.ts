import { defineStore } from "pinia"
import {
    addQuestion,
    listQuestion,
    listQuestionDifficulty
} from "@/api/question-manage"
import type { AddQuestionProps } from "@/views/Navigation/OjQuestionManage/question-manage"
import MessageUtil from "@/utils/MessageUtil"

export const useQuestionStore = defineStore("question-manage", {
    state(): {
        list: Store.QuestionStore.QuestionInfo[]
        difficultyList: Request.Question.Difficulty[]
    } {
        return {
            list: [],
            difficultyList: []
        }
    },
    actions: {
        // 获取题目列表
        async getQuestionList(
            payload: GlobalType.TPageParams<string>
        ): Promise<
            | GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
            | NonNullable<unknown>
        > {
            const result: GlobalType.Result<
                GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
            > = await listQuestion(payload)
            if (result.data) {
                this.list = result.data.data
                return result.data
            }
            return {}
        },
        // 增加题目
        async addQuestion(payload: AddQuestionProps) {
            const result: GlobalType.Result<boolean> = await addQuestion(
                payload
            )
            if (result.data) {
                MessageUtil.success(result.message)
            }
            MessageUtil.error(result.message)
        },
        //   获取题目难度列表
        async getQuestionDifficultyList() {
            const result: GlobalType.Result<Request.Question.Difficulty[]> =
                await listQuestionDifficulty()
            if (result.data) {
                console.log(result.data)
                this.difficultyList = result.data
            }
        }
    }
})
