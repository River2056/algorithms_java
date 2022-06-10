package com.river.leetcode.strings;

import java.util.Arrays;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int removeCount = 0;
        int columns = strs[0].length();
        int rows = strs.length;

        for (int i = 0; i < columns; i++) {
            char[] chrs = new char[rows];
            char[] compare = new char[rows];
            for (int j = 0; j < rows; j++) {
                chrs[j] = strs[j].charAt(i);
                compare[j] = strs[j].charAt(i);
            }
            Arrays.sort(compare);

            for (int j = 0; j < chrs.length; j++)
                if (chrs[j] != compare[j]) {
                    removeCount++;
                    break;
                }
        }

        return removeCount;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted dcs = new DeleteColumnsToMakeSorted();

        int res = dcs.minDeletionSize(new String[] {"cba", "daf", "ghi"});
        System.out.printf("res: %s\n", res); // 1

        res = dcs.minDeletionSize(new String[] {"a", "b"});
        System.out.printf("res: %s\n", res); // 0

        res = dcs.minDeletionSize(new String[] {"zyx", "wvu", "tsr"});
        System.out.printf("res: %s\n", res); // 3
    }
}
