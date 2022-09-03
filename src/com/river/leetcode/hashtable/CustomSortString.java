package com.river.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

  // self implemented with hints, which appears to be the optimal solution
  public String customSortString(String order, String s) {
    StringBuilder res = new StringBuilder();

    // count characters in s, build map
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (map.containsKey(c)) map.put(c, map.get(c) + 1);
      else map.put(c, 1);
    }

    for (int i = 0; i < order.length(); i++) {
      Character co = order.charAt(i);
      if (map.containsKey(co)) {
        Integer freq = map.get(co);
        for (int j = 0; j < freq; j++) res.append(co);

        map.remove(co);
      }
    }

    // add remaining keys
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      Character c = entry.getKey();
      Integer freq = entry.getValue();
      for (int i = 0; i < freq; i++) res.append(c);
    }

    return res.toString();
  }

  // self implemented, accepted answer (not sure if optimal)
  public String customSortStringSelf(String order, String s) {
    if (order == null || "".equals(order)) return s;

    StringBuilder res = new StringBuilder();
    for (String o : order.split("")) {
      while (s.contains(o)) {
        res.append(o);
        int index = s.indexOf(o);
        if (index > 0) {
          s = s.substring(0, index) + s.substring(index + 1);
        } else if (index == 0) {
          s = s.substring(index + 1);
        }
      }
    }

    res.append(s);

    return res.toString();
  }

  public static void main(String[] args) {
    CustomSortString c = new CustomSortString();
    System.out.printf("1. %s\n", c.customSortString("cba", "abcd"));
    System.out.printf("2. %s\n", c.customSortString("cbafg", "abcd"));
  }
}
