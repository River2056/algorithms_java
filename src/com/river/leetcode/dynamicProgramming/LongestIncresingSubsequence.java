package com.river.leetcode.dynamicProgramming;

import java.util.Arrays;

public class LongestIncresingSubsequence {
  /**
   * two nested loops: outer loop goes backwards, inner loop goes forward compare each num, if front
   * < rear: update dp[i] update: Math.max(dp[i], 1 + dp[j])
   *
   * @param nums
   * @return
   */
  public static int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = i + 1; j < dp.length; j++) {
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  public static void test1() {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int res = lengthOfLIS(nums);
    System.out.printf("res: %s\n", res); // 4
  }

  public static void test2() {
    int[] nums = {0, 1, 0, 3, 2, 3};
    int res = lengthOfLIS(nums);
    System.out.printf("res: %s\n", res); // 4
  }

  public static void test3() {
    int[] nums = {7, 7, 7, 7, 7, 7, 7};
    int res = lengthOfLIS(nums);
    System.out.printf("res: %s\n", res); // 1
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
