package com.river.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            List<String> groups;
            String key = String.join("", Arrays.stream(s.split("")).sorted().collect(Collectors.toList()));
            if (!map.containsKey(key))
                groups = new ArrayList<>();
            else
                groups = map.get(key);

            groups.add(s);
            map.put(key, groups);
        }

        return map.entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        System.out.println(g.groupAnagrams(new String[] { "" }));
        System.out.println(g.groupAnagrams(new String[] { "a" }));
    }
}
