package com.river.leetcode.dynamicProgramming;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2)); // 1
        System.out.println(obj.sumRange(2, 5)); // -1
        System.out.println(obj.sumRange(0, 5)); // -3
    }
}


class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        this.sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            this.sum[i + 1] = this.sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
