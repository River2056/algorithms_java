package com.river.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            if (map.containsKey(ct))
                map.put(ct, map.get(ct) - 1);
            else
                return false;
        }

        return map.values().stream().allMatch(e -> e == 0);
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";
        boolean res = va.isAnagram(s, t);
        System.out.printf("res: %s\n", res); // true

        s = "rat";
        t = "car";
        res = va.isAnagram(s, t);
        System.out.printf("res: %s\n", res); // false
    }
}
