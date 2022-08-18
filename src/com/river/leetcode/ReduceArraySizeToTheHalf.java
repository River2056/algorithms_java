package com.river.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceArraySizeToTheHalf {
  // self implemented with hints
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr)
      if (map.containsKey(i)) map.put(i, map.get(i) + 1);
      else map.put(i, 1);

    List<Integer> values = map.values().stream().collect(Collectors.toList());
    Collections.sort(values, Collections.reverseOrder());
    int removeCount = 0;
    int count = 0;

    for (int i = 0; i < values.size(); i++)
      if (removeCount < arr.length / 2) {
        removeCount += values.get(i);
        count++;
      }

    return count;
  }

  public static void main(String[] args) {
    ReduceArraySizeToTheHalf r = new ReduceArraySizeToTheHalf();
    System.out.printf("1. %s\n", r.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7})); // 2
    System.out.printf("2. %s\n", r.minSetSize(new int[] {7, 7, 7, 7, 7, 7})); // 1
  }
}
