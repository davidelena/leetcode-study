package com.david.leetcode;

import org.testng.annotations.Test;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * @author Administrator
 *
 */
public class MaxProfit {

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
		int minPrice = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			minPrice = Math.min(prices[i], minPrice);
			profit = Math.max(profit, prices[i] - minPrice);
		}

		return profit;
	}

	public int maxProfitV2(int[] prices) {
		int profit = 0;
		if (prices == null || prices.length == 0) {
			return 0;
		}
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] <= prices[i]) {
					continue;
				}
				profit = Math.max(profit, prices[j] - prices[i]);
			}
		}

		return profit;
	}
}
