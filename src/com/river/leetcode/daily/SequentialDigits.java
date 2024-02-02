package com.river.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();
        generate(lowLength, highLength, low, high, results);
        return results;
    }

    private void generate(int low, int high, int lowerBound, int upperBound, List<Integer> results) {
        String pool = "123456789";
        for (int i = 0; i < pool.length() - low; i++) {
            int num = Integer.parseInt(pool.substring(i, i + low));
            if (num >= lowerBound && num <= upperBound)
                results.add(num);
        }

        if (low != high)
            generate(low + 1, high, lowerBound, upperBound, results);
    }

    public static void main(String[] args) {
        SequentialDigits s = new SequentialDigits();
        System.out.println(s.sequentialDigits(100, 300)); // [123,234]
        System.out.println(s.sequentialDigits(1000, 13000)); // [1234,2345,3456,4567,5678,6789,12345]
    }
}
