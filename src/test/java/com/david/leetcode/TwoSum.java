package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Issue 1 
 * 
 * Given an array of integers, return indices of the two numbers such
 * that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * @author Administrator
 *
 */
public class TwoSum {

	@Test
	public void testTwoSum() {
		int[] array = new int[] { 2, 7, 11, 15 };
		int[] resultArr = twoSum(array, 22);
		System.out.println(Arrays.toString(resultArr));
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		return new int[0];
	}

}
