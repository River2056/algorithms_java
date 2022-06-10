package com.river.leetcode.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buyPoint = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPoint) {
                buyPoint = prices[i];
            } else {
                int profit = prices[i] - buyPoint;
                max = Math.max(max, profit);
            }
        }

        return max;
    }

    public int maxProfitSelf(int[] prices) {
        int max = 0;
        int buyPoint = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buyPoint < 0) {
                buyPoint = prices[i];
            } else {
                int profit = prices[i] - buyPoint;
                max = Math.max(max, profit);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();

        int res = bt.maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        System.out.printf("res: %s\n", res);

        res = bt.maxProfit(new int[] {7, 6, 4, 3, 1});
        System.out.printf("res: %s\n", res);
    }
}
