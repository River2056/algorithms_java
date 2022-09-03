package com.river.leetcode.array;

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    // find smallest index
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int midpoint = left + (right - left) / 2;
      if (nums[midpoint] > nums[right]) left = midpoint + 1;
      else right = midpoint;
    }

    int start = left;
    left = 0;
    right = nums.length - 1;

    // check target in which portion
    if (nums[start] <= target && nums[right] >= target) left = start;
    else right = start;

    while (left <= right) {
      int midpoint = left + (right - left) / 2;
      if (nums[midpoint] == target) return midpoint;

      if (nums[midpoint] > target) right = midpoint - 1;
      else if (nums[midpoint] < target) left = midpoint + 1;
    }

    return -1;
  }

  public int searchFromNeetCode(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      while (nums[left] != target && nums[left] > nums[right]) left++;

      if (nums[left] == target) return left;
      if (nums[right] == target) return right;

      int mid = (left + right) / 2;
      if (nums[mid] == target) return mid;
      if (nums[left] < target && nums[mid] > target) right = mid;
      else left = mid + 1;
    }

    return -1;
  }

  // private int binarySearch(int[] nums, int start, int end, int target) {
  // if (start < end) {
  // int mid = (start + end) / 2;
  // if (nums[mid] == target)
  // return mid;

  // // left portion
  // if (nums[start] < nums[mid] && (nums[start] < target && nums[mid] > target)) {
  // return binarySearch(nums, start, mid, target);
  // } else {
  // // right portion
  // return binarySearch(nums, mid + 1, end, target);
  // }
  // }

  // return -1;
  // }

  public static void main(String[] args) {
    SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
    System.out.printf("1. %s\n", s.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0)); // 4
    System.out.printf("2. %s\n", s.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3)); // -1
  }
}
