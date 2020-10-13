package Hashing;

import java.util.*;

//https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
public class FirstRepeatedCharacter {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String str1 = "hello geeks";
        String str2 = "geksforgekspp";

        printFirstRepeated(str);
        printFirstRepeated(str1);
        printFirstRepeated(str2);

    }

    public static void printFirstRepeated(String str) {
        System.out.println(getFirstRepeatedCharacterWithMinDiff(str));
        System.out.println(getFirstRepeatedCharacter(str));
        System.out.println();
    }

    /**
     * Given a string, find the first repeated character in it.
     * We need to find the character that occurs more than once
     * and WHOSE INDEX OF SECOND OCCURRENCE IS SMALLEST.
     * ch = “geeksforgeeks”
     * Output: e
     *
     * @param str
     * @return
     */
    public static char getFirstRepeatedCharacter(String str) {
        int[] charCount = new int[256];

        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
            if (charCount[str.charAt(i)] == 2) {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    /**
     * Given a string, find the first repeated character in it.
     * We need to find the character that occurs more than once
     * and DIFFERENCE OF FIRST OCCURRENCE AND SECOND OCCURRENCE IS MINIMUM
     * ch = “geeksforgeeks”
     * Output: e
     * <p>
     * ch = “geeksforgeekspp”
     * Output: p
     *
     * @param str
     * @return
     */
    public static char getFirstRepeatedCharacterWithMinDiff(String str) {
        int[] charInfo = new int[256];
        Arrays.fill(charInfo, -1);

        int minDiff = Integer.MAX_VALUE;
        char resultChar = '\0';

        for (int i = 0; i < str.length(); i++) {
            if (charInfo[str.charAt(i)] == -2) { // char has been found twice
                continue;
            }
            if (charInfo[str.charAt(i)] == -1) { // first occurrence of char
                charInfo[str.charAt(i)] = i;
            } else { // second occurrence of char
                int prevIndex = charInfo[str.charAt(i)];
                if (i - prevIndex < minDiff) {
                    minDiff = i - prevIndex;
                    resultChar = str.charAt(i);
                }
                charInfo[str.charAt(i)] = -2;
            }
        }
        return resultChar;
    }
}
