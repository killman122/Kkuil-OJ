// 仓库的类型定义
declare namespace Store {
    //  用户仓库
    declare namespace UserStore {
        type UserInfo = {
            id: number | null
            username: string | null
            role: string | null
            token: string | null
        }
    }
    declare namespace QuestionStore {
        type QuestionInfo = {
            id: string
            key: string
            title: string
            description: string
            difficulty: number
            required: string
        }
    }
}
