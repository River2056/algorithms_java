package com.river.leetcode.studyplan.level1;

public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int sum = 0, leftSum = 0;
    for (int n : nums) sum += n;
    for (int i = 0; i < nums.length; i++) {
      if (sum - leftSum - nums[i] == leftSum) return i;
      leftSum += nums[i];
    }

    return -1;
  }

  public int pivotIndexSelf(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int left = 0, right = 0;
      int p1 = i - 1, p2 = i + 1;
      while (p1 >= 0 && p1 < nums.length) {
        left += nums[p1];
        p1--;
      }

      while (p2 >= 0 && p2 < nums.length) {
        right += nums[p2];
        p2++;
      }

      if (left == right) return i;
    }

    return -1;
  }

  public static void main(String[] args) {
    FindPivotIndex find = new FindPivotIndex();
    System.out.printf("1. %s\n", find.pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
    System.out.printf("2. %s\n", find.pivotIndex(new int[] {1, 2, 3}));
    System.out.printf("3. %s\n", find.pivotIndex(new int[] {2, 1, -1}));
  }
}
