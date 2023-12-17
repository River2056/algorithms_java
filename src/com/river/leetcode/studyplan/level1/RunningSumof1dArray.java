package com.river.leetcode.studyplan.level1;

import java.util.Arrays;

public class RunningSumof1dArray {
  public int[] runningSum(int[] nums) {
    int[] res = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      res[i] = sum;
    }

    return res;
  }

  public static void main(String[] args) {
    RunningSumof1dArray run = new RunningSumof1dArray();
    System.out.printf("1. %s\n", Arrays.toString(run.runningSum(new int[] {1, 2, 3, 4})));
    System.out.printf("2. %s\n", Arrays.toString(run.runningSum(new int[] {1, 1, 1, 1, 1})));
    System.out.printf("3. %s\n", Arrays.toString(run.runningSum(new int[] {3, 1, 2, 10, 1})));
  }
}
