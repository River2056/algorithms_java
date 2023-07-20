package com.river.educative;

import java.util.Arrays;

public class CheckRotateArray {

    public void rotateArray(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    public static void main(String[] args) {
        CheckRotateArray cr = new CheckRotateArray();

        int[] intArray = new int[] {1, 2, 3, 4, 5};
        cr.rotateArray(intArray);
        System.out.printf("1. %s\n", Arrays.toString(intArray));
    }
}
