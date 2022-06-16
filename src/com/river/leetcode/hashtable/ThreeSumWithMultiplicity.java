package com.river.leetcode.hashtable;

import java.util.Arrays;

public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        int res = 0;
        int mod = 1000000007;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int T = target - arr[i];
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                if (arr[left] + arr[right] < T)
                    left++;
                else if (arr[left] + arr[right] > T)
                    right--;
                else if (arr[left] != arr[right]) { // arr[left] + arr[right] == T
                    int l = 1, r = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        l++;
                        left++;
                    }
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        r++;
                        right--;
                    }

                    res += l * r;
                    res %= mod;
                    left++;
                    right--;
                } else {
                    res += (right - left + 1) * (right - left) / 2;
                    res %= mod;
                    break;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSumWithMultiplicity tsm = new ThreeSumWithMultiplicity();

        System.out.printf("res: %s\n",
                tsm.threeSumMulti(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.printf("res: %s\n", tsm.threeSumMulti(new int[] {1, 1, 2, 2, 2, 2}, 5));
        System.out.printf("res: %s\n", tsm.threeSumMulti(new int[] {2, 1, 3}, 6));
    }
}
