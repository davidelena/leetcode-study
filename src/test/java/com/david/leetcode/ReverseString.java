package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ReverseString {

    @Test
    public void testReverseString() {
        char[] s = new char[]{'a', 'b', 'c'};
        char[] s1 = new char[]{'a', 'b', 'c', 'd'};
        char[] s2 = new char[]{'a'};
        char[] s3 = new char[0];
        reverseStringV2(s3);
        System.out.println(s3);
    }

    public void reverseString(char[] s) {
        char[] newArr = new char[s.length];
        for (int i = s.length - 1; i >= 0; i--) {
            newArr[s.length - 1 - i] = s[i];
        }
        System.arraycopy(newArr, 0, s, 0, s.length);
    }

    public void reverseStringV2(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
