package com.river.codesignal.hashtables;

import java.util.HashMap;
import java.util.Map;

public class ContainsCloseNums {
  public boolean solution(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int originalIndex = map.get(nums[i]);
        if (i - originalIndex <= k) return true;
      }
      map.put(nums[i], i);
    }

    return false;
  }

  public static void main(String[] args) {
    ContainsCloseNums ccn = new ContainsCloseNums();

    System.out.printf("res: %s\n", ccn.solution(new int[] {0, 1, 2, 3, 5, 2}, 3)); // true
    System.out.printf("res: %s\n", ccn.solution(new int[] {0, 1, 2, 3, 5, 2}, 2)); // false
  }
}
