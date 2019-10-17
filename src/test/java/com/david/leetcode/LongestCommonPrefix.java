package com.david.leetcode;

import org.testng.annotations.Test;

/**
 * Issue 14
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * 
 * Input: ["flower","flow","flight"] Output: "fl"
 * 
 * Topic: trie字典树，String
 * 
 * 最长公共前序 解题思路： 因为是公共前缀，所以所有都能从第一个开始进行多指针匹配
 */
public class LongestCommonPrefix {

	@Test
	public void testLongestCommonPrefix() {
		String[] str1 = new String[] { "flower", "flow", "flight" };
		String[] str2 = new String[] { "dog", "racecar", "car" };
		String[] str3 = new String[] { "aa" };
		String[] str4 = new String[] { "a", "a" };
		String[] str5 = new String[] { "a", "b" };
		String[] str6 = new String[] { "abc", "ab", "abcde" };
		System.out.println(longestCommonPrefixWithTrie(str1));
		System.out.println(longestCommonPrefixWithTrie(str2));
		System.out.println(longestCommonPrefixWithTrie(str3));
		System.out.println(longestCommonPrefixWithTrie(str4));
		System.out.println(longestCommonPrefixWithTrie(str5));
		System.out.println(longestCommonPrefixWithTrie(str6));
	}

	public String longestCommonPrefix(String[] strs) {
		// 如果长度小于1，没有公共前缀返回空
		if (strs.length <= 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		// 选取第一个元素作为起始比较元素
		int length = strs[0].length();
		String strElement = strs[0];
		int minLength = length; // 记录给定字符串比较数组中最短的字符串长度，用来判断比较停止，因为charAt会抛异常
		StringBuilder sb = new StringBuilder(); // 存储最终结果

		// 找出给定字符串数组中，长度最短的，并且记录
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}

		int index = 0; // 起始元素
		boolean isEquals = true; // 最终判定是否为公共字符，默认为相同，找到不同则设置成false
		while (index < minLength) {
			for (int i = 1; i < strs.length; i++) {
				if (strElement.charAt(index) != strs[i].charAt(index)) {
					isEquals = false;
					break;
				}
			}
			if (!isEquals) {
				break;
			}
			sb.append(strElement.charAt(index));
			index++;
		}
		return sb.toString();
	}

	/**
	 * 官方解题思路
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefixV2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public String longestCommonPrefixWithTrie(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		Trie trie = new Trie();
		// 建字典树
		String minLengthStr = strs[0];
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minLengthStr.length()) {
				minLengthStr = strs[i];
			}
			String s = strs[i].replaceAll("", "\\s+");
			if (!s.isEmpty()) {
				trie.insert(strs[i]);
			}
		}

		String prefix = trie.searchLongestCommonPrefix(minLengthStr);
		return prefix;

	}
}
