package com.david.leetcode;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class PowerOfThree {

	@Test
	public void testPowerOfThree() {
		assertTrue(isPowerOfThree(27));
		assertFalse(isPowerOfThree(0));
		assertTrue(isPowerOfThree(9));
		assertFalse(isPowerOfThreeV2(45));
	}

	public boolean isPowerOfThree(int n) {
		if (n < 1) {
			return false;
		}

		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}
	
    public boolean isPowerOfThreeV2(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

}
