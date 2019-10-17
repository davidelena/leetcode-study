package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Stack;

public class FindPeakElement {

    @Test
    public void testFindPeakElement() {
        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = new int[]{1, 2, 3};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement(nums2));
        System.out.println(findPeakElement(nums3));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[1] > nums[0] ? 1 : 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int peak = stack.peek();
            if (peak < nums[i]) {
                stack.push(nums[i]);
            } else {
                return i - 1;
            }
        }
        return stack.size() - 1;
    }
}
