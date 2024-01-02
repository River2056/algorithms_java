package com.river.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FindCommonCharacters
 */
public class FindCommonCharacters {

    public List<String> commonchars(String[] words) {
        Map<Character, Integer> collection = new HashMap<>();
        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                collection.put(word.charAt(i), Integer.MAX_VALUE);

        for (String word : words) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!temp.containsKey(c))
                    temp.put(c, 1);
                else
                    temp.put(c, temp.get(c) + 1);
            }
            for (int i = 0; i < 26; i++) {
                Character key = (char) ('a' + i);
                Integer freq = temp.getOrDefault(key, 0);
                if (collection.containsKey(key))
                    collection.put(key, Math.min(collection.get(key), freq));
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : collection.entrySet()) {
            int freq = entry.getValue();
            if (freq != 0)
                for (int i = 0; i < freq; i++)
                    result.add(entry.getKey().toString());
        }

        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters f = new FindCommonCharacters();
        System.out.println(f.commonchars(new String[] { "bella", "label", "roller" }));
        System.out.println(f.commonchars(new String[] { "cool", "lock", "cook" }));
    }
}
