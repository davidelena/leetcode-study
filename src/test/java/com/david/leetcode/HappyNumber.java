package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Issue 202
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Topic: HashMap， Math
 * 
 * Example:
 * 
 * Input: 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * @author Administrator
 *
 */
public class HappyNumber {

	@Test
	public void testHappyHour() {
		System.out.println(isHappy(1111111));
	}

	public boolean isHappy(int n) {
		Set<Integer> hs = new HashSet<Integer>();
		while (!hs.contains(n)) {
			hs.add(n);
			n = getHappyNum(n);
			if (n == 1)
				return true;
		}
		return false;
	}

	public int getHappyNum(int num) {
		int divisor = 0;
		int divided = 0;
		List<Integer> list = new ArrayList<Integer>();
		do {
			divisor = num / 10;
			divided = num % 10;
			list.add(divided);
			num = divisor;
		} while (divisor > 0);

		int result = 0;
		for (Integer item : list) {
			result += (item * item);
		}
		System.out.println("result=" + result);
		return result;
	}
}
