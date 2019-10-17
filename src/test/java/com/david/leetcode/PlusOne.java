package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * 注意9+1编程[1,0]这种情况，首尾不能为0 使用pow注意超过Integer.MAX_VALUE
 * 
 * Topic Array
 * 
 * @author Administrator
 * 
 * 
 *
 */
public class PlusOne {

	@Test
	public void testPlusOne() {
		int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] arr = plusOne(nums);
		System.out.println(Arrays.toString(arr));

	}

	public int[] plusOne(int[] digits) {
		long num = 0;
		for (int i = 0; i < digits.length; i++) {
			num += digits[i] * Math.pow(10, digits.length - 1 - i);
		}
		num++;
		long[] resultArr = new long[String.valueOf(num).length()];
		int index = 0;
		long divisor = num;
		long dividend = 0;
		do {
			dividend = divisor % 10;
			divisor /= 10;
			resultArr[resultArr.length - 1 - index] = dividend;
			index++;
		} while (divisor > 0 && index < resultArr.length);
		int[] destArr = new int[resultArr.length];
		for (int i = 0; i < resultArr.length; i++) {
			destArr[i] = (int) resultArr[i];
		}
		return destArr;
	}
}
