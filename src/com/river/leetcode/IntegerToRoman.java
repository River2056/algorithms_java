package com.river.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerToRoman {

  /**
   * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
   *
   * <p>Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written as II in Roman
   * numeral, just two one's added together. 12 is written as XII, which is simply X + II. The
   * number 27 is written as XXVII, which is XX + V + II.
   *
   * <p>Roman numerals are usually written largest to smallest from left to right. However, the
   * numeral for four is not IIII. Instead, the number four is written as IV. Because the one is
   * before the five we subtract it making four. The same principle applies to the number nine,
   * which is written as IX. There are six instances where subtraction is used:
   *
   * <p>I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C
   * (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given
   * an integer, convert it to a roman numeral.
   *
   * <p>Example 1:
   *
   * <p>Input: num = 3 Output: "III" Example 2:
   *
   * <p>Input: num = 4 Output: "IV" Example 3:
   *
   * <p>Input: num = 9 Output: "IX" Example 4:
   *
   * <p>Input: num = 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example 5:
   *
   * <p>Input: num = 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
   *
   * <p>Constraints:
   *
   * <p>1 <= num <= 3999
   *
   * @param args
   */
  private static final Map<Integer, String> romanNums =
      Stream.of(
              new Object[][] {
                {1000, "M"},
                {900, "CM"},
                {500, "D"},
                {400, "CD"},
                {100, "C"},
                {90, "XC"},
                {50, "L"},
                {40, "XL"},
                {10, "X"},
                {9, "IX"},
                {5, "V"},
                {4, "IV"},
                {1, "I"},
              })
          .collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

  private static final List<Integer> nums =
      Arrays.stream(romanNums.keySet().toArray())
          .map(e -> (Integer) e)
          .collect(Collectors.toList());

  static {
    nums.sort(
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o2 - o1;
          }
        });
  }

  public static void main(String[] args) {
    int x = 140;
    System.out.println(intToRoman(x));
  }

  public static String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    Map<Integer, Integer> containRomanNums =
        Stream.of(
                new Object[][] {
                  {1000, 0}, {900, 0}, {500, 0}, {400, 0}, {100, 0}, {90, 0}, {50, 0}, {40, 0},
                  {10, 0}, {9, 0}, {5, 0}, {4, 0}, {1, 0},
                })
            .collect(Collectors.toMap(data -> (Integer) data[0], data -> (Integer) data[1]));
    int indexCount = 0;
    while (num != 0) {
      int count = num / nums.get(indexCount);
      containRomanNums.put(nums.get(indexCount), count);
      num %= nums.get(indexCount);
      indexCount++;
    }
    for (int i = 0; i < nums.size(); i++) {
      int romanCount = containRomanNums.get(nums.get(i));
      if (romanCount > 0) {
        for (int j = 0; j < romanCount; j++) {
          sb.append(romanNums.get(nums.get(i)));
        }
      }
    }
    return sb.toString();
  }
}
