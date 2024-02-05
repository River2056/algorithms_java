package com.river.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * FirstUniqueCharacterInAString
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> earliestMap = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = i;
            earliestMap.computeIfAbsent(c, k -> index);

            if (!freqMap.containsKey(c))
                freqMap.put(c, 1);
            else
                freqMap.put(c, freqMap.get(c) + 1);

        }

        return freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(charKey -> earliestMap.get(charKey))
                .min((a, b) -> a - b)
                .orElse(-1);
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar("leetcode")); // 0
        System.out.println(f.firstUniqChar("loveleetcode")); // 2
        System.out.println(f.firstUniqChar("aabb")); // -1
    }
}
