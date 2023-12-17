package com.river.leetcode.array;

public class FindTheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int slow = nums[0], fast = nums[0];
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) break;
    }

    int findIntersecSlow = nums[0];
    while (findIntersecSlow != slow) {
      slow = nums[slow];
      findIntersecSlow = nums[findIntersecSlow];
    }

    return findIntersecSlow;
  }

  public static void main(String[] args) {
    FindTheDuplicateNumber find = new FindTheDuplicateNumber();
    System.out.printf("1. %s\n", find.findDuplicate(new int[] {1, 3, 4, 2, 2})); // 2
    System.out.printf("2. %s\n", find.findDuplicate(new int[] {3, 1, 3, 4, 2})); // 3
  }
}
