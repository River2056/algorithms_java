package com.river.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);

    for (int i = 0; i < nums.length; i++) if (!set.contains(i + 1)) res.add(i + 1);

    return res;
  }

  public static void main(String[] args) {
    FindAllNumbersDisappearedInAnArray fand = new FindAllNumbersDisappearedInAnArray();

    System.out.printf("res: %s\n", fand.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    System.out.printf("res: %s\n", fand.findDisappearedNumbers(new int[] {1, 1}));
  }
}
