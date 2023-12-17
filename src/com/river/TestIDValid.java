package com.river;

public class TestIDValid {
  public boolean isValidId(String idStr) {
    if (idStr.length() < 10) return false;

    String pool = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
    int[] mapNum = new int[pool.length()];
    for (int i = 0; i < pool.length(); i++) mapNum[i] = 10 + i;

    int[] timesTable = new int[] {1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

    String firstWord = idStr.substring(0, 1);
    if (!pool.contains(firstWord)) return false;

    String number = idStr.substring(1);

    // check gender
    if (!number.substring(0, 1).matches("[1-2]")) return false;

    // calculate if valid
    // has to be multiple of 10
    String[] chars = idStr.split("");
    chars[0] = String.valueOf(mapNum[pool.indexOf(chars[0])]);
    int sum = 0;
    for (int i = 0; i < 2; i++) {
      String[] arr = chars[0].split("");
      sum += Integer.parseInt(arr[i]) * timesTable[i];
    }

    for (int i = 1; i < chars.length; i++) {
      sum += Integer.parseInt(chars[i]) * timesTable[i + 1];
    }

    if (sum % 10 != 0) return false;

    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.isValidId("E124123407")); // true
    System.out.println(s.isValidId("a12345678")); // false
  }
}
