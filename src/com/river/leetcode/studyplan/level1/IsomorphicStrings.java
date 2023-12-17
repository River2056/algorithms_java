package com.river.leetcode.studyplan.level1;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Character> map = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char a = s.charAt(i);
      char b = t.charAt(i);
      if ((map.containsKey(a) && map.get(a) != b) || map2.containsKey(b) && map2.get(b) != a)
        return false;

      map.put(s.charAt(i), t.charAt(i));
      map2.put(t.charAt(i), s.charAt(i));
    }

    return true;
  }

  public static void main(String[] args) {
    IsomorphicStrings iso = new IsomorphicStrings();
    System.out.printf("1. %s\n", iso.isIsomorphic("egg", "add")); // true
    System.out.printf("2. %s\n", iso.isIsomorphic("foo", "bar")); // false
    System.out.printf("3. %s\n", iso.isIsomorphic("paper", "title")); // true
  }
}
