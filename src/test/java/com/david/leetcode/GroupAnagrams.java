package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * Issue: 49
 */
public class GroupAnagrams {

    @Test
    public void testGroupAnagrams() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        for (List<String> item : list) {
            System.out.println(item);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> resultMap = new HashMap<>();
        String key = "";
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            key = String.valueOf(chars);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList<>());
            }
            resultMap.get(key).add(str);
        }
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> item : resultMap.entrySet()) {
            list.add(item.getValue());
        }
        return list;
    }

    public String getKey(char[] chars) {
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            sb.append(String.valueOf(aChar));
            if (i != chars.length - 1) {
                sb.append("_");
            }
        }
        return sb.toString();
    }


}
