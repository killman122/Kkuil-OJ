// 骨架屏的类型定义
export type KSkeletonProps = Partial<{
    count: number
    loading: boolean
    throttle: number
}>

// 骨架屏的子元素的类型定义
export type KSkeletonItemProps = Partial<{
    animated: boolean
    variant: "text" | "circle" | "rect"
    rows: number
}>
