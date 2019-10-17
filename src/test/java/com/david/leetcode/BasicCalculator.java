package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Stack;
import java.util.regex.Pattern;

public class BasicCalculator {

    @Test
    public void testBasicCalculator() {
        String s = "3+2*2 - 10+2*3";
        String s1 = " 3/2 ";
        String s2 = " 3+5 / 2 ";
        int result = calculate(s2);
        System.out.println(result);

    }

    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        // Add char into the stack which is init the data
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (c.isEmpty() || Pattern.matches("\\s+", c)) {
                continue;
            }
            if (c.equals("*")) {
                if (!stack.isEmpty()) {
                    String first = stack.pop();
                    if (i + 1 < s.length()) {
                        String second = null;
                        while (!stack.isEmpty()) {
                            second = stack.pop();
                            if (c.isEmpty() || Pattern.matches("\\s+", c)) {
                                continue;
                            }
                            break;
                        }
                        second = String.valueOf(s.charAt(i + 1));
                        int value = Integer.parseInt(first) * Integer.parseInt(second);
                        // repush to the stack;
                        stack.push(String.valueOf(value));
                        i++;
                    }
                }
            } else if (c.equals("/")) {
                if (!stack.isEmpty()) {
                    String first = stack.pop();
                    if (i + 1 < s.length()) {
                        String second = null;
                        while (!stack.isEmpty()) {
                            second = stack.pop();
                            if (c.isEmpty() || Pattern.matches("\\s+", c)) {
                                continue;
                            }
                            break;
                        }
                        second = String.valueOf(s.charAt(i + 1));
                        int value = Integer.parseInt(first) / Integer.parseInt(second);
                        // repush to the stack;
                        stack.push(String.valueOf(value));
                        i++;
                    }
                }
            } else {
                stack.push(c);
            }
        }

        // Pop data from the stack and calulate the result
        Stack<String> resultStack = new Stack<>();
        String current = null;
        int currentValue = 0;
        int result = 0;
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.equals("+")) {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    currentValue = Integer.parseInt(current);
                    result += currentValue;
                }
            } else if (current.equals("-")) {
                current = stack.pop();
                currentValue = Integer.parseInt(current);
                result = -result;
                result += currentValue;
            } else {
                currentValue = Integer.parseInt(current);
                result += currentValue;
            }
        }
        return result;
    }
}
