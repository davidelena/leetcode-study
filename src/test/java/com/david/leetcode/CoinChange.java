package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class CoinChange {

    @Test
    public void testCoinChange() {

    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        //存储
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        return coinChangeDFS(coins, amount, memo);
    }

    public int coinChangeDFS(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }
        for (int i = 0; i < coins.length; i++) {
            int coinCount = coinChangeDFS(coins, amount - coins[i], memo);
            if (coinCount >= 0) {
                memo[amount] = Math.min(memo[amount], coinCount + 1);
            }
        }
        memo[amount] = (memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount]);
        return memo[amount];
    }
}
