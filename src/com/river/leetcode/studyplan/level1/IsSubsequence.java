package com.river.leetcode.studyplan.level1;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            char a = s.charAt(p1);
            char b = t.charAt(p2);
            if (a == b) {
                p1++;
                p2++;
            } else {
                p2++;
            }
        }

        return p1 == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence iss = new IsSubsequence();
        System.out.printf("1. %s\n", iss.isSubsequence("abc", "ahbgdc")); // true
        System.out.printf("2. %s\n", iss.isSubsequence("axc", "ahbgdc")); // false
    }
}
