package com.river.leetcode;


public class LongestCommonPrefix {

  /**
   * Write a function to find the longest common prefix string amongst an array of strings.
   *
   * <p>If there is no common prefix, return an empty string "".
   *
   * <p>Example 1:
   *
   * <p>Input: strs = ["flower","flow","flight"] Output: "fl" Example 2:
   *
   * <p>Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no common prefix
   * among the input strings.
   *
   * <p>Constraints:
   *
   * <p>1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] consists of only lower-case
   * English letters.
   *
   * @param
   */

  // self attempt
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length < 1) return "";
    if (strs.length == 1) return strs[0];
    int shortestStringLength = strs[0].length();
    for (int i = 0; i < strs.length; i++)
      if (strs[i].length() < shortestStringLength) shortestStringLength = strs[i].length();
    char[] result = new char[shortestStringLength];
    for (int i = 0; i < strs.length; i++) {
      boolean checkRestArr = true;
      char[] compare = strs[i].toCharArray();
      for (int j = 0; j < result.length; j++) {
        if (i != 0) {
          if (result[j] == compare[j] && checkRestArr) {
            result[j] = compare[j];
          } else {
            result[j] = ' ';
            checkRestArr = false;
          }
        } else {
          result[j] = compare[j];
        }
      }
    }
    return String.valueOf(result).trim();
  }

  public static String longestCommonPrefixRecommended(String[] strs) {
    if (strs.length <= 0) return "";
    String prefix = strs[0];
    for (int i = 0; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
      }
    }
    return prefix;
  }

  public static void main(String[] args) {
    String[] ex = {"flower", "flow", "flight"};
    String[] ex2 = {"dog", "racecar", "car"};
    String[] ex3 = {"cir", "car"};
    String[] ex4 = {"c", "acc", "ccc"};
    System.out.println(longestCommonPrefix(ex));
    System.out.println(longestCommonPrefix(ex2));
    System.out.println(longestCommonPrefix(ex3));
    System.out.println(longestCommonPrefix(ex4));
  }
}
