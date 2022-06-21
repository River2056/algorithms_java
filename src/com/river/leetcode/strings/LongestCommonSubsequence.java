package com.river.leetcode.strings;

public class LongestCommonSubsequence {
    /**
     * initialize dp as 2d array dp = [ [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0,
     * 0, 0, 0], ]
     *
     * start from the right bottom(length - 2, length - 2, because empty strings will just be 0),
     * bottom up approach when two characters match, go diagnal => 1 + dp[i + 1][j + 1] if not match
     * => 1. go bottom => dp[i + 1][i] 2. go right => dp[i][j + 1] get the max from both and assign
     * value to that spot => dp[i][j] = Math.max(1., 2.)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[i].length - 2; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        int res = lcs.longestCommonSubsequence("abcde", "ace");
        System.out.printf("res: %s\n", res); // 3

        res = lcs.longestCommonSubsequence("abc", "abc");
        System.out.printf("res: %s\n", res); // 3

        res = lcs.longestCommonSubsequence("abc", "def");
        System.out.printf("res: %s\n", res); // 0
    }
}
