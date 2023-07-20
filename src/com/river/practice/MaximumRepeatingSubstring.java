package com.river.practice;

public class MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        int result = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int count = 0, k = 0;
            for (int j = i; j < sequence.length(); j++) {
                if (sequence.charAt(j) == word.charAt(k)) k++;
                else break;
                if (k == word.length()) {
                    k = 0;
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumRepeatingSubstring m = new MaximumRepeatingSubstring();
        System.out.printf("1. %s\n", m.maxRepeating("ababc", "ab"));
        System.out.printf("2. %s\n", m.maxRepeating("ababc", "ba"));
        System.out.printf("3. %s\n", m.maxRepeating("ababc", "ac"));
        System.out.printf("4. %s\n", m.maxRepeating("abcabcab", "abc"));
        System.out.printf("5. %s\n", m.maxRepeating("ccc", "c"));
    }
}
