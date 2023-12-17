package com.river.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DegreeOfAnArray {
  public int findShortestSubArray(int[] nums) {
    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
      if (map.get(n) > max) max = map.get(n);
    }

    int min = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max) {
        int num = entry.getKey();
        int left = list.indexOf(num);
        int right = list.lastIndexOf(num);
        int diff = right - left + 1;
        if (diff < min) min = diff;
      }
    }

    return min;
  }

  public static void main(String[] args) {
    DegreeOfAnArray d = new DegreeOfAnArray();
    System.out.printf("1. %s\n", d.findShortestSubArray(new int[] {1, 2, 2, 3, 1})); // 2
    System.out.printf("2. %s\n", d.findShortestSubArray(new int[] {1, 2, 2, 3, 1, 4, 2})); // 6
  }
}
