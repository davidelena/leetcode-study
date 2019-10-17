package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {


    @Test
    public void testWordBreak() {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});

//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList(new String[]{"apple", "pen"});

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});

        String s = "cars";
        List<String> wordDict = Arrays.asList(new String[]{"car", "ca", "rs"});

        System.out.println(wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new boolean[s.length()]);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start, boolean[] memos) {
        if (start == s.length()) {
            return true;
        }
        if (memos[start]) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memos)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakV2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;
        // 外层循环递增长度
        for (int i = s.length() - 1; i >= 0; i--) {
            // 内层循环寻找分割点
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (wordDict.contains(sub) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
