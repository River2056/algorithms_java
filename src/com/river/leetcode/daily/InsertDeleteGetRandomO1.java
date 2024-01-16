package com.river.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * InsertDeleteGetRandomO1
 */
public class InsertDeleteGetRandomO1 {

    private void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1, 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 1, 2
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 in = new InsertDeleteGetRandomO1();
        in.test();
    }
}

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random = new Random();

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (this.map.containsKey(val))
            return false;
        this.map.put(val, list.size());
        this.list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!this.map.containsKey(val))
            return false;
        int delIndex = this.map.get(val);
        int lastIndex = this.list.size() - 1;
        this.map.put(this.list.get(lastIndex), delIndex);
        int temp = this.list.get(lastIndex);
        this.list.set(lastIndex, this.list.get(delIndex));
        this.list.set(delIndex, temp);
        this.list.remove(lastIndex);

        this.map.remove(val);
        return true;
    }

    public int getRandom() {
        return this.list.get(random.nextInt(this.list.size()));
    }
}
