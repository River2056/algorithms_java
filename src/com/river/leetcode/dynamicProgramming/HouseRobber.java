package com.river.leetcode.dynamicProgramming;

public class HouseRobber {
    
    // self attempt => TLE
    /* public int rob(int[] nums) {
        return count(nums, 0, nums.length - 1);
    }

    private int count(int[] houses, int left, int right) {
        if (left == right)
            return houses[left];
        if (Math.abs(left - right) == 1)
            return Math.max(houses[left], houses[right]);
        else 
            return Math.max(houses[left] + count(houses, left + 2, right), count(houses, left + 1, right));
    } */

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length + 1];
        dp[nums.length] = 0;
        dp[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        System.out.printf("1. %s\n", h.rob(new int[] {1, 2, 3, 1}));
        System.out.printf("2. %s\n", h.rob(new int[] {2, 7, 9, 3, 1}));
    }
}
