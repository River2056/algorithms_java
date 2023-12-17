package com.river.leetcode.studyplan.level1;

import java.util.Arrays;

public class FloodFill {

  private int sourceColor;
  private boolean[][] visited;

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    sourceColor = image[sr][sc];
    visited = new boolean[image.length][image[0].length];
    int[][] res = Arrays.copyOf(image, image.length);
    dfs(res, sr, sc, color);
    return res;
  }

  private void dfs(int[][] image, int x, int y, int color) {
    if (x < 0 || x >= image.length || y < 0 || y >= image[x].length || visited[x][y]) return;
    if (x >= 0 && x < image.length && y >= 0 && y < image[x].length && image[x][y] == sourceColor) {
      image[x][y] = color;
      visited[x][y] = true;
      dfs(image, x - 1, y, color);
      dfs(image, x + 1, y, color);
      dfs(image, x, y - 1, color);
      dfs(image, x, y + 1, color);
    }

    visited[x][y] = true;
  }

  public void printImage(int[][] image) {
    for (int[] arr : image) {
      for (int n : arr) {
        System.out.printf("%s\t", n);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    FloodFill flood = new FloodFill();
    System.out.println("1. ");
    flood.printImage(flood.floodFill(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));

    System.out.println("2. ");
    flood.printImage(flood.floodFill(new int[][] {{0, 0, 0}, {0, 0, 0}}, 0, 0, 0));
  }
}
