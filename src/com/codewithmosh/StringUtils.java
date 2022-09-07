package com.codewithmosh;

import java.util.Locale;

public class StringUtils {
    public static int countVowels(String str){
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray())
            //  if (vowels.contains(Character.toString(ch)))
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    public static String reverse(String str){
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) //  O(n)
            reversed.append(str.charAt(i)); //  O(1)

        return reversed.toString();
    }
}
