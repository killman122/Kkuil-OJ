<script setup lang="ts">
import { defineProps, ref, watch, withDefaults } from "vue"
import _ from "lodash"
import type { KSkeletonProps } from "@/components/KSkeleton/k-skeleton"

const props: KSkeletonProps = withDefaults<KSkeletonProps>(
    defineProps<KSkeletonProps>(),
    {
        count: 1,
        loading: false,
        throttle: 200
    }
)

const isLoading = ref<boolean>(false)

watch(
    () => props.loading,
    (val: boolean) => {
        if (props.throttle <= 0) {
            isLoading.value = val
        } else {
            ;(function () {
                _.throttle(() => {
                    isLoading.value = val
                }, props.throttle as number)
            })()
        }
    },
    {
        immediate: true
    }
)
</script>

<template>
    <div class="skeleton">
        <div
            class="template"
            v-for="item in count"
            :key="item"
            v-show="isLoading"
        >
            <slot name="template"></slot>
        </div>
        <div class="default" v-show="!isLoading">
            <slot name="default"></slot>
        </div>
    </div>
</template>

<style scoped lang="scss">
.skeleton {
    padding: 10px 15px;
}
</style>
