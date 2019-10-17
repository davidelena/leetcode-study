package com.david.leetcode;

import org.testng.annotations.Test;

public class FactorialTraillingZeroes {

    @Test
    public void testTrailingZeroes() {
        System.out.println(calFactorial(10));
        System.out.println(trailingZeroes(10));
    }

    public int calFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
