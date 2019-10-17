package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationsV2 {

    @Test
    public void testPermute() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result= permute(nums);
        for (List<Integer> item : result) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(list, nums, 0, nums.length);
        return list;
    }

    public void solve(List<List<Integer>> list, int[] nums, int k, int length) {
        if (k >= length) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                subList.add(nums[i]);
            }
            list.add(subList);
            return;
        }

        for (int i = k; i < length; i++) {
            swap(nums, i, k);
            solve(list, nums, k + 1, length);
            swap(nums, k, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
