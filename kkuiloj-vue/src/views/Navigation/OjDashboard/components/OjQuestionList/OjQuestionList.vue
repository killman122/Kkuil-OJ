<script setup lang="ts">
import moment from "moment"
import { useRouter } from "vue-router"
import { reactive } from "vue"

const $router = useRouter()

const pageInfo = reactive({
    current: 1,
    pageSize: 10
})

const list = [
    {
        id: 1,
        cn_name: "两数之和",
        en_name: "Two Sum",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://static.leetcode.cn/cn-mono-assets/production/assets/logo-light-cn.7c8374e7.svg",
        question_source_link: "https://leetcode-cn.com/problems/two-sum/",
        post_count: 100,
        pass_rate: 0.5,
        post_time: "2021-10-01 00:00:00"
    },
    {
        id: 2,
        cn_name: "无重复字符的最长子串",
        en_name: "Longest Substring Without Repeating Characters",
        difficulty: 2,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/",
        post_count: 200,
        pass_rate: 0.6,
        post_time: "2021-10-02 00:00:00"
    },
    {
        id: 3,
        cn_name: "整数反转",
        en_name: "Reverse Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/reverse-integer/",
        post_count: 150,
        pass_rate: 0.7,
        post_time: "2021-10-03 00:00:00"
    },
    {
        id: 4,
        cn_name: "回文数",
        en_name: "Palindrome Number",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/palindrome-number/",
        post_count: 120,
        pass_rate: 0.8,
        post_time: "2021-10-04 00:00:00"
    },
    {
        id: 5,
        cn_name: "盛最多水的容器",
        en_name: "Container With Most Water",
        difficulty: 2,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/container-with-most-water/",
        post_count: 180,
        pass_rate: 0.9,
        post_time: "2021-10-05 00:00:00"
    },
    {
        id: 6,
        cn_name: "整数转罗马数字",
        en_name: "Integer to Roman",
        difficulty: 2,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/integer-to-roman/",
        post_count: 90,
        pass_rate: 0.7,
        post_time: "2021-10-06 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    },
    {
        id: 7,
        cn_name: "罗马数字转整数",
        en_name: "Roman to Integer",
        difficulty: 1,
        question_source: "LeetCode",
        question_icon:
            "https://assets.leetcode-cn.com/aliyun-lc-upload/assets/static/og-default.png",
        question_source_link:
            "https://leetcode-cn.com/problems/roman-to-integer/",
        post_count: 80,
        pass_rate: 0.6,
        post_time: "2021-10-07 00:00:00"
    }
]

const gotoQuestionDetail = (e: Event) => {
    $router.push(`/online-judge/${e.target.dataset.id}`)
}
</script>

<template>
    <div class="question-list">
        <ul
            role="list"
            class="divide-y divide-gray-100"
            @click="gotoQuestionDetail"
        >
            <li
                v-for="question in list"
                :key="question.id"
                class="flex justify-between gap-x-6 py-5 cursor-pointer hover:bg-gray-50"
                :title="question.cn_name"
                :data-id="question.id"
            >
                <div class="flex min-w-0 gap-x-4 pointer-events-none">
                    <img
                        class="h-12 w-12 flex-none rounded-full bg-black"
                        :src="question.question_icon"
                        :alt="question.question_source"
                    />
                    <div class="min-w-0 flex-auto">
                        <p
                            class="text-sm font-semibold leading-6 text-gray-900"
                        >
                            {{ question.cn_name }}
                        </p>
                        <p
                            class="mt-1 truncate text-xs leading-5 text-gray-500"
                        >
                            <span class="post-count">
                                总调用次数：
                                <b class="text-[#0094ff]">
                                    {{ question.post_count }}
                                </b>
                            </span>
                            <span class="pass-rate ml-[10px]">
                                通过率：
                                <b class="text-[#0094ff]">
                                    {{ question.pass_rate * 100 }} %
                                </b>
                            </span>
                        </p>
                    </div>
                </div>
                <div class="hidden shrink-0 sm:flex sm:flex-col sm:items-end">
                    <p class="text-sm leading-6 text-gray-900">
                        来源：{{ question.question_source }}
                    </p>
                    <p
                        v-if="question.post_time"
                        class="mt-1 text-xs leading-5 text-gray-500"
                    >
                        上线时间：
                        <time :datetime="question.post_time"
                            >{{
                                moment(question.post_time).format("YYYY-MM-DD")
                            }}
                        </time>
                    </p>
                    <div v-else class="mt-1 flex items-center gap-x-1.5">
                        <div
                            class="flex-none rounded-full bg-emerald-500/20 p-1"
                        >
                            <div
                                class="h-1.5 w-1.5 rounded-full bg-emerald-500"
                            />
                        </div>
                        <p class="text-xs leading-5 text-gray-500">进行中</p>
                    </div>
                </div>
            </li>
        </ul>
        <a-pagination
            :total="list.length"
            :current="pageInfo.current"
            class="flex-center"
            :page-size="pageInfo.pageSize"
        />
    </div>
</template>

<style scoped lang="scss"></style>
