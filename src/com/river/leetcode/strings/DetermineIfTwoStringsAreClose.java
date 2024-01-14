package com.river.leetcode.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DetermineIfTwoStringsAreClose {
    private Map<Character, Integer> createFreqMap(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!freqMap.containsKey(c))
                freqMap.put(c, 1);
            else
                freqMap.put(c, freqMap.get(c) + 1);
        }
        return freqMap;
    }

    private boolean validateCanTransform(Map<Character, Integer> map, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()))
                return false;
        }
        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map = createFreqMap(word1);
        Map<Character, Integer> map2 = createFreqMap(word2);

        if (!validateCanTransform(map, map2))
            return false;

        List<Integer> list = map.entrySet().stream().map(Map.Entry<Character, Integer>::getValue)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> list2 = map2.entrySet().stream().map(Map.Entry<Character, Integer>::getValue)
                .sorted()
                .collect(Collectors.toList());
        return list.equals(list2);
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose d = new DetermineIfTwoStringsAreClose();
        System.out.println(d.closeStrings("abc", "bca"));
        System.out.println(d.closeStrings("a", "aa"));
        System.out.println(d.closeStrings("cabbba", "abbccc"));
    }
}
