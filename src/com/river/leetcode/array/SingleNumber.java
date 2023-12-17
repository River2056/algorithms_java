package com.river.leetcode.array;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int first = nums[0];
    for (int i = 1; i < nums.length; i++) first ^= nums[i];

    return first;
  }

  public static void main(String[] args) {
    SingleNumber sn = new SingleNumber();

    System.out.printf("res: %s\n", sn.singleNumber(new int[] {2, 2, 1})); // 1
    System.out.printf("res: %s\n", sn.singleNumber(new int[] {4, 1, 2, 1, 2})); // 4
    System.out.printf("res: %s\n", sn.singleNumber(new int[] {1})); // 1
  }
}
