package com.river.codesignal.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingDishes {
    public String[][] solution(String[][] dishes) {
        Map<String, List<String>> ingredients = new HashMap<>();

        for (int i = 0; i < dishes.length; i++) {
            for (int j = 1; j < dishes[i].length; j++) {
                List<String> mainDish = ingredients.getOrDefault(dishes[i][j], new ArrayList<>());
                mainDish.add(dishes[i][0]);
                ingredients.put(dishes[i][j], mainDish);
            }
        }

        List<String[]> res = new ArrayList<>();;
        for (Map.Entry<String, List<String>> entry : ingredients.entrySet()) {
            List<String> food = entry.getValue();
            Collections.sort(food);
            if (food.size() > 1) {
                String[] arr = new String[food.size() + 1];
                for (int i = 1; i < arr.length; i++) {
                    arr[i] = food.get(i - 1);
                }
                arr[0] = entry.getKey();
                res.add(arr);
            }
        }

        Collections.sort(res, (a, b) -> a[0].compareTo(b[0]));

        return res.toArray(new String[0][]);
    }

    public static void main(String[] args) {
        GroupingDishes gd = new GroupingDishes();

        String[][] res =
                gd.solution(new String[][] {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                        {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                        {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                        {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}});
        System.out.printf("res: %s\n", Arrays.toString(res));
    }
}
