package com.river.algo_expert.medium;

import java.util.Arrays;

/**
 * NumberOfWaysToMakeChange
 */
public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int denom : denoms) {
            for (int i = 1; i < dp.length; i++) {
                if (denom <= i)
                    dp[i] += dp[i - denom];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int result = NumberOfWaysToMakeChange.numberOfWaysToMakeChange(6, new int[] { 1, 5 });
        System.out.printf("result: %s%n", result);
        if (result != 2)
            throw new RuntimeException(String.format("result expected 2, got %s instead", result));
    }
}
