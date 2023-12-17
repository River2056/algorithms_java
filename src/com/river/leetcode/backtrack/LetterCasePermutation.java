package com.river.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
  public List<String> letterCasePermutation(String s) {
    List<StringBuilder> ans = new ArrayList<>();
    ans.add(new StringBuilder());
    for (int i = 0; i < s.length(); i++) {
      int length = ans.size();
      if (Character.isLetter(s.charAt(i))) {
        for (int j = 0; j < length; j++) {
          ans.add(new StringBuilder(ans.get(j)));
          ans.get(j).append(Character.toLowerCase(s.charAt(i)));
          ans.get(j + length).append(Character.toUpperCase(s.charAt(i)));
        }
      } else {
        for (int j = 0; j < length; j++) ans.get(j).append(s.charAt(i));
      }
    }

    List<String> res = new ArrayList<>();
    for (StringBuilder sb : ans) res.add(sb.toString());

    return res;
  }

  public static void main(String[] args) {
    LetterCasePermutation letter = new LetterCasePermutation();

    System.out.printf("1. %s\n", letter.letterCasePermutation("a1b2"));
    System.out.printf("2. %s\n", letter.letterCasePermutation("3z4"));
    System.out.printf("3. %s\n", letter.letterCasePermutation("Jw"));
  }
}
