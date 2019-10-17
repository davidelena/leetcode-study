package com.david.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> {
    private int[][] adjacMatrix;
    private T[] verticeInfos;
    private boolean[] visitResult;
    private int verticeNum;

    public Graph(int[][] adjacMatrix, T[] verticeInfos) {
        if (adjacMatrix.length != adjacMatrix[0].length) {
            throw new IllegalArgumentException("illegal adjacent matrix parameters");
        }
        if (adjacMatrix.length != verticeInfos.length) {
            throw new IllegalArgumentException("illegal parameters for adjacMatrix or verticeInfos");
        }
        this.adjacMatrix = adjacMatrix;
        this.verticeInfos = verticeInfos;
        verticeNum = verticeInfos.length;
        visitResult = new boolean[verticeNum];
        Arrays.fill(visitResult, false);
    }

    public Queue<T> depthFirstSearch() {
        Queue<T> edges = new LinkedList<>();
        for (int i = 0; i < verticeNum; i++) {
            if (!visitResult[i]) {
                dfs(i, edges);
            }
        }
        return edges;
    }

    private void dfs(int index, Queue<T> edges) {
        visitResult[index] = true;
        edges.offer(verticeInfos[index]);

        for (int j = 0; j < verticeNum; j++) {
            System.out.println("index=" + index + ", j=" + j);
            if (visitResult[j] == false && adjacMatrix[index][j] == 0) {
                dfs(j, edges);
            }
        }
    }

    public static void main(String[] args) {
        String[] vertexs = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[][] adjacMatrix = new int[][]{
                {0, 1, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0}
        };
        Graph<String> graph = new Graph<String>(adjacMatrix, vertexs);
        Queue<String> queue = graph.depthFirstSearch();
        System.out.println(queue);
    }
}
