package com.river.leetcode.array;

import java.util.Arrays;

public class FindProductExceptSelf {
    public int[] findProduct(int[] arr) {
        if (arr != null && arr.length == 1)
            return arr;
        int pre = 1;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = pre;
            pre *= arr[i];
        }

        int post = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= post;
            post *= arr[i];
        }

        return res;
    }

    public static void printResult(int[] arr) {
        StringBuilder sb = new StringBuilder();
        System.out.print("[");
        Arrays.stream(arr).forEach(e -> System.out.printf("%s\t", e));
        System.out.print("]");
    }

    public static void main(String[] args) {
        FindProductExceptSelf fs = new FindProductExceptSelf();
        int[] res = fs.findProduct(new int[] {1, 2, 3, 4});
        printResult(res);
    }
}
