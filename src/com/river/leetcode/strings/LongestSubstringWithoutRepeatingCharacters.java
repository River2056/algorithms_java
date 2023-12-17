package com.river.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int length = s.length();
    int max = 0;
    for (int i = 0, j = 0; j < length; j++) {
      char c = s.charAt(j);
      if (map.containsKey(c)) {
        i = Math.max(i, map.get(c) + 1);
      }
      max = Math.max(max, j - i + 1);
      map.put(c, j);
    }

    return max;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters ls =
        new LongestSubstringWithoutRepeatingCharacters();

    int res = ls.lengthOfLongestSubstring("abcabcbb");
    System.out.printf("res: %s\n", res);

    res = ls.lengthOfLongestSubstring("bbbbb");
    System.out.printf("res: %s\n", res);

    res = ls.lengthOfLongestSubstring("pwwkew");
    System.out.printf("res: %s\n", res);

    res = ls.lengthOfLongestSubstring(" ");
    System.out.printf("res: %s\n", res);
  }
}
