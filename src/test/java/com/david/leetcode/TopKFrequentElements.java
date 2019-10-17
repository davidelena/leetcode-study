package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Issue 347
 * Topic: HashTable & Heap
 */
public class TopKFrequentElements {

    @Test
    public void testTopKFrequent() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> list = topKFrequent(nums, 2);
        System.out.println(list);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], 0);
            }

            freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
        }
        // PriorityQueue is a min-heap as default
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {

                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
        for (Map.Entry<Integer, Integer> item : freqMap.entrySet()) {
            priorityQueue.add(item);
        }

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            if (i >= k) {
                break;
            }
            list.add(priorityQueue.poll().getKey());
            i++;
        }

        return list;
    }
}
