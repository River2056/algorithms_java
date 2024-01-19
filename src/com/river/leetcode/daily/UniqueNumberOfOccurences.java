package com.river.leetcode.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * UniqueNumberOfOccurences
 */
public class UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        Set<Integer> keys = map.entrySet().stream().map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        Set<Integer> values = map.entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toSet());

        return keys.size() == values.size();
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurences u = new UniqueNumberOfOccurences();
        System.out.println(u.uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 })); // true
        System.out.println(u.uniqueOccurrences(new int[] { 1, 2 })); // false
        System.out.println(u.uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 })); // true
    }
}
