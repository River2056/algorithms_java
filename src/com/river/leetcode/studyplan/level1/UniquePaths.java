package com.river.leetcode.studyplan.level1;

import java.util.Arrays;

public class UniquePaths {

  public int uniquePaths(int m, int n) {
    int[][] grid = new int[m][n];
    for (int[] arr : grid) Arrays.fill(arr, 1);

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
      }
    }

    return grid[m - 1][n - 1];
  }

  public static void main(String[] args) {
    UniquePaths uni = new UniquePaths();
    System.out.printf("1. %s\n", uni.uniquePaths(3, 7)); // 28
    System.out.printf("2. %s\n", uni.uniquePaths(3, 2)); // 3
    System.out.printf("3. %s\n", uni.uniquePaths(23, 12)); // 193536720
  }
}
