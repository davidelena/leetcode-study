package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    @Test
    public void testThreeSum() {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{0, -4, -1, -4, -2, -3, 2};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> item : list) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<>();
        Map<String, List<Integer>> rsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            if (i == 0) {
                left++;
            }
            if (i == nums.length - 1) {
                right--;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> tempList = Arrays.asList(new Integer[]{nums[left], nums[i], nums[right]});
                    Collections.sort(tempList);
                    if (!rsMap.containsKey(tempList.toString())) {
                        rsMap.put(tempList.toString(), tempList);
                    }
                    left++;
                    right--;
                }
            }
        }
        for (List<Integer> item : rsMap.values()) {
            list.add(item);
        }
        return list;
    }
}
