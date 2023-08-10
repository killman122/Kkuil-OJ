<script setup lang="ts">
import { defineProps } from "vue"
import type { KSkeletonItemProps } from "@/components/KSkeleton/k-skeleton"

const props: KSkeletonItemProps = withDefaults<KSkeletonItemProps>(
    defineProps<KSkeletonItemProps>(),
    {
        variant: "text",
        animated: false,
        rows: 1
    }
)
</script>

<template>
    <div
        class="k-skeleton-item"
        v-for="row in rows"
        :key="row"
        :class="`${variant} ${animated ? 'animated' : ''}`"
    ></div>
</template>

<style scoped lang="scss">
.text {
    height: 25px;
    border-radius: 5px;
}

.rect {
    width: 135px;
    height: 135px;
    border-radius: 15px;
}

.circle {
    height: 135px;
    width: 135px;
    border-radius: 135px;
}

.animated {
    &::before {
        content: "";
        display: block;
        position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        height: inherit;
        background: linear-gradient(
            to right,
            #f2f2f2 0%,
            #e6e6e6 50%,
            #f2f2f2 100%
        );
        animation: animated 2s infinite;
    }
}

@keyframes animated {
    0% {
        background-position: -200px 0;
    }
    100% {
        background-position: 200px 0;
    }
}

.k-skeleton-item {
    position: relative;
    margin: 10px 0;
    overflow: hidden;
}
</style>
