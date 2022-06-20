package com.river.practice;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int prev = 1, cur = 1;
        for (int i = n - 2; i >= 0; i--) {
            int newNum = prev + cur;
            prev = cur;
            cur = newNum;
        }

        return cur;
    }

    // dp solution - bottom up
    public int climbStairsBottomUpDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            if (i == n || i + 1 == n)
                dp[i] = 1;
            else
                dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.printf("res: %s\n", cs.climbStairs(5)); // 8
        System.out.printf("res: %s\n", cs.climbStairs(2)); // 2
        System.out.printf("res: %s\n", cs.climbStairs(3)); // 3
    }
}
