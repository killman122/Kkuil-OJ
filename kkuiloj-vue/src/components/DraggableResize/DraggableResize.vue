<script generic="T extends Number,String" setup lang="ts">
import {
    computed,
    defineProps,
    nextTick,
    onBeforeUnmount,
    onMounted,
    ref
} from "vue"
import { minScale } from "@arco-design/web-vue/es/image/utils/get-scale"

const DEFAULT_MIN_SCALE = 0.1

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
        // 最小比例(最小为0.1)
        minScale: number
        // 当达到最小比例时，显示还是隐藏元素(true-显示，false-隐藏)
        isShowInMinScale: boolean
    }>
>()

// 分割线元素
const splitLineRef = ref<HTMLDivElement>()
// 父元素
const draggableRef = ref<HTMLDivElement>()
// 左盒子
const leftRef = ref<HTMLDivElement>()
// 右盒子
const rightRef = ref<HTMLDivElement>()

// 当前分割线的位置
const splitLinePos = ref<string | number>()
// 是否拖动过
const isDragged = ref(false)

// 处理默认缩放比例
const computedDefaultScale = computed(() => {
    if (props.defaultScale <= 0 || props.defaultScale > 1) {
        return 0.5
    }
    return props.defaultScale
})

// 计算分割线缩放比例
const computedSplitLineScale = computed(() => {
    return (
        splitLinePos.value / draggableRef.value?.getBoundingClientRect().width
    )
})

// 当前最小比例
const computedMinScale = computed(() =>
    minScale && minScale > 0.1 ? minScale : DEFAULT_MIN_SCALE
)

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
 * @description 最小尺寸处理器
 */
function minScaleHandler() {
    if (computedSplitLineScale.value < computedMinScale.value) {
        if (props.isShowInMinScale) {
            splitLinePos.value =
                draggableRef.value?.getBoundingClientRect().width *
                    computedMinScale.value +
                splitLineRef.value?.getBoundingClientRect().width / 2
        } else {
            if ("style" in leftRef.value) {
                splitLinePos.value = 0
                leftRef.value.style.display = "none"
            }
        }
    }
    if (computedSplitLineScale.value > 1 - computedMinScale.value) {
        if (props.isShowInMinScale) {
            splitLinePos.value =
                draggableRef.value?.getBoundingClientRect().width *
                    (1 - computedMinScale.value) -
                splitLineRef.value?.getBoundingClientRect().width / 2
        } else {
            if ("style" in rightRef.value) {
                splitLinePos.value =
                    draggableRef.value?.getBoundingClientRect().width -
                    splitLineRef.value?.getBoundingClientRect().width
                rightRef.value.style.display = "none"
            }
        }
    }
    console.log(rightRef.value.style.display)
}

/**
 * @description 显示盒子
 */
function showBox() {
    if ("style" in leftRef.value) {
        leftRef.value.style.display = "block"
    }
    if ("style" in rightRef.value) {
        rightRef.value.style.display = "block"
    }
}

// 监听器
const listeners = {
    ondrag: (e: DragEvent) => {
        showBox()
        splitLinePos.value = e.clientX
        isDragged.value = true
        nextTick(minScaleHandler)
    },
    ondragEnd: (e: DragEvent) => {
        showBox()
        splitLinePos.value = e.clientX
        nextTick(minScaleHandler)
    },
    onresize: () => {
        splitLinePos.value =
            leftRef.value?.getBoundingClientRect().width -
            splitLineRef.value?.getBoundingClientRect().width / 2
        if (!computedSplitLineScale.value) {
            return (splitLinePos.value = 0)
        }
        console.log(computedSplitLineScale.value)
        if (computedSplitLineScale.value > 1 - computedMinScale.value) {
            return (splitLinePos.value =
                draggableRef.value?.getBoundingClientRect().width -
                splitLineRef.value?.getBoundingClientRect().width)
        }
    }
}

/**
 *  @description 分割线拖动事件监听器
 */
const splitLineListener = () => {
    if ("ondrag" in splitLineRef.value) {
        splitLineRef.value.ondrag = listeners.ondrag
    }
    if ("ondragend" in splitLineRef.value) {
        splitLineRef.value.ondragend = listeners.ondragEnd
    }
}

/**
 *  @description 父元素尺寸变化监听器
 */
const parentResizeListener = () => {
    document.body.onresize = listeners.onresize
}

onMounted(() => {
    // 分割线拖动事件监听器
    splitLineListener()
    // 初始化分割线位置
    initSplitLinePos()
    // 父元素尺寸变化监听器
    parentResizeListener()
})

onBeforeUnmount(() => {
    document.body.onresize = null
    if ("ondrag" in splitLineRef.value) {
        splitLineRef.value.ondrag = null
    }
    if ("ondragend" in splitLineRef.value) {
        splitLineRef.value.ondragend = null
    }
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
            ref="leftRef"
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
            ref="rightRef"
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
        z-index: 99;
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

            &::before {
                display: block;
            }
        }

        &::before {
            content: "";
            display: none;
            width: 3px;
            height: 30px;
            background-color: #777;
            border-radius: 1px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    }
}
</style>
