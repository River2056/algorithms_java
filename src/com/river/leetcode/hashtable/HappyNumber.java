package com.river.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (n != 1 && !set.contains(n)) {
      set.add(n);
      n = getNext(n);
    }

    return n == 1;
  }

  private int getNext(int n) {
    int totalSum = 0;
    while (n > 0) {
      int d = n % 10;
      n /= 10;
      totalSum += d * d;
    }

    return totalSum;
  }

  public static void main(String[] args) {
    HappyNumber happy = new HappyNumber();
    System.out.printf("1. %s\n", happy.isHappy(19)); // true
    System.out.printf("2. %s\n", happy.isHappy(2)); // false
    System.out.printf("3. %s\n", happy.isHappy(7)); // true
  }
}
