package com.river.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int maxLength = 1;
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int currentLength = 0;
            for (int j = 0; j < words[i].length(); j++) {
                StringBuilder sb = new StringBuilder(words[i]);
                sb.deleteCharAt(j);
                String predecessor = sb.toString();
                Integer prevLength = dp.getOrDefault(predecessor, 0);
                currentLength = Math.max(currentLength, prevLength + 1);
            }
            dp.put(words[i], currentLength);
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestStringChain l = new LongestStringChain();
        System.out.printf("1. %s\n", l.longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"})); // 4
        System.out.printf("2. %s\n", l.longestStrChain(new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"})); // 5
        System.out.printf("3. %s\n", l.longestStrChain(new String[] {"abcd","dbqca"})); // 1
    }
}
