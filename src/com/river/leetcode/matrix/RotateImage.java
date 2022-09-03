package com.river.leetcode.matrix;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int size = matrix.length / 2;
    int inner = matrix[0].length - 1;
    int length = matrix[0].length;

    for (int i = 0; i < size; i++) {
      for (int j = i; j < inner - i; j++) {
        // A <=> B
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][length - 1 - i];
        matrix[j][length - 1 - i] = tmp;

        // A <=> C
        tmp = matrix[i][j];
        matrix[i][j] = matrix[length - 1 - i][length - 1 - j];
        matrix[length - 1 - i][length - 1 - j] = tmp;

        // A <=> D
        tmp = matrix[i][j];
        matrix[i][j] = matrix[length - 1 - j][i];
        matrix[length - 1 - j][i] = tmp;
      }
    }
  }

  private void test() {
    int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println("test");
    System.out.println("before: ");
    printMatrix(matrix);
    rotate(matrix);
    System.out.println("after: ");
    printMatrix(matrix);
  }

  private void test2() {
    int[][] matrix = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    System.out.println("test2");
    System.out.println("before: ");
    printMatrix(matrix);
    rotate(matrix);
    System.out.println("after: ");
    printMatrix(matrix);
  }

  private void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int n : arr) {
        System.out.printf("%s\t", n);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    RotateImage rotate = new RotateImage();
    // rotate.test();
    rotate.test2();
  }
}
