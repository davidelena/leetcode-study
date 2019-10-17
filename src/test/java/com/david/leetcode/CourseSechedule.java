package com.david.leetcode;

import java.util.*;

public class CourseSechedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int courseTaken = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            courseTaken++;
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

        return courseTaken == numCourses;
    }
}
