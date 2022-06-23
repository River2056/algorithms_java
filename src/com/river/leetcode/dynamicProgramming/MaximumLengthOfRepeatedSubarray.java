package com.river.leetcode.dynamicProgramming;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length + 1;
        int length2 = nums2.length + 1;
        int[][] dp = new int[length1][length2];

        int max = 0;
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maxi = new MaximumLengthOfRepeatedSubarray();
        System.out.printf("1. %s\n",
                maxi.findLength(new int[] {1, 2, 3, 2, 1}, new int[] {3, 2, 1, 4, 7})); // 3
        System.out.printf("2. %s\n",
                maxi.findLength(new int[] {0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0})); // 5

    }
}
