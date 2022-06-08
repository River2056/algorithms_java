package com.river.leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        // rows
        for (int i = 0; i < board.length; i++) {
            valid = hasUniqueElements(board[i]);
            if (!valid)
                return valid;
        }

        // columns
        for (int i = 0; i < board.length; i++) {
            char[] columns = new char[board.length];
            for (int j = 0; j < board[i].length; j++) {
                columns[j] = board[j][i];
            }
            valid = hasUniqueElements(columns);
            if (!valid)
                return valid;
        }

        // 3*3
        for (int i = 0; i < board.length; i += 3) {
            char[] grid = new char[board.length];
            for (int j = 0; j < board[i].length; j += 3) {
                for (int k = 0; k < board.length; k++) {
                    grid[k] = board[j + (k / 3)][i + (k % 3)];
                }
                valid = hasUniqueElements(grid);
                if (!valid)
                    return valid;
            }
        }
        return valid;
    }

    private boolean hasUniqueElements(char[] arr) {
        Set<Character> set = new HashSet<>();
        int countElements = 0;
        for (char c : arr) {
            if (c != '.')
                countElements++;
        }

        int idx = 0;
        char[] chr = new char[countElements];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '.') {
                chr[idx++] = arr[i];
                set.add(arr[i]);
            }
        }

        return chr.length == set.size();
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();

        char[][] board = new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean res = vs.isValidSudoku(board);
        System.out.printf("res: %s\n", res); // true

        board = new char[][] {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        res = vs.isValidSudoku(board);
        System.out.printf("res: %s\n", res); // false

        board = new char[][] {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        res = vs.isValidSudoku(board);
        System.out.printf("res: %s\n", res); // false
    }
}


