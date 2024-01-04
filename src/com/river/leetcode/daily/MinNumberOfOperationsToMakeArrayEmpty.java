package com.river.leetcode.daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinNumberOfOperationsToMakeArrayEmpty {
    private Map<Integer, Integer> cache = new HashMap<>() {
        {
            put(1, Integer.MAX_VALUE);
            put(2, 1);
            put(3, 1);
        }
    };

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
        }

        int result = 0;
        List<Integer> entries = map.entrySet().stream().map(Map.Entry<Integer, Integer>::getValue).toList();
        for (int n : entries) {
            int v = dp(n);
            if (v == Integer.MAX_VALUE)
                return -1;
            result += dp(n);
        }
        return result;
    }

    private int dp(int n) {
        if (cache.containsKey(n))
            return cache.get(n);
        int pv = Math.min(dp(n - 2), dp(n - 3));
        if (pv == Integer.MAX_VALUE)
            return pv;
        int value = 1 + pv;
        cache.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        MinNumberOfOperationsToMakeArrayEmpty m = new MinNumberOfOperationsToMakeArrayEmpty();

        System.out.println(m.minOperations(new int[] { 2, 3, 3, 2, 2, 4, 2, 3, 4 })); // 4
        System.out.println(m.minOperations(new int[] { 2, 1, 2, 2, 3, 3 })); // -1
        System.out.println(m.minOperations(
                new int[] { 14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12 })); // 7
        System.out.println(m.minOperations(new int[] { 15, 3, 3, 15, 15, 13, 8, 15, 6, 15, 3, 1, 8, 8, 15 }));
    }
}
