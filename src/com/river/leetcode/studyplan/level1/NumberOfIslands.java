package com.river.leetcode.studyplan.level1;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
  private boolean[][] visited;
  private int rows;
  private int cols;

  public int numIslands(char[][] grid) {
    if (grid == null) return 0;

    rows = grid.length;
    cols = grid[0].length;
    visited = new boolean[rows][cols];
    int islands = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          bfs(grid, i, j);
          islands++;
        }
      }
    }

    return islands;
  }

  private void bfs(char[][] grid, int x, int y) {

    Queue<Cord> queue = new ArrayDeque<>();
    visited[x][y] = true;
    queue.add(new Cord(x, y));

    while (queue.size() > 0) {
      Cord cord = queue.poll();
      Cord[] directions =
          new Cord[] {new Cord(1, 0), new Cord(-1, 0), new Cord(0, 1), new Cord(0, -1)}; // right,
      // left,
      // up,
      // down

      for (Cord dir : directions) {
        int nextx = cord.x + dir.x;
        int nexty = cord.y + dir.y;
        if (nextx >= 0
            && nextx < rows
            && nexty >= 0
            && nexty < cols
            && grid[nextx][nexty] == '1'
            && !visited[nextx][nexty]) {
          queue.add(new Cord(nextx, nexty));
          visited[nextx][nexty] = true;
        }
      }
    }
  }

  private void test() {
    char[][] grid = {
      {'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}
    };
    System.out.printf("1. %s\n", numIslands(grid)); // 1
  }

  private void test2() {
    char[][] grid = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };
    System.out.printf("2. %s\n", numIslands(grid)); // 3
  }

  public static void main(String[] args) {
    NumberOfIslands num = new NumberOfIslands();
    num.test();
    num.test2();
  }
}

class Cord {
  int x;
  int y;

  public Cord(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
