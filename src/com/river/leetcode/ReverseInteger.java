package com.river.leetcode;

import java.util.Arrays;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverseInt(x));

        int y = 321;
        System.out.println(reverseInt(y));

        int z = -123;
        System.out.println(reverseInt(z));

        int x1 = 120;
        System.out.println(reverseInt(x1));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    // self attempt
    public static int reverse(int x) {
        if(x == 0) return x;

        String value = String.valueOf(x);
        char[] data = value.toCharArray();
        char[] convertedData = new char[data.length];
        int j = 0;
        for(int i = data.length - 1; i >= 0; i--) {
            convertedData[j] = data[i];
            j++;
        }
        if((int) convertedData[convertedData.length - 1] < 48) {
            convertedData = Arrays.copyOf(convertedData, convertedData.length - 1);
        }

        return Integer.parseInt(String.valueOf(convertedData)) * (x < 0 ? -1 : 1);
    }

    // recommended
    public static int reverseInt(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
