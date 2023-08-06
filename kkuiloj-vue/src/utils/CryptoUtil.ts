import Crypto from "crypto-js"

/**
 * @description md5加密
 * @param str 需要加密的字符串
 */
const md5 = (str: string) => {
    return Crypto.MD5(str).toString()
}

export default {
    md5
}
