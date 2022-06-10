package com.river.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.printf("%s\n",
                codec.decode(codec.encode(new ArrayList<String>(Arrays.asList("Hello", "World")))));

        System.out.printf("%s\n",
                codec.decode(codec.encode(new ArrayList<String>(Arrays.asList("")))));
    }
}


class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<String>(Arrays.asList(""));

        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#')
                j++;

            System.out.printf("substring: %s\n", s.substring(i, j));
            int length = Integer.parseInt(s.substring(i, j));
            String word = s.substring(j + 1, j + 1 + length);
            res.add(word);
            i = j + 1 + length;
        }

        return res;
    }
}
