package com.river.codesignal.hashtables;

import java.util.HashMap;
import java.util.Map;

public class AreFollowingPatterns {

    public boolean solution(String[] strings, String[] patterns) {
        Map<String, String> stringsMap = new HashMap<>();
        Map<String, String> patternsMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (stringsMap.containsKey(strings[i])
                    && !stringsMap.get(strings[i]).equals(patterns[i])
                    || patternsMap.containsKey(patterns[i])
                            && !patternsMap.get(patterns[i]).equals(strings[i])) {
                return false;
            }
            stringsMap.put(strings[i], patterns[i]);
            patternsMap.put(patterns[i], strings[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        AreFollowingPatterns afp = new AreFollowingPatterns();

        boolean res =
                afp.solution(new String[] {"cat", "dog", "dog"}, new String[] {"a", "b", "b"});
        System.out.printf("res: %s\n", res); // true

        res = afp.solution(new String[] {"cat", "dog", "doggy"}, new String[] {"a", "b", "b"});
        System.out.printf("res: %s\n", res); // false
    }
}
