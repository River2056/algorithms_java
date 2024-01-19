package com.river.leetcode.daily;

import java.util.Arrays;
import java.util.Objects;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1] = Arrays.copyOf(matrix[rows - 1], matrix[rows - 1].length);

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                int min = Arrays.asList(
                        getCellVal(dp, i + 1, j - 1),
                        getCellVal(dp, i + 1, j),
                        getCellVal(dp, i + 1, j + 1))
                        .stream()
                        .filter(Objects::nonNull)
                        .min((a, b) -> a - b)
                        .orElse(Integer.MAX_VALUE);

                dp[i][j] = matrix[i][j] + min;
            }
        }

        for (int i = 0; i < dp[0].length; i++)
            if (dp[0][i] < result)
                result = dp[0][i];

        return result;
    }

    private Integer getCellVal(int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
            return null;
        return matrix[row][col];
    }

    public static void main(String[] args) {
        MinimumFallingPathSum m = new MinimumFallingPathSum();
        System.out.println(m.minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } })); // 13
        System.out.println(m.minFallingPathSum(new int[][] { { -19, 57 }, { -40, -5 } })); // -59
    }
}
