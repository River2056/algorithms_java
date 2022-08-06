package com.river.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] res = new int[k];

        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            int id = log[0];
            int activeMinutes = log[1];

            Set<Integer> mins = null;
            if (map.containsKey(id))
                mins = map.get(id);
            else
                mins = new HashSet<>();

            mins.add(activeMinutes);
            map.put(id, mins);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> minutesActive = entry.getValue();
            if (minutesActive.size() < k)
                res[minutesActive.size() - 1]++;
        }

        return res;
    }

    // self implemented answer, accepted answer but not optimal
    public int[] findingUsersActiveMinutesSelf(int[][] logs, int k) {
        int[] res = new int[k];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            String key = Arrays.toString(logs[i]);
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }

        // get each owner frequency
        Map<String, Integer> freq = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            String owner = key.substring(key.indexOf("[") + 1, key.indexOf(","));
            if (freq.containsKey(owner))
                freq.put(owner, freq.get(owner) + 1);
            else
                freq.put(owner, 1);
        }

        for (Map.Entry<String, Integer> freqEntry : freq.entrySet()) {
            Integer uam = freqEntry.getValue();
            res[uam - 1]++;
        }

        return res;
    }

    public static void main(String[] args) {
        FindingTheUsersActiveMinutes f = new FindingTheUsersActiveMinutes();
        System.out.printf("1. %s\n", Arrays.toString(f.findingUsersActiveMinutes(
                new int[][] {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5))); // [0, 2, 0, 0, 0]
        System.out.printf("2. %s\n", Arrays
                .toString(f.findingUsersActiveMinutes(new int[][] {{1, 1}, {2, 2}, {2, 3}}, 4))); // [1,
                                                                                                  // 1,
                                                                                                  // 0,
                                                                                                  // 0]
        System.out
                .printf("3. %s\n",
                        Arrays.toString(f.findingUsersActiveMinutes(new int[][] {{305589003, 4136},
                                {305589004, 4139}, {305589004, 4141}, {305589004, 4137},
                                {305589001, 4139}, {305589001, 4139}}, 6))); // [2, 0, 1, 0, 0, 0]
    }
}
