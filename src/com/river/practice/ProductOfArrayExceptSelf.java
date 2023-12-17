package com.river.practice;

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
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = res[i] * postfix;
      postfix *= nums[i];
    }

    return res;
  }

  public static void main(String[] args) {
    ProductOfArrayExceptSelf prod = new ProductOfArrayExceptSelf();
    System.out.printf("1. %s\n", Arrays.toString(prod.productExceptSelf(new int[] {1, 2, 3, 4})));
    System.out.printf(
        "2. %s\n", Arrays.toString(prod.productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
  }
}
