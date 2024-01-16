package com.river.leetcode.strings;

import java.util.Arrays;
import java.util.List;

/**
 * DetermineIfStringHalvesAreAlike
 */
public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        if (s.isBlank())
            return true;

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int length = s.length();
        int halfLength = s.length() / 2;
        int leftVowel = 0;
        int rightVowel = 0;
        for (int i = 0; i < halfLength; i++)
            if (vowels.contains(s.charAt(i)))
                leftVowel++;

        for (int i = halfLength; i < length; i++)
            if (vowels.contains(s.charAt(i)))
                rightVowel++;

        return leftVowel == rightVowel;
    }

    public static void main(String[] args) {
        DetermineIfStringHalvesAreAlike d = new DetermineIfStringHalvesAreAlike();
        System.out.println(d.halvesAreAlike("book")); // true
        System.out.println(d.halvesAreAlike("textbook")); // false
    }
}
