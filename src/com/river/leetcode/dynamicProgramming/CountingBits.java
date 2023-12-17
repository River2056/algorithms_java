package com.river.leetcode.dynamicProgramming;

import java.util.Arrays;

public class CountingBits {
  public int[] countBits(int n) {
    int[] res = new int[n + 1];
    for (int i = 0; i < res.length; i++) {
      int count1 = count(i);
      res[i] = count1;
    }

    return res;
  }

  private int count(int n) {
    int res = 0;
    while (n != 0) {
      int r = n % 2;
      if (r == 1) res++;
      n /= 2;
    }

    return res;
  }

  public static void main(String[] args) {
    CountingBits cb = new CountingBits();

    System.out.printf("res: %s\n", Arrays.toString(cb.countBits(2)));
    System.out.printf("res: %s\n", Arrays.toString(cb.countBits(5)));
  }
}
