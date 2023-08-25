module.exports = {
    root: true,
    env: {
        node: true,
        es6: true
    },
    extends: [
        "plugin:vue/vue3-essential",
        "eslint:recommended",
        "@vue/typescript/recommended",
        "plugin:prettier/recommended"
    ],
    settings: {
        "import/resolver": {
            alias: {
                map: [["@", "./src"]],
                extensions: [".js", ".jsx", ".json", ".vue", ".ts"]
            }
        }
    },
    parserOptions: {
        ecmaVersion: 2020
    },
    rules: {
        "no-console": process.env.NODE_ENV === "production" ? "error" : "off",
        "no-debugger": process.env.NODE_ENV === "production" ? "error" : "off"
    }
}
