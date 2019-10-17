package com.david.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps
 * 
 * @author Administrator
 *
 */
public class ClimbingStairs {

	@Test
	public void testClimbStairs() {
		System.out.println(climbStairsV3(5));
	}

	public int climbStairs(int n) {
		return climb_Stairs(0, n);
	}

	public int climb_Stairs(int i, int n) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
	}

	public int climbStairsV2(int n) {
		int memo[] = new int[n + 1];
		return climb_StairsV2(0, n, memo);
	}

	public int climb_StairsV2(int i, int n, int memo[]) {
		System.out.println("i=" + i + ", memo=" + Arrays.toString(memo));
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		if (memo[i] > 0) {
			return memo[i];
		}
		memo[i] = climb_StairsV2(i + 1, n, memo) + climb_StairsV2(i + 2, n, memo);
		return memo[i];
	}

	public int climbStairsV3(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
