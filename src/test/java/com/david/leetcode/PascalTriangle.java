package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Issue 118
 * Topic: Array
 */
public class PascalTriangle {

    @Test
    public void testPascalTriangle() {
        List<List<Integer>> list = generate(5);
        for (List<Integer> item : list) {
            System.out.println("item=" + item);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> triangleList = new ArrayList<List<Integer>>();
        // The first line is always 1
        triangleList.add(Arrays.asList(new Integer[]{1}));

        for (int row = 1; row < numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            List<Integer> prevRowList = triangleList.get(row - 1);
            rowList.add(1);
            for (int el = 1; el < row; el++) {
                int num = prevRowList.get(el - 1) + prevRowList.get(el);
                rowList.add(num);
            }
            rowList.add(1);
            triangleList.add(rowList);
        }

        return triangleList;
    }
}
