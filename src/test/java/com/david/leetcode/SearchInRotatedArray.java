package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SearchInRotatedArray {


    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int num = nums[0];
        for (int i = 1; i < length; i++) {
            if (num > nums[i]) {
                start = i;
            }
        }
        int[] newArr = new int[nums.length + start];
        System.arraycopy(nums, start, newArr, start, nums.length - start);
        System.arraycopy(nums, 0, newArr, nums.length + start - 1, start);
        System.out.println(Arrays.toString(newArr));
        // generate

        return -1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
//        System.out.println(binarySearch(5, nums, 0, nums.length - 1));
        System.out.println(search(nums, 0));
    }


    public int binarySearch(int target, int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low <= high) {
            if (nums[mid] > target) {
                binarySearch(target, nums, low, mid - 1);
            } else if (nums[mid] < target) {
                binarySearch(target, nums, mid + 1, high);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
