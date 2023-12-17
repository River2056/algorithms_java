package com.river.designguru.containsduplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i : nums)
            seen.add(i);

        return seen.size() != nums.length;
    }

    public static void main(String[] args) {
        Solution c = new Solution();
        System.out.println(c.containsDuplicate(new int[] {1, 2, 3, 4})); // false
        System.out.println(c.containsDuplicate(new int[] {1, 2, 3, 1})); // true
    }
}
