package com.river.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class MininumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!sMap.containsKey(s.charAt(i)))
                sMap.put(c, 1);
            else
                sMap.put(c, sMap.get(c) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (sMap.containsKey(c) && sMap.get(c) > 0)
                sMap.put(c, sMap.get(c) - 1);
        }

        return sMap.entrySet().stream().map(Map.Entry<Character, Integer>::getValue).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        MininumNumberOfStepsToMakeTwoStringsAnagram m = new MininumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.println(m.minSteps("bab", "aba")); // 1
        System.out.println(m.minSteps("leetcode", "practice")); // 5
        System.out.println(m.minSteps("anagram", "mangaar")); // 0
    }
}
