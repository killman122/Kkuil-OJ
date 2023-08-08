<script generic="T extends Number,String" setup lang="ts">
import { computed, defineProps, onMounted, ref } from "vue"

const props = defineProps<
    Partial<{
        //  宽度
        width: T
        //  高度
        height: T
        //  左盒子的类样式
        leftClass: string
        //  右盒子的类样式
        rightClass: string
        //  默认缩放比例
        defaultScale: number
    }>
>()

/**
 *  @description 处理默认缩放比例
 */
const computedDefaultScale = computed(() => {
    if (props.defaultScale <= 0 || props.defaultScale > 1) {
        return 0.5
    }
    return props.defaultScale
})

// 分割线元素
const splitLineRef = ref<HTMLDivElement>()
// 父元素
const draggableRef = ref<HTMLDivElement>()

// 当前分割线的位置
const splitLinePos = ref<string | number>()
const isDragged = ref(false)

onMounted(() => {
    // 处理监听分割线拖动事件
    handlerSplitLineListener()
    // 初始化分割线位置
    initSplitLinePos()
})

/**
 *  @description 处理监听分割线拖动事件
 */
const handlerSplitLineListener = () => {
    splitLineRef.value?.addEventListener<string>("drag", (e: Event) => {
        const event = e as DragEvent
        splitLinePos.value = `${event.clientX}`
        isDragged.value = true
    })
}

/**
 *  @description 初始化分割线位置
 */
const initSplitLinePos = () => {
    splitLinePos.value =
        computedDefaultScale.value *
            draggableRef.value?.getBoundingClientRect().width -
        splitLineRef.value?.getBoundingClientRect().width / 2
}

/**
 * @description 计算分割线缩放比例
 */
const computedSplitLineScale = computed(() => {
    return (
        splitLinePos.value / draggableRef.value?.getBoundingClientRect().width
    )
})
</script>

<template>
    <div
        class="draggable-resize"
        ref="draggableRef"
        :style="{
            width: !width ? '100%' : width,
            height: !height ? '100%' : height
        }"
    >
        <div
            class="left-box"
            :class="leftClass"
            :style="{
                flex: !isDragged ? computedDefaultScale : computedSplitLineScale
            }"
        >
            <slot name="left"></slot>
        </div>
        <div
            class="draggable-split-line"
            ref="splitLineRef"
            :draggable="true"
            :style="{
                transform: `translateX(${splitLinePos}px)`
            }"
        ></div>
        <div
            class="right-box"
            :class="rightClass"
            :style="{
                flex:
                    1 -
                    (!isDragged ? computedDefaultScale : computedSplitLineScale)
            }"
        >
            <slot name="right"></slot>
        </div>
    </div>
</template>

<style scoped lang="scss">
.draggable-resize {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;

    .draggable-split-line {
        z-index: 9999;
        position: absolute;
        top: 0;
        left: 0;
        width: 5px;
        height: 100%;
        background-color: #e0e0e0;
        cursor: col-resize;
        transition: width 0.2s linear;

        &:hover {
            width: 10px;
        }
    }
}
</style>
