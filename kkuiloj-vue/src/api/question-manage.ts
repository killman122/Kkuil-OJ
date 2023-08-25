import request from "@/utils/request"
import type { AddQuestionProps } from "@/views/Navigation/OjQuestionManage/question-manage"

/**
 * @description: 获取题目列表
 * @param data 新增题目信息
 */
export const addQuestion = (
    data: AddQuestionProps
): Promise<GlobalType.Result<boolean>> => {
    return request({
        url: "/question/add",
        method: "POST",
        data
    })
}

/**
 * @description: 获取题目列表
 * @param params 分页查询参数
 */
export const listQuestion = (
    params: GlobalType.TPageParams<string>
): Promise<
    GlobalType.Result<
        GlobalType.TPageParams<Store.QuestionStore.QuestionInfo[]>
    >
> => {
    return request({
        url: "/question/list",
        method: "GET",
        params: {
            current: params.current,
            pageSize: params.pageSize,
            id: params.data
        }
    })
}

/**
 * @description: 获取题目难度列表
 */
export const listQuestionDifficulty = (): Promise<
    GlobalType.Result<Request.Question.Difficulty[]>
> => {
    return request({
        url: "/question/difficulty/list",
        method: "GET"
    })
}
