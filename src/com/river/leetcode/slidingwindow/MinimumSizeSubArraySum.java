package com.river.leetcode.slidingwindow;

/**
 * MinimumSizeSubArraySum
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= target) {
                result = Math.min(result, i + 1 - left);
                currentSum -= nums[left++];
            }
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
        System.out.println(m.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 })); // 2
        System.out.println(m.minSubArrayLen(4, new int[] { 1, 4, 4 })); // 1
        System.out.println(m.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 })); // 0
    }
}
