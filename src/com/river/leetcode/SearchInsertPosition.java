package com.river.leetcode;

public class SearchInsertPosition {
    /**
     *  
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity.
     *  
     * Example 1:
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     *  
     * Constraints:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     * 
     * */

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        return binarySearch(left, right, nums, target);
    }

    public static int binarySearch(int left, int right, int[] nums, int target) {
        if(left <= right) {
            int middle = (left + right) / 2;
            if(nums[middle] == target) {
                return middle;
            }

            if(target > nums[middle]) {
                return binarySearch(middle + 1, right, nums, target);
            } else if(target < nums[middle]) {
                return binarySearch(left, middle - 1, nums, target);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }
}
