package com.river.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
            missing ^= i ^ nums[i];

        return missing;
    }

    public int missingNumberSetSolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();

        System.out.printf("res: %s\n", mn.missingNumber(new int[] {3, 0, 1})); // 2
        System.out.printf("res: %s\n", mn.missingNumber(new int[] {0, 1})); // 2
        System.out.printf("res: %s\n", mn.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
    }
}
