package Strings;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/roman-to-integer/
public class RomanToIntegerConversion {
    public static void main(String[] args) {
        String str1 = "III";
        String str2 = "IV";
        String str3 = "IX";
        String str4 = "LVIII";
        String str5 = "MCMXCIV";

        System.out.println(convertRomanToInt(str1));
        System.out.println(convertRomanToInt(str2));
        System.out.println(convertRomanToInt(str3));
        System.out.println(convertRomanToInt(str4));
        System.out.println(convertRomanToInt(str5));
    }
    public static int convertRomanToInt(String str)
    {
        Map<Character, Integer> map = getStringIntConversionMap();
        int result = 0;
        int i = 0;
        for (i = 0 ; i < str.length() - 1; i++) {
            if (map.get(str.charAt(i)) >= map.get(str.charAt(i+1))) {
                result += map.get(str.charAt(i));
            } else {
                result += (map.get(str.charAt(i+1)) - map.get(str.charAt(i)));
                i++;
            }
        }
        if (i == str.length()-1) {
            result += map.get(str.charAt(i));
        }
        return result;
    }

    private static Map<Character,Integer> getStringIntConversionMap()
    {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }
}
