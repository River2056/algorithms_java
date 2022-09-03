package com.river.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      int[] count = new int[26];
      for (char c : strs[i].toCharArray()) count[(int) c - (int) 'a']++;

      StringBuilder sb = new StringBuilder();
      for (int elem : count) {
        sb.append("#");
        sb.append(String.valueOf(elem));
      }

      String key = sb.toString();
      List<String> lst = null;
      if (map.containsKey(key)) {
        lst = map.get(key);
        lst.add(strs[i]);
        map.put(key, lst);
      } else {
        lst = new ArrayList<>();
        lst.add(strs[i]);
        map.put(key, lst);
      }
    }

    return map.values().stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    GroupAnagrams gp = new GroupAnagrams();
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = gp.groupAnagrams(strs);
    System.out.printf("res: %s\n", res);

    strs = new String[] {""};
    res = gp.groupAnagrams(strs);
    System.out.printf("res: %s\n", res);

    strs = new String[] {"a"};
    res = gp.groupAnagrams(strs);
    System.out.printf("res: %s\n", res);

    strs = new String[] {"bdddddddddd", "bbbbbbbbbbc"};
    res = gp.groupAnagrams(strs);
    System.out.printf("res: %s\n", res);
  }
}
