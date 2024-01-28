package com.river.leetcode.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * recursive solution but TLE
 */
public class OutOfBoundaryPaths {

    private int rows = 0;
    private int cols = 0;
    private int mod = (int) (Math.pow(10.0, 9.0)) + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        rows = m;
        cols = n;
        int[][][] cache = new int[m][n][maxMove + 1];
        for (int[][] arr : cache)
            for (int[] a : arr)
                Arrays.fill(a, -1);
        return dfs(startRow, startColumn, maxMove, cache);
    }

    private int dfs(int row, int col, int moves, int[][][] cache) {
        if (row < 0 || row == rows || col < 0 || col == cols)
            return 1;
        if (moves == 0)
            return 0;

        if (cache[row][col][moves] > 0)
            return cache[row][col][moves];

        int moveMinusOne = moves - 1;
        int valueUp = dfs(row - 1, col, moveMinusOne, cache);
        int valueDown = dfs(row + 1, col, moveMinusOne, cache);
        int valueLeft = dfs(row, col - 1, moveMinusOne, cache);
        int valueRight = dfs(row, col + 1, moveMinusOne, cache);
        cache[row][col][moves] = (((valueUp + valueDown) % mod) + ((valueLeft + valueRight) % mod)) % mod;
        return cache[row][col][moves];
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths o = new OutOfBoundaryPaths();

        System.out.println(o.findPaths(2, 2, 2, 0, 0)); // 6
        System.out.println(o.findPaths(1, 3, 3, 0, 1)); // 12

    }
}
