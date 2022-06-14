package com.river.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairsInArray {
    /**
     * didn't work, have to handle k == 0 scenario
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findPairsSelf(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i] - k, i);
        System.out.printf("map: %s\n", map);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] n = new int[] {nums[map.get(nums[i])], nums[i]};
                Arrays.sort(n);
                set.add(Arrays.toString(n));
            }
        }

        return set.size();
    }

    public int findPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Integer key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(key + k))
                    res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        KDiffPairsInArray kdiff = new KDiffPairsInArray();

        // int res = kdiff.findPairs(new int[] {3, 1, 4, 1, 5}, 2);
        // System.out.printf("res: %s\n", res); // 2

        // res = kdiff.findPairs(new int[] {1, 2, 3, 4, 5}, 1);
        // System.out.printf("res: %s\n", res); // 4

        int res = kdiff.findPairs(new int[] {1, 3, 1, 5, 4}, 0);
        System.out.printf("res: %s\n", res); // 1
    }
}
