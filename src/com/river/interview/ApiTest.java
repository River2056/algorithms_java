package com.river.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApiTest {
    public static List<Integer> getEven(List<Integer> nums) {
        return nums.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> res = getEven(Arrays.asList(1, 2, 3, 4));
        System.out.printf("res: %s\n", res);
    }
}
