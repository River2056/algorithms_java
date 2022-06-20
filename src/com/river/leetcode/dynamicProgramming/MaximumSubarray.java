package com.river.leetcode.dynamicProgramming;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray max = new MaximumSubarray();

        System.out.printf("res: %s\n", max.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.printf("res: %s\n", max.maxSubArray(new int[] {1})); // 1
        System.out.printf("res: %s\n", max.maxSubArray(new int[] {5, 4, -1, 7, 8})); // 23
        System.out.printf("res: %s\n", max.maxSubArray(new int[] {-1})); // -1
    }
}
