package com.river.leetcode.studyplan.level1;

public class BinarySearch {
  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) return -1;

    int mid = (start + end) / 2;

    if (nums[mid] == target) return mid;
    else if (nums[mid] > target) return binarySearch(nums, start, mid - 1, target);
    else return binarySearch(nums, mid + 1, end, target);
  }

  public static void main(String[] args) {
    BinarySearch bs = new BinarySearch();
    System.out.printf("1. %s\n", bs.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    System.out.printf("2. %s\n", bs.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
  }
}
