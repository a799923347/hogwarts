package com.bowen.hogwarts.leetcode

import kotlin.math.max

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxStockProfit {

    /**
     * 穷举，双重循环，复杂度O(n^2)
     * 执行用时 :716 ms, 在所有 Kotlin 提交中击败了13.33%的用户
     * 内存消耗 :48.8 MB, 在所有 Kotlin 提交中击败了33.33%的用户
     */
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        val size = prices.size
        for (i in 0 until size - 1) {
            for (j in (i + 1) until size) {
                if (prices[j] > prices[i]) {
                    max = max(prices[j] - prices[i], max)
                }
            }
        }
        return max
    }
}