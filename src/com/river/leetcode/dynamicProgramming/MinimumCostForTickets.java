package com.river.leetcode.dynamicProgramming;

import java.util.Arrays;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + costs[0];

            int j = i - 1;
            while(j >= 0 && days[i - 1] - days[j] < 7) j--;
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[1]);

            j = i - 1;
            while(j >= 0 && days[i - 1] - days[j] < 30) j--;
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[2]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        System.out.printf("a. %s\n", m.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15})); // 11
        System.out.printf("b. %s\n", m.mincostTickets(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15})); // 17
    }
}
