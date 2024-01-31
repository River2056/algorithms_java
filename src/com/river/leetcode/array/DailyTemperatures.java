package com.river.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int length = temperatures.length;

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || stack.getLast().get(1) > temperatures[i]) {
                List<Integer> keyValuePair = new ArrayList<>();
                keyValuePair.add(i);
                keyValuePair.add(temperatures[i]);
                stack.add(keyValuePair);
            } else {
                while (!stack.isEmpty() && stack.getLast().get(1) < temperatures[i]) {
                    List<Integer> temps = stack.removeLast();
                    result[temps.get(0)] = i - temps.get(0);
                }

                List<Integer> newKeyValue = new ArrayList<>();
                newKeyValue.add(i);
                newKeyValue.add(temperatures[i]);
                stack.add(newKeyValue);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();

        // [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));

        // [1, 1, 1, 0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[] { 30, 40, 50, 60 })));

        // [1, 1, 0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[] { 30, 60, 90 })));
    }
}
