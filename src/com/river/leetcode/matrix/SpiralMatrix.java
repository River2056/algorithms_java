package com.river.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private int ROWS;
    private int COLS;
    private int dir;
    private int[] dirX = {1, 0, -1, 0};
    private int[] dirY = {0, 1, 0, -1};
    private boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        ROWS = matrix.length;
        COLS = matrix[0].length;
        dir = 0;
        visited = new boolean[ROWS][COLS];

        traverseMatrix(matrix, res, 0, 0);

        return res;
    }

    private void traverseMatrix(int[][] matrix, List<Integer> result, int rowIndex,
            int columnIndex) {
        if (result.size() == ROWS * COLS)
            return;

        if (rowIndex >= 0 && rowIndex < ROWS && columnIndex >= 0 && columnIndex < COLS
                && !visited[rowIndex][columnIndex]) {
            result.add(matrix[rowIndex][columnIndex]);
            visited[rowIndex][columnIndex] = true;
        }

        if (rowIndex + dirY[dir] < 0 || rowIndex + dirY[dir] >= ROWS || columnIndex + dirX[dir] < 0
                || columnIndex + dirX[dir] >= COLS
                || visited[rowIndex + dirY[dir]][columnIndex + dirX[dir]]) {
            dir++;
            dir %= 4;
        }

        traverseMatrix(matrix, result, rowIndex + dirY[dir], columnIndex + dirX[dir]);
    }

    public static void main(String[] args) {
        SpiralMatrix m = new SpiralMatrix();
        System.out.printf("1. %s\n", m.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        System.out.printf("2. %s\n",
                m.spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
