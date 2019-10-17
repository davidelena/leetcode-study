package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.testng.Assert.*;

public class FindKthLargest {

    @Test
    public void testFindKthLargest() {
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        assertEquals(findKthLargest(nums1, 2), 5);
        assertEquals(findKthLargest(nums2, 4), 4);
    }

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        int index = 0;
        int result = 0;
        while (!priorityQueue.isEmpty()) {
            index++;
            result = priorityQueue.poll();
            if (index == k) {
                return result;
            }
        }
        return 0;
    }
}
