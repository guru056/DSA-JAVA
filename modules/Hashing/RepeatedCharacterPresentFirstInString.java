package Hashing;

import java.util.*;

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
    public static char getRepeatedCharacterPresentFirst(String str) {
        int[] charInfo = new int[256];

        Arrays.fill(charInfo, -1);
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0 ; i < str.length(); i++) {
            if (charInfo[str.charAt(i)] == -2) {
                continue;
            }
            if (charInfo[str.charAt(i)] == -1) {
                charInfo[str.charAt(i)] = i;
            } else {
                minIndex = Math.min(minIndex, charInfo[str.charAt(i)]);
                charInfo[str.charAt(i)] = -2;
            }
        }

        return minIndex != Integer.MAX_VALUE ? str.charAt(minIndex) : '\0';
    }
}
