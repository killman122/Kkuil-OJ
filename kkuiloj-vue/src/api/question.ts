import request from "@/utils/request"

/**
 * @description: 获取题目详情
 */
export const getQuestionDetail = (
    id: string
): Promise<GlobalType.Result<GlobalType.QuestionDetailInfo>> => {
    return request({
        url: `/question/${id}`,
        method: "GET"
    })
}
