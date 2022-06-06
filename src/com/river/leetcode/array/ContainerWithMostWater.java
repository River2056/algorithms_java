package com.river.leetcode.array;

public class ContainerWithMostWater {
    @FunctionalInterface
    interface CustomFunction {
        int apply(int[] inputs);
    }

    public static void printResult(int[] input, int expectedOutput, CustomFunction fn) {
        int result = fn.apply(input);
        System.out.printf("result: %s%n", result);
        if (result != expectedOutput)
            throw new RuntimeException(
                    String.format("should be %s, got %s instead", expectedOutput, result));
    }

    // brute force
    public static int containerWithMostWaterBrute(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // optimal
    public static int containerWithMostWater(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int w = Math.abs(j - i);
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, (w * h));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        CustomFunction fn = heights -> containerWithMostWater(heights);
        printResult(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49, fn);
        printResult(new int[] {7, 1, 2, 3, 9}, 28, fn);
        printResult(new int[] {1, 2, 3, 4, 5}, 6, fn);
    }
}


