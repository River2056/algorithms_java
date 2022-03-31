package com.river.leetcode.array;

import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    /**
     *  brute force
     **/
    // public static int[] twoSum(int[] nums, int target) {
    //     for(int i = 0; i < nums.length; i++) {
    //         int diff = target - nums[i];
    //         for(int j = i + 1; j < nums.length; j++) {
    //             if(diff == nums[j]) {
    //                 return new int[] { i, j };
    //             }
    //         }
    //     }

    //     return null;
    // }
    
    /**
     *  optimize version
     **/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            } else {
                int diff = target - nums[i];
                map.put(diff, i);
            }
        }
        return null;
    }

    public static void printResult(int[] arr) {
        System.out.print("[");
        for(int i: arr) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println("]");
    }

     public static void main(String[] args) {
        // brute force
        int[] nums = { 1, 3, 7, 9, 2 };
        int target = 11;
        int[] result = twoSum(nums, target);
        System.out.println("result: ");
        printResult(result);

        nums = new int[] { 2, 7, 5, 3 };
        target = 9;
        result = twoSum(nums, target);
        System.out.println("result: ");
        printResult(result);
     }
}
