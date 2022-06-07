package com.river.leetcode.backtrack;

public class WordSearch {
    private static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (word.charAt(0) == board[i][j] && dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int index, String word, char[][] board) {
        // found word
        if (index == word.length()) {
            return true;
        }

        // boundary checks
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || word.charAt(index) != board[r][c] || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        // starting point and reach out to neighbors to find word
        // see if the next word is in one of the neighbors
        boolean res = dfs(r + 1, c, index + 1, word, board) || dfs(r - 1, c, index + 1, word, board)
                || dfs(r, c + 1, index + 1, word, board) || dfs(r, c - 1, index + 1, word, board);

        visited[r][c] = false;

        return res;
    }


    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        boolean res =
                wordSearch.exist(
                        new char[][] {new char[] {'A', 'B', 'C', 'E'},
                                new char[] {'S', 'F', 'C', 'S'}, new char[] {'A', 'D', 'E', 'E'}},
                        "ABCCED");
        System.out.printf("res: %s\n", res); // true

        res = wordSearch.exist(new char[][] {new char[] {'A', 'B', 'C', 'E'},
                new char[] {'S', 'F', 'C', 'S'}, new char[] {'A', 'D', 'E', 'E'}}, "SEE");
        System.out.printf("res: %s\n", res); // true

        res = wordSearch.exist(new char[][] {new char[] {'A', 'B', 'C', 'E'},
                new char[] {'S', 'F', 'C', 'S'}, new char[] {'A', 'D', 'E', 'E'}}, "ABCB");
        System.out.printf("res: %s\n", res); // false
    }
}
