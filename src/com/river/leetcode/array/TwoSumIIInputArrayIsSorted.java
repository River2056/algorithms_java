package com.river.leetcode.array;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int pl = 0, pr = numbers.length - 1;
        while (pl < pr) {
            int sum = numbers[pl] + numbers[pr];
            if (sum > target)
                pr--;
            else if (sum < target)
                pl++;
            else
                return new int[] {pl + 1, pr + 1};
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted two = new TwoSumIIInputArrayIsSorted();

        int[] res = two.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.printf("res: %s\n", Arrays.toString(res));

        res = two.twoSum(new int[] {2, 3, 4}, 6);
        System.out.printf("res: %s\n", Arrays.toString(res));
    }
}
