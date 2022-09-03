package com.river.leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    boolean firstRow = false;
    boolean firstCol = false;

    for (int i = 0; i < matrix[0].length; i++) if (matrix[0][i] == 0) firstRow = true;

    for (int i = 0; i < matrix.length; i++) if (matrix[i][0] == 0) firstCol = true;

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++)
      for (int j = 1; j < matrix[i].length; j++)
        if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;

    if (firstRow) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;

    if (firstCol) for (int j = 0; j < matrix.length; j++) matrix[j][0] = 0;
  }

  public void setZeroesSelfAdditionalSpace(int[][] matrix) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (rows.contains(i) || cols.contains(j)) matrix[i][j] = 0;
      }
    }
  }

  private void test() {
    int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

    System.out.println("before: ");
    print_matrix(matrix);
    setZeroes(matrix);

    System.out.println("after: ");
    print_matrix(matrix);
  }

  private void test2() {
    int[][] matrix = {
      {0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5},
    };

    System.out.println("before: ");
    print_matrix(matrix);
    setZeroes(matrix);

    System.out.println("after: ");
    print_matrix(matrix);
  }

  private void print_matrix(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int n : arr) System.out.printf("%s\t", n);
      System.out.println();
    }
  }

  public static void main(String[] args) {
    SetMatrixZeroes set = new SetMatrixZeroes();
    set.test();
    set.test2();
  }
}
