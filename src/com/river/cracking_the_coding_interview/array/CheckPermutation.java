package com.river.cracking_the_coding_interview.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CheckPermutation {
  public static boolean checkPermutation(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }

    int[] check = new int[128];

    for (char c : a.toCharArray()) {
      check[c]++;
    }

    for (int i = 0; i < b.length(); i++) {
      char c = b.charAt(i);
      check[c]--;
      if (check[c] < 0) {
        return false;
      }
    }

    return true;
  }

  public static void checkPermutationSelf(String a, String b) {
    boolean check = validate(generateMap(a), generateMap(b));
    System.out.printf("check: %s\n", check);
  }

  private static Map<Character, Integer> generateMap(String line) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
    }
    return map;
  }

  private static boolean validate(Map<Character, Integer> aMap, Map<Character, Integer> bMap) {
    Iterator<Entry<Character, Integer>> it = aMap.entrySet().iterator();
    while (it.hasNext()) {
      Entry<Character, Integer> entry = it.next();
      if (!bMap.containsKey(entry.getKey())) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String a = "dog";
    String b = "god";
    System.out.printf("checkPermutation: %s\n", checkPermutation(a, b));
  }
}
