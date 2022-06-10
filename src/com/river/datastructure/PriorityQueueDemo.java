package com.river.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>() {
            {
                put(1, 3);
                put(2, 2);
                put(3, 6);
                put(4, 1);
                put(5, 9);
                put(6, 12);
                put(7, 20);
                put(8, 50);
                put(9, 100);
                put(10, 33);
                put(11, 45);
            }
        };

        Queue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }

        System.out.println(heap);

        while (!heap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            System.out.printf("key: %s, value: %s\n", entry.getKey(), entry.getValue());
        }

    }
}
