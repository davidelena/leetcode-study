package com.david.leetcode;

import org.testng.annotations.Test;

public class MaxProfitV2 {

	@Test
	public void testMaxProfit() {
		int[] nums = new int[] { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(nums);
		System.out.println("result=" + result);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
				maxProfit += (prices[i + 1] - prices[i]);
			}
		}

		return maxProfit;
	}

	/**
	 * 一次循环法比较
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfitV2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
				maxProfit += (prices[i + 1] - prices[i]);
			}
		}

		return maxProfit;
	}
}
