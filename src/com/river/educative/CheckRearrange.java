package com.river.educative;

import java.util.Arrays;

public class CheckRearrange {
    public void reArrange(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx)
            return;
        int pivot = endIdx;
        int i = startIdx - 1, j = startIdx;
        int tmp;
        while (j <= pivot) {
            if (arr[j] < arr[pivot]) {
                i++;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            j++;
        }
        i++;
        // swap pivot to place
        tmp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = tmp;

        quickSort(arr, startIdx, i - 1);
        quickSort(arr, i + 1, endIdx);
    }

    public static void main(String[] args) {
        CheckRearrange chkr = new CheckRearrange();
        int[] arr = new int[] {10, -1, 20, 4, 5, -9, -6};
        chkr.reArrange(arr);
        System.out.printf("1. %s\n", Arrays.toString(arr));
    }
}
