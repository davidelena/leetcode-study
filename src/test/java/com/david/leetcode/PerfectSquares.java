package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Map;

public class PerfectSquares {

    @Test
    public void testNumSquares() {
        System.out.println(numSquares(13));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
