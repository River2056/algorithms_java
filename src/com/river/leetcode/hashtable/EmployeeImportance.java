package com.river.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    public Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++)
            emap.put(employees.get(i).id, employees.get(i));
        return dfs(id);
    }

    private int dfs(Integer sub) {
        Employee targetEmployee = emap.get(sub);
        int ans = targetEmployee.importance;
        for (Integer subId : targetEmployee.subordinates)
            ans += dfs(subId);
        return ans;
    }

    public static void main(String[] args) {
        EmployeeImportance ei = new EmployeeImportance();

        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e3 = new Employee(3, 3, new ArrayList<>());
        List<Employee> lst = new ArrayList<>();
        lst.add(e1);
        lst.add(e2);
        lst.add(e3);
        int totalImportance = ei.getImportance(lst, 1);
        System.out.printf("res: %s\n", totalImportance);

        Employee e11 = new Employee(1, 2, Arrays.asList(5));
        Employee e51 = new Employee(5, -3, new ArrayList<>());
        lst = new ArrayList<>();
        lst.add(e11);
        lst.add(e51);
        totalImportance = ei.getImportance(lst, 5);
        System.out.printf("res: %s\n", totalImportance);
    }
}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee() {}

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};
