package com.river.leetcode.array;

public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;

    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStockII best = new BestTimeToBuyAndSellStockII();
    System.out.printf("1. %s\n", best.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    System.out.printf("2. %s\n", best.maxProfit(new int[] {1, 2, 3, 4, 5}));
    System.out.printf("3. %s\n", best.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }
}
