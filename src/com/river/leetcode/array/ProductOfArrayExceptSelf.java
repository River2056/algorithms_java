package com.river.leetcode.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;

    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf pes = new ProductOfArrayExceptSelf();

        int[] res = pes.productExceptSelf(new int[] {1, 2, 3, 4});
        System.out.printf("res: %s\n", Arrays.toString(res));

        res = pes.productExceptSelf(new int[] {-1, 1, 0, -3, 3});
        System.out.printf("res: %s\n", Arrays.toString(res));
    }
}
