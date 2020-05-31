package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/find-repeated-character-present-first-string/
//https://www.geeksforgeeks.org/repeated-character-whose-first-appearance-is-leftmost/
public class RepeatedCharacterPresentFirstInString {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(getRepeatedCharacterPresentFirst(str));
    }
    /**
     * Given a string, find the repeated character present first in the string.
     * Input  : geeksforgeeks
     * Output : g
     * (mind that it will be g, not e.)
     * @param str
     * @return
     */
    public static char getRepeatedCharacterPresentFirst(String str)
    {
        Map<Character, Integer> map = new HashMap<>();

        int minIndex = Integer.MAX_VALUE;
        char resultChar = '\0';

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), i);
            } else {
                int currIndex = map.get(str.charAt(i));
                if (currIndex < minIndex) {
                    minIndex = currIndex;
                    resultChar = str.charAt(i);
                }
            }
        }
        return resultChar;
    }
}
