package com.river.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return 1;

    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);

    int max = 0;
    for (int n : nums) {
      if (!set.contains(n - 1)) {
        int cur = n;
        int count = 1;

        while (set.contains(cur + 1)) {
          count++;
          cur++;
        }

        max = Math.max(max, count);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

    int res = lcs.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2});
    System.out.printf("res: %s\n", res); // 4

    res = lcs.longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    System.out.printf("res: %s\n", res); // 9

    res = lcs.longestConsecutive(new int[] {0});
    System.out.printf("res: %s\n", res); // 1

    res = lcs.longestConsecutive(new int[] {1, 2, 0, 1});
    System.out.printf("res: %s\n", res); // 3

    res = lcs.longestConsecutive(new int[] {0, 0});
    System.out.printf("res: %s\n", res); // 1
  }
}
