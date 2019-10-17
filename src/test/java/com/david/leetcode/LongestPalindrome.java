package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class LongestPalindrome {

    private int maxLength;

    @Test
    public void testLongestPalindrome() {
//        String s = "babaddtattarrattatddetartrateedredividerb";
        String s = "babad";
        System.out.println(longestPalindrome(s));
        String s1 = "cbbd";
        System.out.println(longestPalindrome(s1));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
                if (dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindromeV2(String s) {
        HashSet<String> sets = new HashSet<>();
        Map<String, Boolean> resMap = new HashMap<>();
        Map<Integer, String> resultMap = new HashMap<>();
        backtrackingV2(0, s, sets, resMap, resultMap);
        for (String item : sets) {
            System.out.println(item);
        }
        return resultMap.containsKey(maxLength) ? resultMap.get(maxLength) : "";
    }

    private boolean isPalindrome(String s) {
        boolean result = true;
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return result;
    }

    public void backtrackingV2(int start, String s, HashSet<String> sets, Map<String, Boolean> resMap, Map<Integer, String> resultMap) {
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if ((resMap.containsKey(str) && resMap.get(str)) || !isPalindrome(str)) {
                continue;
            }
            sets.add(str);
            maxLength = Math.max(maxLength, str.length());
            resultMap.put(str.length(), str);
            resMap.put(str, true);
            backtrackingV2(start + 1, s, sets, resMap, resultMap);
        }
    }

    public void backtracking(int start, String s, HashSet<String> sets, Map<Integer, String> resultMap) {
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (!isPalindrome(str)) {
                continue;
            }
            sets.add(str);
            maxLength = Math.max(maxLength, str.length());
            resultMap.put(str.length(), str);
            backtracking(start + 1, s, sets, resultMap);
        }
    }




    @Test
    public void testPalindrome() {
        String s = "";
        String s1 = "ab";
        String s2 = "aba";
        String s3 = "abba";
        String s4 = "a";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
        System.out.println(isPalindrome(s4));
    }
}
