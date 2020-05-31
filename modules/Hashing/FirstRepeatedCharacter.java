package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
public class FirstRepeatedCharacter {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String str1 = "hello geeks";

        System.out.println(getFirstRepeatedCharacter(str));
        System.out.println(getFirstRepeatedCharacter(str1));

    }

    /**
     * Given a string, find the first repeated character in it.
     * We need to find the character that occurs more than once
     * and whose index of second occurrence is smallest.
     * ch = “geeksforgeeks”
     * Output: e
     *
     * @param str
     * @return
     */
    public static char getFirstRepeatedCharacter(String str)
    {
        Map<Character, List<Integer>> map = new HashMap<>();

        int minDiff = Integer.MAX_VALUE;
        char resultChar = '\0';

        for (int i = 0; i < str.length(); i++) {
            List<Integer> list;
            if (!map.containsKey(str.charAt(i))) {
                list = new ArrayList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            } else if (map.get(str.charAt(i)).size() >= 2) {
                continue;
            } else {
                list = map.get(str.charAt(i));
                list.add(i);
                int currDiff = list.get(1) - list.get(0);
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    resultChar = str.charAt(i);
                }
            }
        }
        return resultChar;
    }
}
