package com.river.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (set.contains(i)) return true;
      set.add(i);
    }
    return false;
  }

  public boolean containsDuplicateUsingSort(int[] nums) {
    nums = mergeSort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) return true;
    }
    return false;
  }

  private int[] mergeSort(int[] arr) {
    if (arr.length == 1) return arr;

    int mid = arr.length / 2;
    int[] left = new int[mid], right = new int[arr.length % 2 == 0 ? mid : mid + 1];
    System.arraycopy(arr, 0, left, 0, left.length);
    System.arraycopy(arr, mid, right, 0, right.length);
    left = mergeSort(left);
    right = mergeSort(right);

    int[] merged = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length)
      if (left[i] < right[j]) merged[k++] = left[i++];
      else merged[k++] = right[j++];

    while (i < left.length) merged[k++] = left[i++];

    while (j < right.length) merged[k++] = right[j++];

    return merged;
  }

  public static void main(String[] args) {
    ContainsDuplicate cd = new ContainsDuplicate();
    boolean res = cd.containsDuplicate(new int[] {1, 2, 3, 1});
    System.out.printf("res: %s\n", res);

    res = cd.containsDuplicate(new int[] {1, 2, 3, 4});
    System.out.printf("res: %s\n", res);

    res = cd.containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
    System.out.printf("res: %s\n", res);
  }
}
