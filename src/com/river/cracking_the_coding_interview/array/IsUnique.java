package com.river.cracking_the_coding_interview.array;

public class IsUnique {
    public static boolean isUnique(String line) {
        int[] hasSeen = new int[26];
        for (int i = 0; i < line.length(); i++) {
            int pos = (int) line.charAt(i) - (int) 'a';
            hasSeen[pos]++;
            int seen = hasSeen[pos];
            if (seen > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String line = "abc";
        boolean res = isUnique(line);
        System.out.printf("res: %s, line: %s\n", res, line);

        line = "aaa";
        res = isUnique(line);
        System.out.printf("res: %s, line: %s\n", res, line);
    }
}
