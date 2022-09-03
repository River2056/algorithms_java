package com.river.leetcode.studyplan.level1;

public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    if (cost.length <= 2) return Math.min(cost[0], cost[1]);

    int[] dp = new int[cost.length];
    dp[dp.length - 1] = cost[cost.length - 1];
    dp[dp.length - 2] = cost[cost.length - 2];
    for (int i = cost.length - 3; i >= 0; i--) {
      dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);
    }

    return Math.min(dp[0], dp[1]);
  }

  public static void main(String[] args) {
    MinCostClimbingStairs min = new MinCostClimbingStairs();
    System.out.printf("1. %s\n", min.minCostClimbingStairs(new int[] {10, 15, 20})); // 15
    System.out.printf(
        "2. %s\n", min.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    System.out.printf("3. %s\n", min.minCostClimbingStairs(new int[] {4, 1})); // 1
  }
}
