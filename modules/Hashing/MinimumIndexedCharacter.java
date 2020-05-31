package Hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-character-first-string-present-minimum-index-second-string/
public class MinimumIndexedCharacter {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String patt = "set";

        String str1 = "adcffaet";
        String patt1 = "onkl";

        System.out.println(getMinimumIndexedCharacter(str, patt));
        System.out.println(getMinimumIndexedCharacter(str1, patt1));
    }

    public static char getMinimumIndexedCharacter(String str, String patt)
    {
        int m = str.length();
        int n = patt.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0 ; i < m; i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), i);
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(patt.charAt(i))) {
                minIndex = Math.min(minIndex, map.get(patt.charAt(i)));
            }
        }

        return minIndex != Integer.MAX_VALUE ? patt.charAt(minIndex) : '\0';
    }
}
