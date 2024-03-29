package com.river.leetcode;

public class PalindromeNumber {
  /**
   * Given an integer x, return true if x is palindrome integer.
   *
   * <p>An integer is a palindrome when it reads the same backward as forward. For example, 121 is
   * palindrome while 123 is not.
   *
   * <p>Example 1: Input: x = 121 Output: true
   *
   * <p>Example 2: Input: x = -121 Output: false Explanation: From left to right, it reads -121.
   * From right to left, it becomes 121-. Therefore it is not a palindrome.
   *
   * <p>Example 3: Input: x = 10 Output: false Explanation: Reads 01 from right to left. Therefore
   * it is not a palindrome.
   *
   * <p>Example 4: Input: x = -101 Output: false
   *
   * <p>Follow up: Could you solve it without converting the integer to a string?
   *
   * @param args
   */
  public static void main(String[] args) {
    int x = 121;
    System.out.println(isPalindrome(x));

    int y = 123;
    System.out.println(isPalindrome(y));
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) return false;
    int original = x;
    int rev = 0;
    while (original != 0) {
      int pop = original % 10;
      original /= 10;
      rev = rev * 10 + pop;
    }
    return rev == x;
  }
}
