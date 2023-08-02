package com.river.algo_expert.medium;

/**
 * MaxSubsetSumNoAdjacent
 */
public class MaxSubsetSumNoAdjacent {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 1)
            return array[0];
        if (array.length == 2)
            return Math.max(array[0], array[1]);

        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(array[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        // 75 + 120 + 135 = 330
        System.out.printf("1. %s%n",
                MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(new int[] { 75, 105, 120, 75, 90, 135 }));
    }
}
