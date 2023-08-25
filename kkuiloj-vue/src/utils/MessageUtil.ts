import type { MessageConfig } from "@arco-design/web-vue"
import { Message } from "@arco-design/web-vue"

export const DEFAULT_DURATION = 3000

const DEFAULT_MSG = {
    success: "成功",
    error: "失败",
    warning: "警告",
    info: "提示",
    loading: "加载中"
}

/**
 * @description 成功提示
 * @param config
 */
const success = (config: string | MessageConfig): void => {
    if (config instanceof String) {
        Message.success({
            content: (config as string) ?? DEFAULT_MSG.success,
            duration: DEFAULT_DURATION,
            closable: true
        })
    } else {
        Message.success(config ?? DEFAULT_MSG.success)
    }
}

/**
 * @description 失败提示
 * @param config
 */
const error = (config: string | MessageConfig): void => {
    if (config instanceof String) {
        Message.error({
            content: (config as string) ?? "失败",
            duration: DEFAULT_DURATION,
            closable: true
        })
    } else {
        Message.error(config ?? DEFAULT_MSG.error)
    }
}

/**
 * @description 警告提示
 * @param config
 */
const warning = (config: string | MessageConfig): void => {
    if (config instanceof String) {
        Message.warning({
            content: (config as string) ?? "警告",
            duration: DEFAULT_DURATION,
            closable: true
        })
    } else {
        Message.warning(config ?? DEFAULT_MSG.warning)
    }
}

/**
 * @description 信息提示
 * @param config
 */
const info = (config: string | MessageConfig): void => {
    if (config instanceof String) {
        Message.info({
            content: (config as string) ?? "提示",
            duration: DEFAULT_DURATION,
            closable: true
        })
    } else {
        Message.info(config ?? DEFAULT_MSG.info)
    }
}

/**
 * @description 加载提示
 * @param config
 */
const loading = (config: string | MessageConfig): void => {
    if (config instanceof String) {
        Message.loading({
            content: (config as string) ?? "加载中",
            duration: DEFAULT_DURATION,
            closable: true
        })
    } else {
        Message.loading(config ?? DEFAULT_MSG.loading)
    }
}

/**
 * @description 清除提示
 */
const clear = (): void => {
    Message.clear()
}

export default {
    success,
    error,
    warning,
    info,
    loading,
    clear
}
