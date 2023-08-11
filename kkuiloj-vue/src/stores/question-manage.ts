import { defineStore } from "pinia"
import { addQuestion, listQuestionDifficulty } from "@/api/question-manage"
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
        async addQuestion(payload: AddQuestionProps) {
            const result: GlobalType.Result<boolean> = await addQuestion(
                payload
            )
            if (result.data) {
                MessageUtil.success(result.message)
            }
            MessageUtil.error(result.message)
        },
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
