package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    @Test
    public void testPermute() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = permute(nums);
        for (List<Integer> answers : list) {
            System.out.println(answers);
        }
    }

    public List<List<Integer>> permute(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        permute(array, 0, new boolean[array.length], solutions, new ArrayList<>());
        return solutions;
    }

    private void permute(int[] array, int index, boolean[] used, List<List<Integer>> solutions, List<Integer> list) {
        if (index == array.length) {
            solutions.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] == false) {
                list.add(array[i]);
                used[i] = true;
                permute(array, index + 1, used, solutions, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
