package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 * <p>
 * 
 * 
 * 
 * 解题注意事项
 * 如果传入的是空字符串或者空格字符不管多少个，str.split(" ")以后也只会有是一个空数组
 */
public class LengthOfLastWord {

    @Test
    public void testLengthOfLastWorld() {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        if (strArr.length == 0)
            return 0;

        return strArr[strArr.length - 1].length();
    }

    @Test
    public void testSplitEmptyCharacter() {
        String s = "  ";
        String[] strArr = s.split(" ");
        System.out.println(Arrays.toString(strArr));
        System.out.println(strArr.length);
    }
}
