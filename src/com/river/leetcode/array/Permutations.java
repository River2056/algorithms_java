package com.river.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    @FunctionalInterface
    interface CustomFunction {
        List<List<Integer>> apply(int[] nums);
    }

    /**
     * reference https://www.youtube.com/watch?v=4FdPoW4Qzb4
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, result);
        return result;
    }

    private static void dfs(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            dfs(i + 1, nums, result);

            // swap back
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /**
     * permutations neet code solution
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteNeetCode(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> nl = new ArrayList<>();
            nl.add(nums[0]);
            res.add(nl);
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] numsExceptN = new int[nums.length - 1];
            int j = 0, k = 0;
            while (j < nums.length) {
                if (nums[j] != n) {
                    numsExceptN[k] = nums[j];
                    k++;
                }
                j++;
            }

            List<List<Integer>> perms = permuteNeetCode(numsExceptN);
            for (List<Integer> perm : perms) {
                perm.add(n);
            }
            res.addAll(perms);
        }

        return res;
    }

    public static void printResult(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        if (result == null) {
            System.out.println("result is empty!");
            return;
        }

        sb.append("[");
        for (int i = 0; i < result.size(); i++) {
            sb.append("[");
            for (int j = 0; j < result.get(i).size(); j++) {
                sb.append(result.get(i).get(j));
                if (j != result.get(i).size() - 1)
                    sb.append(", ");
            }
            sb.append("]");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

    public static void testCase(int[] testInput, CustomFunction fn) {
        List<List<Integer>> res = fn.apply(testInput);
        printResult(res);
    }

    public static void main(String[] args) {
        // CustomFunction neetCode = nums -> permuteNeetCode(nums);
        // testCase(new int[] {1, 2, 3}, neetCode);
        // testCase(new int[] {0, 1}, neetCode);
        // testCase(new int[] {1}, neetCode);

        CustomFunction backTrackFn = nums -> permute(nums);
        testCase(new int[] {1, 2, 3}, backTrackFn);
        testCase(new int[] {0, 1}, backTrackFn);
        testCase(new int[] {1}, backTrackFn);
    }
}
