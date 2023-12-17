package com.river.leetcode;

public class IntegerToRomanRecommended {
  private static final int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static final String[] romanSymbols = {
    "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
  };

  public static String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] <= num) {
        num -= nums[i];
        sb.append(romanSymbols[i]);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int x = 140;
    System.out.println(intToRoman(x));
  }
}
