package com.river.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loss = new HashMap<>();

        for (int[] arr : matches) {
            int wonPlayer = arr[0];
            int lossPlayer = arr[1];

            if (!loss.containsKey(wonPlayer))
                loss.put(wonPlayer, 0);

            if (!loss.containsKey(lossPlayer))
                loss.put(lossPlayer, 1);
            else
                loss.put(lossPlayer, loss.get(lossPlayer) + 1);
        }

        List<Integer> zeroLoss = loss.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 0).map(Map.Entry<Integer, Integer>::getKey)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> oneLoss = loss.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry<Integer, Integer>::getKey)
                .sorted()
                .collect(Collectors.toList());

        return Arrays.asList(zeroLoss, oneLoss);
    }

    public static void main(String[] args) {
        FindPlayersWithZeroOrOneLosses f = new FindPlayersWithZeroOrOneLosses();
        System.out.println(f.findWinners(
                new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 },
                        { 10, 4 }, { 10, 9 } }));
        System.out.println(f.findWinners(
                new int[][] { { 2, 3 }, { 1, 3 }, { 5, 4 }, { 6, 4 } }));
    }
}
