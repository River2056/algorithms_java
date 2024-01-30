package com.river.leetcode.daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            int first;
            int second;
            int result;
            switch (t) {
                case "+":
                    second = Integer.parseInt(stack.removeLast());
                    first = Integer.parseInt(stack.removeLast());
                    result = first + second;
                    stack.add(String.valueOf(result));
                    break;
                case "-":
                    second = Integer.parseInt(stack.removeLast());
                    first = Integer.parseInt(stack.removeLast());
                    result = first - second;
                    stack.add(String.valueOf(result));
                    break;
                case "*":
                    second = Integer.parseInt(stack.removeLast());
                    first = Integer.parseInt(stack.removeLast());
                    result = first * second;
                    stack.add(String.valueOf(result));
                    break;
                case "/":
                    second = Integer.parseInt(stack.removeLast());
                    first = Integer.parseInt(stack.removeLast());
                    result = first / second;
                    stack.add(String.valueOf(result));
                    break;
                default:
                    stack.add(t);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvalRPN e = new EvalRPN();
        System.out.println(e.evalRPN(new String[] { "2", "1", "+", "3", "*" })); // 9
        System.out.println(e.evalRPN(new String[] { "4", "13", "5", "/", "+" })); // 6
        System.out.println(
                e.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" })); // 22
    }
}
