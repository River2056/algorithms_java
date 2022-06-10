package com.river.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i])
                twoSumII(nums, i, res);
        }

        return res;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum > 0)
                hi--;
            else if (sum < 0)
                lo++;
            else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    lo++;
            }
        }
    }

    public List<List<Integer>> threeSumBrute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int pl = i + 1; pl < nums.length; pl++) {
                for (int pr = pl + 1; pr < nums.length; pr++) {
                    if (nums[pl] + nums[pr] == -num) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(num);
                        lst.add(nums[pl]);
                        lst.add(nums[pr]);
                        res.add(lst);
                        break;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();

        List<List<Integer>> res = ts.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        System.out.printf("res: %s\n", res); // [-1, -1, 2], [-1, 0, 1]

        res = ts.threeSum(new int[] {});
        System.out.printf("res: %s\n", res); // []

        res = ts.threeSum(new int[] {0});
        System.out.printf("res: %s\n", res); // []
    }
}
