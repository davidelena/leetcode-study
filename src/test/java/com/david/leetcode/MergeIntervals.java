package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class MergeIntervals {

    @Test
    public void testMergeIntervals() {
//        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] nums = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        int[][] nums = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] resultArr = merge(nums);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.println(Arrays.toString(resultArr[i]));
        }
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return new int[0][0];
        }
        List<int[]> resultList = new ArrayList<>();
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.getStart(), o2.getStart());
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            queue.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Interval preInterval = null;
        if (!queue.isEmpty()) {
            preInterval = queue.poll();
        }
        Interval current = null;
        resultList.add(new int[]{preInterval.getStart(), preInterval.getEnd()});
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.start <= preInterval.getEnd()) {
                Interval merge = new Interval(preInterval.getStart(), Math.max(preInterval.getEnd(), current.getEnd()));
                resultList.remove(resultList.size() - 1);
                resultList.add(new int[]{merge.getStart(), merge.getEnd()});
                preInterval = merge;
            } else {
                resultList.add(new int[]{current.getStart(), current.getEnd()});
                preInterval = current;
            }
        }
        int[][] resultArr = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    class Interval {
        private int start;
        private int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public Interval(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval [start=" + start + ", end=" + end + "]";
        }

    }

}
