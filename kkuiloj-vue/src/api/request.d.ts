declare namespace Request {
    declare namespace User {
        type Login = {
            username: string
            password: string
        }
    }
    declare namespace Question {
        type Difficulty = {
            value: string
            name: string
        }
    }
}
