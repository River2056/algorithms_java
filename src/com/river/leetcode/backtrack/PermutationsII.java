package com.river.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PermutationsII
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            if (!counter.containsKey(n))
                counter.put(n, 0);
            counter.put(n, counter.get(n) + 1);
        }

        dfs(counter, temp, nums.length, results);
        return results;

    }

    private void dfs(Map<Integer, Integer> counter, List<Integer> temp, int length, List<List<Integer>> results) {
        if (temp.size() == length) {
            List<Integer> path = new ArrayList<>(temp);
            results.add(path);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer freq = entry.getValue();

            if (freq == 0)
                continue;

            temp.add(num);
            counter.put(num, freq - 1);

            dfs(counter, temp, length, results);

            temp.remove(temp.size() - 1);
            counter.put(num, freq);
        }
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        System.out.println(p.permuteUnique(new int[] { 1, 1, 2 }));
        System.out.println(p.permuteUnique(new int[] { 1, 2, 3 }));
    }
}
