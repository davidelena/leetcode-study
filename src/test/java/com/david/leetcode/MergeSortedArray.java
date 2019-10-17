package com.david.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2. Example:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * @author Administrator
 *
 */
public class MergeSortedArray {

	@Test
	public void testMerge() {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
		System.out.println("resultArr=" + Arrays.toString(nums1));
	}

	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int[] mergeArr = new int[m + n];
		int i = 0; // first array pointer
		int j = 0; // second array pointer
		int index = 0; // merge array pointer
		while (i < m && j < n) {

			// Pay attention to the details which i<m must be put on the first judge
			// condtion. It could occur the arrayOutOfIndex exception if we didn't do that.

			while (i < m && nums1[i] <= nums2[j]) {
				mergeArr[index++] = nums1[i++];
			}
			while (j < n && nums2[j] <= nums1[i]) {
				mergeArr[index++] = nums2[j++];
			}
		}

		// merge unsorted elements into merge array
		while (i < m) {
			mergeArr[index++] = nums1[i++];
		}
		while (j < n) {
			mergeArr[index++] = nums2[j++];
		}
		// This problem needs us to merge the final result into the first given array
		// such as num1 in this case.
		System.arraycopy(mergeArr, 0, nums1, 0, mergeArr.length);
		return mergeArr;
	}

}
