package com.river.leetcode;

import java.util.Stack;

public class ValidParentheses {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * Example 4:
     *
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     *
     * Input: s = "{[]}"
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     * @param s
     * @return
     */

    // self attempt
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if(stack.empty()) {
                stack.push(c);
             } else {
                 char lastSymbol = stack.peek();
                 // not matching bracket, push
                 // else pop
                 int diff = (int) c - (int) lastSymbol;
                 if(diff > 2 || diff <= 0) stack.push(c);
                 else stack.pop();
             }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));

        System.out.println((int)'(');
        System.out.println((int)')');
        System.out.println((int)'[');
        System.out.println((int)']');
        System.out.println((int)'{');
        System.out.println((int)'}');
//        String s = "()[]{}";
//        System.out.println(isValid(s));
//
//        String a = "(]";
//        System.out.println(isValid(a));
//
//        String b = "([)]";
//        System.out.println(isValid(b));
//
//        String c = "()";
//        System.out.println(isValid(c));
//
//        String d = "((";
//        System.out.println(isValid(d));
    }
}
