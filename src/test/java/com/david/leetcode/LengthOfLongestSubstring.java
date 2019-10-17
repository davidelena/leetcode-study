package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {

    @Test
    public void testLengthOfLongestSubstring() {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstringV3(s4));
    }

    public int lengthOfLongestSubstringV2(String s) {
        int maxLength = 0;
        int i = 0, j = 0;
        int length = s.length();
        HashSet<Character> sets = new HashSet<>();
        while (i < length && j < length) {
            if (!sets.contains(s.charAt(j))) {
                sets.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                sets.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringV3(String s) {
        Map<Character, Integer> indices = new HashMap<Character, Integer>();
        int length = 0;
        int start = -1;
        int end = 0;
        for (end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (indices.containsKey(c)) {
                int newstart = indices.get(c);
                start = Math.max(start, newstart);
            }
            length = Math.max(length, end - start);
            indices.put(c, end);
        }
        return length;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    public boolean allUnique(String s, int start, int end) {
        HashSet<Character> charSets = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (charSets.contains(s.charAt(i))) {
                return false;
            }
            charSets.add(s.charAt(i));
        }
        return true;
    }
}
