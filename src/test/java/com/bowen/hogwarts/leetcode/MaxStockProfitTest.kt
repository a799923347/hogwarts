package com.bowen.hogwarts.leetcode

import org.junit.Assert.*

import org.junit.Test

class MaxStockProfitTest {

    @Test
    fun test1() {
        val array = intArrayOf(7, 1, 5, 3, 6, 4)
        val maxProfit = MaxStockProfit().maxProfit2(array)
        println(maxProfit)
        assert(maxProfit == 5)
    }

    @Test
    fun test2() {
        val array = intArrayOf(1, 2)
        val maxProfit = MaxStockProfit().maxProfit2(array)
        println(maxProfit)
        assert(maxProfit == 1)
    }
}