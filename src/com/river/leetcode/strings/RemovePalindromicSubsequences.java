package com.river.leetcode.strings;

public class RemovePalindromicSubsequences {
  public int removePalindromeSub(String s) {
    if (s.length() <= 0) return 0;
    if (isPalindrome(s)) return 1;
    return 2;
  }

  private boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    RemovePalindromicSubsequences rps = new RemovePalindromicSubsequences();
    int res = rps.removePalindromeSub("ababa");
    System.out.printf("res: %s\n", res); // 1

    res = rps.removePalindromeSub("abb");
    System.out.printf("res: %s\n", res); // 2

    res = rps.removePalindromeSub("baabb");
    System.out.printf("res: %s\n", res); // 2
  }
}
