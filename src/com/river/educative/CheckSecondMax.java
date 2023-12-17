package com.river.educative;

import java.util.Arrays;

public class CheckSecondMax {

    public int findSecondMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        CheckSecondMax c = new CheckSecondMax();
        System.out.printf("1. %s\n", c.findSecondMaximum(new int[] {9, 2, 3, 6}));
        System.out.printf("2. %s\n", c.findSecondMaximum(new int[] {4, 2, 1, 5, 0}));
    }
}
