package com.river.practice;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentPrice = prices[0];
        for (int price : prices) {
            if (price < currentPrice)
                currentPrice = price;
            else {
                int profit = price - currentPrice;
                maxProfit = Math.max(maxProfit, profit);
            }

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock best = new BestTimeToBuyAndSellStock();

        System.out.printf("res: %s\n", best.maxProfit(new int[] {7, 1, 5, 3, 6, 4})); // 5
        System.out.printf("res: %s\n", best.maxProfit(new int[] {7, 6, 4, 3, 1})); // 0
    }
}
