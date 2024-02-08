package com.river.leetcode.daily;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int squareIndex = (int) (Math.sqrt(n)) + 1;
        int[] squareNums = new int[squareIndex];
        for (int i = 1; i < squareIndex; i++)
            squareNums[i] = i * i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < squareIndex; j++) {
                if (i < squareNums[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i - squareNums[j]] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(12)); // 3, 4 + 4 + 4
        System.out.println(p.numSquares(13)); // 2, 4 + 9
    }
}
