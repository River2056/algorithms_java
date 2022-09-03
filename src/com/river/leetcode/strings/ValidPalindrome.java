package com.river.leetcode.strings;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
        return false;
      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    ValidPalindrome vp = new ValidPalindrome();

    boolean res = vp.isPalindrome("A man, a plan, a canal: Panama");
    System.out.printf("res: %s\n", res); // true

    res = vp.isPalindrome("race a car");
    System.out.printf("res: %s\n", res); // false

    res = vp.isPalindrome(" ");
    System.out.printf("res: %s\n", res); // true
  }
}
