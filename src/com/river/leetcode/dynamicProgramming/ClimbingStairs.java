package com.river.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public int climbStairsMemoization(int n) {
        return climbStairsMemo(new HashMap<Integer, Integer>(), n);
    }

    private int climbStairsMemo(Map<Integer, Integer> map, int n) {
        if (n <= 2)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int val = climbStairsMemo(map, n - 1) + climbStairsMemo(map, n - 2);
        map.put(n, val);
        return val;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.printf("res: %s\n", cs.climbStairs(2)); // 2
        System.out.printf("res: %s\n", cs.climbStairs(3)); // 3
        System.out.printf("res: %s\n", cs.climbStairs(4)); // 5
    }
}
