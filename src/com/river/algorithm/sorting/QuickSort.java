package com.river.algorithm.sorting;

public class QuickSort {
  public static void quickSort(int[] arr, int begin, int end) {
    if (begin < end) {
      int pivot = arr[end];
      int i = begin - 1;
      for (int j = begin; j < end; j++) {
        if (arr[j] < pivot) {
          int tmp = arr[++i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
      int tmp = arr[++i];
      arr[i] = pivot;
      arr[end] = tmp;

      quickSort(arr, begin, i - 1);
      quickSort(arr, i + 1, end);
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 9, 4, 0, 1, 5, 6, 8, 7};
    System.out.printf("%-10s", "before: ");
    for (int n : arr) System.out.printf("%s\t", n);
    System.out.println();
    quickSort(arr, 0, arr.length - 1);
    System.out.printf("%-10s", "after: ");
    for (int n : arr) System.out.printf("%s\t", n);
  }
}
