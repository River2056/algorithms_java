package com.river.algo_expert.medium;

import java.util.Arrays;

/**
 * MinNumberOfCoinsForChange
 */
public class MinNumberOfCoinsForChange {

    public static int minNumberOfCoinsForChangeSelf(int n, int[] denoms) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int denom : denoms)
                if (i - denom >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - denom]);
        }
        return dp[dp.length - 1] == n + 1 ? -1 : dp[dp.length - 1];
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int denom : denoms) {
            for (int i = 1; i < dp.length; i++) {
                if (denom <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - denom]);
                }
            }
        }

        return dp[dp.length - 1] == n + 1 ? -1 : dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int result = MinNumberOfCoinsForChange.minNumberOfCoinsForChange(7, new int[] { 1, 5, 10 });
        System.out.printf("result: %s%n", result);
        if (result != 3)
            throw new RuntimeException(String.format("result expected 3, got %s instead", result));

        result = MinNumberOfCoinsForChange.minNumberOfCoinsForChange(7, new int[] { 2, 4 });
        System.out.printf("result2: %s%n", result);
        if (result != -1)
            throw new RuntimeException(String.format("result2 expected -1, got %s instead", result));
    }
}
