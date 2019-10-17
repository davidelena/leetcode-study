package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Issue 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinations {

    @Test
    public void testLetterCombinations() {
        String str = "23";
        for (String item : letterCombinations(str)) {
            System.out.println(item);
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        Map<String, String> phoneMap = new HashMap<>();
        phoneMap.put("2", "abc");
        phoneMap.put("3", "def");
        phoneMap.put("4", "ghi");
        phoneMap.put("5", "jkl");
        phoneMap.put("6", "mno");
        phoneMap.put("7", "pqrs");
        phoneMap.put("8", "tuv");
        phoneMap.put("9", "wxyz");

        List<String> list = new ArrayList<>();
        backtracking(list, phoneMap, "", digits);
        return list;
    }

    public void backtracking(List<String> list, Map<String, String> phoneMap, String combination, String digits) {
        if (digits == null || digits.length() == 0) {
            list.add(combination);
        } else {
            String currentDigits = digits.substring(0, 1);
            if (!phoneMap.containsKey(currentDigits)) {
                return;
            }

            String letters = phoneMap.get(currentDigits);
            for (int i = 0; i < letters.length(); i++) {
                String letter = String.valueOf(letters.charAt(i));
                backtracking(list, phoneMap, combination + letter, digits.substring(1));
            }
        }

    }

}
