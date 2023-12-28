package com.river.designguru.tripletsumtozero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Set<List<Integer>> sets = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            Integer a = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int b = arr[left];
                int c = arr[right];
                int sum = a + b + c;
                if (sum == 0) {
                    sets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(sets);
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
        System.out.println(searchTriplets(new int[] { 0, 0, 0 }));
    }
}
