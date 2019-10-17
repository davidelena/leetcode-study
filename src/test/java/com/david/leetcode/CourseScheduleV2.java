package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class CourseScheduleV2 {

    @Test
    public void testFindOrder() {
//        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(Arrays.toString(findOrder(2, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++; // calculate indegree num
            if (!adjMap.containsKey(prerequisites[i][1])) {
                adjMap.put(prerequisites[i][1], new ArrayList<>());
            }
            adjMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>(); // add graph node which indegree is 0
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] orderResult = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            orderResult[index++] = current;
            if (adjMap.containsKey(current)) {
                for (Integer adjNode : adjMap.get(current)) {
                    // If we remove the current node, the adjacent node's indegree must be minus 1
                    indegrees[adjNode]--;
                    if (indegrees[adjNode] == 0) {
                        queue.offer(adjNode);
                    }
                }
            }
        }

        return index == numCourses ? orderResult : new int[0];
    }
}
