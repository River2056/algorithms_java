package com.river.leetcode.dynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[i].length - 2; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(l.longestCommonSubsequence("abc", "abc")); // 3
        System.out.println(l.longestCommonSubsequence("abc", "def")); // 0
        System.out.println(l.longestCommonSubsequence("bsbininm", "jmjkbkjkv")); // 1
    }
}
