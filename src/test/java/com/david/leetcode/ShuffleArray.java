package com.david.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ShuffleArray {

	@Test
	public void testSolution() {
		int[] nums = new int[] { 1, 3, 2 };
		SolutionV2 solution = new SolutionV2(nums);
		for (int i = 0; i < 5; i++) {
			int[] resultArr = solution.shuffle();
			System.out.println("i=" + i + ", shuffleArr=" + Arrays.toString(resultArr));
			resultArr = solution.reset();
			System.out.println("i=" + i + ", reset=" + Arrays.toString(resultArr));
		}
	}
	
	@Test
	public void testRandRange() {
		for (int i = 0; i < 100; i++) {
			System.out.println(randRange(i, 100));
		}
	}
	
    private int randRange(int min, int max) {
    	Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }
}

class SolutionV2 {

	private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public SolutionV2(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}

class Solution {

	private int[] nums;
	private int[] resultArr;

	public Solution(int[] nums) {
		this.nums = nums;
		this.resultArr = new int[this.nums.length];
		System.arraycopy(nums, 0, resultArr, 0, nums.length);
		nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return this.resultArr;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		List<List<Integer>> resultList = getPermutation();
		Random rand = new Random();
		int index = rand.nextInt(resultList.size());
		List<Integer> list = resultList.get(index);
		int[] resultArr = new int[list.size()];
		for (int i = 0; i < resultArr.length; i++) {
			resultArr[i] = list.get(i);
		}
		return resultArr;
	}

	public List<List<Integer>> getPermutation() {
		List<List<Integer>> list = new ArrayList<>();
		solve(list, nums, 0, nums.length);
		return list;
	}

	public void solve(List<List<Integer>> list, int[] nums, int k, int length) {
		if (k == length) {
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