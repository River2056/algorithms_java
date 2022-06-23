package com.river.leetcode.hashtable;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * dynamic programming approach s.length() = 8, dp[8] = true if we match everything,
         * dp[s.length()] will be true move the pointer backwards, check position + word length if
         * substring match wordDict, update dp[i] = d[i + word length] dp[8] = true dp[7] = false
         * ... dp[4] = dp[4 + 4] ... dp[0] = dp[0 + 4] return dp[0]
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && w.equals(s.substring(i, i + w.length())))
                    dp[i] = dp[i + w.length()];
                if (dp[i])
                    break;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        WordBreak word = new WordBreak();
        System.out.printf("1. %s\n", word.wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.printf("2. %s\n", word.wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.printf("3. %s\n",
                word.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
    }
}
