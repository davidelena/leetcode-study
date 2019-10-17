package com.david.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * 就地操作数组这样直接能修改引用影响到length
 * 
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * 
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means modification
 * to the input array will be known to the caller as well.
 * 
 * Topic: Two Pointers
 * 
 * Internally you can think of this:
 * 
 * @author Administrator
 *
 */
public class RemoveDuplicates {

	@Test
	public void testRemoveDuplicates() {
		int[] nums = new int[] { 1, 1, 1, 3, 3, 4, 5, 6, 6 };
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * Since the array is already sorted, we can keep two pointers ii and jj, where
	 * ii is the slow-runner while jj is the fast-runner. As long as nums[i] =
	 * nums[j]nums[i]=nums[j], we increment jj to skip the duplicate. When we
	 * encounter nums[j] \neq nums[i]nums[j] =nums[i], the duplicate run has ended
	 * so we must copy its value to nums[i + 1]nums[i+1]. ii is then incremented and
	 * we repeat the same process again until jj reaches the end of array.
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				nums[++i] = nums[j];
			}
		}
		return i + 1;
	}
}
