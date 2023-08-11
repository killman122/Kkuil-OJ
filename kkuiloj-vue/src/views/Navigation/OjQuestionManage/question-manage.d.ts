// 列表项定义
export type ColumnProps = {
    id: string
    key: string
    title: string
    description: string
    difficulty: number
    required: string
}

// 新增题目定义
export type AddQuestionProps = {
    title: string
    description: string
    difficulty: number | null
    required: string
}

// 修改题目定义
export type UpdateQuestionProps = {
    title: string
    description: string
    difficulty: number
    required: string
}
