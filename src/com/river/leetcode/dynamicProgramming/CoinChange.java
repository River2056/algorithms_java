package com.river.leetcode.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i < amount + 1; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

  public static void test1() {
    int[] coins = {1, 2, 5};
    int amount = 11;
    int res = coinChange(coins, amount);
    System.out.printf("res: %s\n", res);
  }

  public static void main(String[] args) {
    test1();
  }
}
