declare namespace GlobalType {
    type Result<DataType> = {
        code: number
        message: string
        data: DataType
    }
}
