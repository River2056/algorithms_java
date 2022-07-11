package com.river.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                res.add(idx + 1);
            nums[idx] = -nums[idx];
        }

        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray find = new FindAllDuplicatesInAnArray();
        System.out.printf("1. %s\n", find.findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.printf("2. %s\n", find.findDuplicates(new int[] {1, 1, 2}));
        System.out.printf("3. %s\n", find.findDuplicates(new int[] {1}));
        System.out.printf("4. %s\n",
                find.findDuplicates(new int[] {10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
    }
}
