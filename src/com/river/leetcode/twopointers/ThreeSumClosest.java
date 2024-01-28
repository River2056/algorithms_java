package com.river.leetcode.twopointers;

/**
 * ThreeSumClosest
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int compareDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    int sum = a + b + c;
                    int diff = Math.abs(target - sum);
                    if (diff < compareDiff) {
                        compareDiff = diff;
                        result = sum;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); // 2
        System.out.println(t.threeSumClosest(new int[] { 0, 0, 0 }, 1)); // 0
        System.out.println(t.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100)); // 2
    }
}
