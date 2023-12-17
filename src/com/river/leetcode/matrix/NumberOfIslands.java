package com.river.leetcode.matrix;

public class NumberOfIslands {
  private int ROW;
  private int COL;
  private boolean[][] visited;

  public int numIslands(char[][] grid) {
    ROW = grid.length;
    COL = grid[0].length;
    visited = new boolean[ROW][COL];

    int islands = 0;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        islands += dfs(islands, grid, i, j, visited);
      }
    }

    return islands;
  }

  private int dfs(int islands, char[][] grid, int x, int y, boolean[][] visited) {
    if (x < 0 || x >= ROW || y < 0 || y >= COL || grid[x][y] != '1' || visited[x][y]) return 0;

    visited[x][y] = true;
    dfs(islands, grid, x + 1, y, visited);
    dfs(islands, grid, x - 1, y, visited);
    dfs(islands, grid, x, y + 1, visited);
    dfs(islands, grid, x, y - 1, visited);
    return 1;
  }

  public static void main(String[] args) {
    NumberOfIslands n = new NumberOfIslands();
    System.out.printf(
        "1. %s\n",
        n.numIslands(
            new char[][] {
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '0', '0', '0'}
            })); // 1

    System.out.printf(
        "2. %s\n",
        n.numIslands(
            new char[][] {
              {'1', '1', '0', '0', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '1', '0', '0'},
              {'0', '0', '0', '1', '1'}
            })); // 3
  }
}
