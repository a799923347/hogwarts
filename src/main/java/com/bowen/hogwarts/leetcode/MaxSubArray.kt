package com.bowen.hogwarts.leetcode

import kotlin.math.max

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxSubArray {

    /**
     * 暴力解法，穷举，复杂度O(n^2)
     * 执行用时 :368 ms, 在所有 kotlin 提交中击败了5.13%的用户
     * 内存消耗 :37.9 MB, 在所有 kotlin 提交中击败了37.50%的用户
     */
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in nums.indices) {
            var sum = 0
            for (j in i until nums.size) {
                sum += nums[j]
                if (sum > max) {
                    max = sum
                }
            }
        }
        return max
    }

    /**
     * 分治算法：
     * 当最大子数组有 n 个数字时：
     * 若 n==1，返回此元素。
     * left_sum 为最大子数组前 n/2 个元素，在索引为 (left + right) / 2 的元素属于左子数组。
     * right_sum 为最大子数组的右子数组，为最后 n/2 的元素。
     * cross_sum 是包含左右子数组且含索引 (left + right) / 2 的最大值。
     *
     * 执行用时 :216 ms, 在所有 kotlin 提交中击败了74.36%的用户
     * 内存消耗 :36 MB, 在所有 kotlin 提交中击败了75.00%的用户
     */
    fun maxSubArray2(nums: IntArray): Int {
        return divideConquer(nums, 0, nums.size - 1)
    }

    private fun divideConquer(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) {
            return nums[start]
        }
        val middle = (start + end) / 2
        val leftSum = divideConquer(nums, start, middle)
        val rightSum = divideConquer(nums, middle + 1, end)
        val acrossMiddleSum = acrossMiddleSum(nums, start, middle, end)
        return max(max(leftSum, rightSum), acrossMiddleSum)
    }

    private fun acrossMiddleSum(nums: IntArray, start: Int, middle: Int, end: Int): Int {
        if (start == end) {
            return nums[start]
        }
        var leftMax = Int.MIN_VALUE
        var leftSum = 0
        for (leftPivot in middle downTo start) {
            leftSum += nums[leftPivot]
            leftMax = max(leftMax, leftSum)
        }
        var rightMax = Int.MIN_VALUE
        var rightSum = 0
        for (rightPivot in (middle + 1)..end) {
            rightSum += nums[rightPivot]
            rightMax = max(rightSum, rightMax)
        }
        return leftMax + rightMax
    }
}