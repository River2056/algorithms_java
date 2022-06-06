package com.river;

import java.util.Scanner;

public class PrintDiamond {
    public static char[][] printDiamond(int width) {
        char[][] container = new char[width][width];
        int startIndex = 0;
        int minWidth = 1;
        return printDiamond(width, minWidth, container, startIndex);
    }

    public static char[][] printDiamond(int width, int minWidth, char[][] container,
            int startIndex) {
        if (width <= 0) {
            return container;
        }

        if (minWidth < width) {
            char[] stars = new char[width];
            int space = (width - minWidth) / 2;
            int star = stars.length - space;
            int i = 0;

            while (i < space) {
                stars[i] = ' ';
                i++;
            }
            for (int j = i; j < star; j++) {
                stars[i] = '*';
                i++;
            }
            while (i < stars.length) {
                stars[i] = ' ';
                i++;
            }

            container[startIndex] = stars;
            startIndex++;
            return printDiamond(width, minWidth + 2, container, startIndex);
        } else {
            char[] stars = new char[minWidth];
            int space = (minWidth - width) / 2;

            if (space != 0) {
                int i = 0;

                while (i < space) {
                    stars[i] = ' ';
                    i++;
                }
                int star = stars.length - space;
                for (int j = i; j < star; j++) {
                    stars[j] = '*';
                    i++;
                }
                while (i < stars.length) {
                    stars[i] = ' ';
                    i++;
                }

                container[startIndex++] = stars;
            } else {
                for (int i = 0; i < stars.length; i++) {
                    stars[i] = '*';
                }

                container[startIndex++] = stars;
            }
            return printDiamond(width - 2, minWidth, container, startIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter diamond height: ");
        try (Scanner sc = new Scanner(System.in)) {

            int height = sc.nextInt();
            char[][] arr = printDiamond(height + (height - 1));

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}
