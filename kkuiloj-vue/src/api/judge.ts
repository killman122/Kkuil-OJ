import request from "@/utils/request"

/**
 * @description 提交代码
 * @param codeInfo 代码信息
 */
export const doJudge = (
    codeInfo: GlobalType.CodeCommitInfo
): Promise<GlobalType.Result<GlobalType.RunResult>> => {
    return request({
        url: "/judge/run",
        method: "POST",
        data: codeInfo
    })
}
