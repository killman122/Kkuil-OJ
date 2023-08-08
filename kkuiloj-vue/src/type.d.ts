declare namespace GlobalType {
    type Result<DataType> = {
        code: number
        message: string
        data: DataType
    }

    // 重新定义 InputEvent 的属性
    interface InputEventDefinition extends InputEvent {
        target: HTMLInputElement
    }
}
