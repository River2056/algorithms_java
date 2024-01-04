package com.river.designguru.squaringsortedarray;

import java.util.Arrays;

public class Solution {
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];

        int firstPositive = 0;
        for (int i = 0; i < n; i++) {
            firstPositive = i;
            if (arr[i] >= 0)
                break;
        }

        int left = firstPositive - 1;
        int right = firstPositive;
        int k = 0;
        while (k != n) {
            int squareLeft = -1;
            int squareRight = -1;
            if (left >= 0)
                squareLeft = arr[left] * arr[left];

            if (right < n)
                squareRight = arr[right] * arr[right];

            if (squareLeft == -1 && squareRight != -1) {
                squares[k] = squareRight;
                right++;
                k++;
                continue;
            }

            if (squareLeft != -1 && squareRight == -1) {
                squares[k] = squareLeft;
                left--;
                k++;
                continue;
            }

            if (squareLeft != -1 && squareLeft <= squareRight) {
                squares[k] = squareLeft;
                left--;
            } else if (squareRight != -1 && squareLeft > squareRight) {
                squares[k] = squareRight;
                right++;
            }
            k++;
        }

        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[] { -2, -1, 0, 2, 3 }))); // 0, 1, 4, 4, 9
        System.out.println(Arrays.toString(makeSquares(new int[] { -3, -1, 0, 1, 2 }))); // 0, 1, 1, 4, 9
    }
}
