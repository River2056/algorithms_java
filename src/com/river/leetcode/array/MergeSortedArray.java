package com.river.leetcode.array;

public class MergeSortedArray {
  interface CFn {
    void apply(int[] nums1, int m, int[] nums2, int n);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) return;

    if (m == 0) {
      System.arraycopy(nums2, 0, nums1, 0, nums2.length);
      return;
    }

    int p = (m + n) - 1, p1 = m - 1, p2 = n - 1;
    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] > nums2[p2]) nums1[p--] = nums1[p1--];
      else nums1[p--] = nums2[p2--];
    }

    while (p1 >= 0) nums1[p--] = nums1[p1--];

    while (p2 >= 0) nums1[p--] = nums2[p2--];
  }

  public static void mergeImplementedBySelf(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0, k = 0;
    int[] numsMerged = new int[nums1.length];
    if (n == 0) return;
    if (m == 0) {
      System.arraycopy(nums2, 0, nums1, 0, nums2.length);
      return;
    }

    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) numsMerged[k++] = nums1[i++];
      else numsMerged[k++] = nums2[j++];
    }

    while (i < m) numsMerged[k++] = nums1[i++];

    while (j < n) numsMerged[k++] = nums2[j++];

    System.arraycopy(numsMerged, 0, nums1, 0, numsMerged.length);
  }

  public static void testCase(int[] nums1, int m, int[] nums2, int n, CFn fn) {
    fn.apply(nums1, m, nums2, n);
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < nums1.length; i++) {
      sb.append(nums1[i]);
      if (i != nums1.length - 1) sb.append(", ");
    }
    sb.append("]");

    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    CFn mergeSortedArraySelf = (nums1, m, nums2, n) -> mergeImplementedBySelf(nums1, m, nums2, n);
    testCase(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3, mergeSortedArraySelf);
    testCase(new int[] {1}, 1, new int[0], 0, mergeSortedArraySelf);
    testCase(new int[] {0}, 0, new int[] {1}, 1, mergeSortedArraySelf);

    CFn mergeSortedArray = (nums1, m, nums2, n) -> merge(nums1, m, nums2, n);
    testCase(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3, mergeSortedArray);
    testCase(new int[] {1}, 1, new int[0], 0, mergeSortedArray);
    testCase(new int[] {0}, 0, new int[] {1}, 1, mergeSortedArray);
    testCase(new int[] {1, 0}, 1, new int[] {2}, 1, mergeSortedArray);
  }
}
