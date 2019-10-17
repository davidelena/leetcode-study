package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SortColors {

    @Test
    public void testSortColors() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        String str = Arrays.toString(nums);
        System.out.println(str);
    }

    public void sortColorsV2(int[] nums) {

        //2 pass using counting sort
        int[] cntArr = new int[3];
        for (int n : nums)
            cntArr[n]++;
        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            int count = cntArr[i];
            for (int j = 0; j < count; j++)
                nums[idx++] = i;
        }
    }

    public void sortColors(int[] nums) {
        nums = qsort(nums, 0, nums.length - 1);
    }

    public static int[] qsort(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) arr = qsort(arr, start, i - 1);
        if (j + 1 < end) arr = qsort(arr, j + 1, end);
        return (arr);
    }
}
