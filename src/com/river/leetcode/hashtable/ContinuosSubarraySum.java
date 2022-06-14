package com.river.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContinuosSubarraySum {
    public boolean checkSubarraySumBrute(int[] nums, int k) {
        if (k == 0)
            return true;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int[] n = Arrays.copyOfRange(nums, i, j + 1);
                System.out.printf("n: %s\n", Arrays.toString(n));
                int total = Arrays.stream(n).reduce((a, b) -> a + b).getAsInt();
                if (total % k == 0)
                    return true;
            }
        }

        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        // initialize a zero value to pevent returning array with one value
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int remainder = total % k;
            if (map.containsKey(remainder)) {
                int originalIndex = map.get(remainder);
                if (i - originalIndex > 1)
                    return true;
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuosSubarraySum css = new ContinuosSubarraySum();

        boolean res = css.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6);
        System.out.printf("res: %s\n", res); // true

        res = css.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 6);
        System.out.printf("res: %s\n", res); // true

        res = css.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 13);
        System.out.printf("res: %s\n", res); // false

        res = css.checkSubarraySum(new int[] {0, 0}, 1);
        System.out.printf("res: %s\n", res); // true

        res = css.checkSubarraySum(new int[] {23, 2, 4, 6, 6}, 7);
        System.out.printf("res: %s\n", res); // true
    }
}
