package com.river.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        Queue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int l = 0;
        while (!minHeap.isEmpty())
            res[l++] = minHeap.poll().getKey();

        return res;
    }

    public int[] topKFrequentSelf(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        int idx = 0;
        while (k > 0) {
            int max = map.values().stream().max((a, b) -> a - b).get();
            int key = map.entrySet().stream().filter(e -> max == e.getValue())
                    .collect(Collectors.toList()).get(0).getKey();
            res[idx++] = key;
            map.remove(key);
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements top = new TopKFrequentElements();

        int[] res = top.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        System.out.printf("res: %s\n", Arrays.toString(res));

        res = top.topKFrequent(new int[] {1}, 1);
        System.out.printf("res: %s\n", Arrays.toString(res));
    }
}
