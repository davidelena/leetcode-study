package com.david.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j,
 * k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤
 * N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is
 * guaranteed to be at most 231 - 1.
 * 
 * @author Administrator
 *
 */
public class FourSum {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int cnt = 0;
		int target = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// 两两组合用值做key算出所有的值key组合
		for (int a : A) {
			for (int b : B) {
				map.put(a + b, map.getOrDefault(a + b, 0) + 1);
			}
		}

		// 两两组合算出所有的key组合反向计算，所有的值。
		for (int c : C) {
			for (int d : D) {
				target = 0 - c - d; // cd为负数所以相当于+;
				cnt += map.getOrDefault(target, 0);
			}
		}
		return cnt;
	}
}
