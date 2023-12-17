package com.river.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int res = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int check = sum - k;
      if (map.containsKey(check)) res += map.get(check);

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return res;
  }

  public static void main(String[] args) {
    SubArraySumEqualsK saek = new SubArraySumEqualsK();

    System.out.printf("res: %s\n", saek.subarraySum(new int[] {1, 1, 1}, 2)); // 2
    System.out.printf("res: %s\n", saek.subarraySum(new int[] {1, 2, 3}, 3)); // 2
  }
}
