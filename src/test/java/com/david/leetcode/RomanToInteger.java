package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Issue 13
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class RomanToInteger {

	@Test
	public void testRomanToInteger() {
		String str = "IX";
		int result = romanToIntOptimal(str);
		System.out.println(result);
	}

	public int romanToInt(String str) {
		Map<String, Integer> romanMap = new HashMap<String, Integer>();
		romanMap.put("I", 1);
		romanMap.put("V", 5);
		romanMap.put("X", 10);
		romanMap.put("L", 50);
		romanMap.put("C", 100);
		romanMap.put("D", 500);
		romanMap.put("M", 1000);
		romanMap.put("IV", 4);
		romanMap.put("IX", 9);
		romanMap.put("XL", 40);
		romanMap.put("XC", 90);
		romanMap.put("CD", 400);
		romanMap.put("CM", 900);
		romanMap.put("O", 4);
		romanMap.put("P", 9);
		romanMap.put("Q", 40);
		romanMap.put("R", 90);
		romanMap.put("S", 400);
		romanMap.put("T", 900);

		String s = str;
		if (s.contains("IV")) {
			s = s.replace("IV", "O");
		}
		if (s.contains("IX")) {
			s = s.replace("IX", "P");
		}
		if (s.contains("XL")) {
			s = s.replace("XL", "Q");
		}
		if (s.contains("XC")) {
			s = s.replace("XC", "R");
		}
		if (s.contains("CD")) {
			s = s.replace("CD", "S");
		}
		if (s.contains("CM")) {
			s = s.replace("CM", "T");
		}
		int result = 0;
		for (char c : s.toCharArray()) {
			String key = String.valueOf(c);
			result += romanMap.containsKey(key) ? romanMap.get(key) : 0;
		}

		return result;
	}

	/**
	 * 优化解决 思路： 使用map存储罗马数字的各个代表意义
	 * 可以得出对于IV,IX,XL,XC,CD,CM等，因为代表的数值意义是从小到大，放左边的数值一定是小的
	 * 所以每次预判下一位如果没有下一位字符大于上一位基本就是纯加法操作。否则需要进行减法操作
	 * 
	 * @param str
	 * @return
	 */
	public int romanToIntOptimal(String str) {
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		hMap.put('I', 1);
		hMap.put('V', 5);
		hMap.put('X', 10);
		hMap.put('L', 50);
		hMap.put('C', 100);
		hMap.put('D', 500);
		hMap.put('M', 1000);

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i + 1 < str.length() && hMap.get(str.charAt(i + 1)) > hMap.get(ch)) {
				sum += hMap.get(str.charAt(i + 1));
				sum -= hMap.get(ch);
				i++;
			} else {
				sum += hMap.get(ch);
			}
		}
		return sum;
	}

}
