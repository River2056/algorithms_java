package com.river.leetcode.studyplan.level1;

public class FibonacciNumber {
  public int fib(int n) {
    if (n <= 1) return n;

    return fib(n - 2) + fib(n - 1);
  }

  public static void main(String[] args) {
    FibonacciNumber fib = new FibonacciNumber();
    System.out.printf("1. %s\n", fib.fib(2)); // 1
    System.out.printf("2. %s\n", fib.fib(3)); // 2
    System.out.printf("3. %s\n", fib.fib(4)); // 3
  }
}
