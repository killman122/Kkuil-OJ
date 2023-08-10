declare namespace GlobalType {
    // 统一返回结果类型
    type Result<DataType> = {
        code: number
        message: string
        data: DataType
    }

    // 重新定义 InputEvent 的属性
    interface InputEventDefinition extends InputEvent {
        target: HTMLInputElement
    }

    // 代码运行结果
    type RunResult = {
        isRunning: boolean
        execResult: string
        execMessage: string
        execTime: number
        execMemory: number
    }
}
