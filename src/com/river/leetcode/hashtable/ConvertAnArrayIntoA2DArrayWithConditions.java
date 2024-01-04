package com.river.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ConvertAnArrayIntoA2DArrayWithConditions
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            if (!freqMap.containsKey(i))
                freqMap.put(i, 1);
            else
                freqMap.put(i, freqMap.get(i) + 1);

        }

        List<Map.Entry<Integer, Integer>> entries = freqMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList());

        Map.Entry<Integer, Integer> maxInitialArrays = entries.get(0);
        for (int i = 0; i < maxInitialArrays.getValue(); i++) {
            List<Integer> innerChild = new ArrayList<>();
            innerChild.add(maxInitialArrays.getKey());
            result.add(innerChild);
        }

        int k = 0;
        int l = 1;
        while (l < entries.size()) {
            Map.Entry<Integer, Integer> entry = entries.get(l);
            for (int i = 0; i < entry.getValue(); i++) {
                result.get(k).add(entry.getKey());
                k++;
            }
            k = 0;
            l++;
        }

        return result;
    }

    public static void main(String[] args) {
        ConvertAnArrayIntoA2DArrayWithConditions c = new ConvertAnArrayIntoA2DArrayWithConditions();
        System.out.println(c.findMatrix(new int[] { 1, 3, 4, 1, 2, 3, 1 }));
        System.out.println(c.findMatrix(new int[] { 1, 2, 3, 4 }));
    }
}
