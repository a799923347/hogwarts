package com.bowen.hogwarts.leetcode

import org.junit.jupiter.api.Test

internal class MaxSubArrayTest {

    @Test
    fun maxSubArray() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val maxSum = MaxSubArray().maxSubArray2(nums)
        println(maxSum)
        assert(maxSum == 6)
    }

    @Test
    fun maxSubArray2() {
        val nums = intArrayOf(-1)
        val maxSum = MaxSubArray().maxSubArray2(nums)
        println(maxSum)
        assert(maxSum == -1)
    }
}