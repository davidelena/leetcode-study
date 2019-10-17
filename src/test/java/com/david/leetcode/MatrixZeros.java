package com.david.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatrixZeros {

    @Test
    public void testSetZeroes() {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroesV2(matrix);
        showMatrix(matrix);
    }

    public void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void setZeroesV2(int[][] matrix) {
        int negative = -999;
        if (matrix.length == 0 && matrix[0].length == 0) {
            return;
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    //set the current row value which is not zero to a negative value
                    for (int k = 0; k < matrix[row].length; k++) {
                        if (matrix[row][k] != 0) {
                            matrix[row][k] = negative;
                        }
                    }
                    //set the current column value which is not zero to a negative value
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][col] != 0) {
                            matrix[k][col] = negative;
                        }
                    }
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 && matrix[0].length == 0) {
            return;
        }
        Map<Integer, Boolean> rowMap = new HashMap<>();
        Map<Integer, Boolean> columnMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            if (!rowMap.containsKey(i)) {
                rowMap.put(i, false);
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (!columnMap.containsKey(j)) {
                    columnMap.put(j, false);
                }
                if (matrix[i][j] == 0) {
                    rowMap.put(i, true);
                    columnMap.put(j, true);
                }
            }
        }

        for (Map.Entry<Integer, Boolean> rowKV : rowMap.entrySet()) {
            if (rowKV.getValue()) {
                for (int col = 0; col < matrix[rowKV.getKey()].length; col++) {
                    matrix[rowKV.getKey()][col] = 0;
                }
            }
        }

        for (Map.Entry<Integer, Boolean> colKV : columnMap.entrySet()) {
            if (colKV.getValue()) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][colKV.getKey()] = 0;
                }
            }
        }
    }
}
