package com.river.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int maxPalindrome = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxPalindrome += (entry.getValue() / 2) * 2;
            if (maxPalindrome % 2 == 0 && entry.getValue() % 2 != 0)
                maxPalindrome++;
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.printf("1. %s\n", lp.longestPalindrome("abccccdd"));
        System.out.printf("2. %s\n", lp.longestPalindrome("a"));
        System.out.printf("3. %s\n", lp.longestPalindrome("ccc"));
        System.out.printf("4. %s\n", lp.longestPalindrome("bananas"));
    }
}
