package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LongestOrderedVowelSubsequence {

    public static void main(String[] args) {
        System.out.println(longestSubSeqOfVowels("aaieiaaioooaauuaeiu"));
    }
    public static int longestSubSeqOfVowels(String input) {

        char[] v = {'a', 'e', 'i', 'o', 'u'};
        Map<Character, Integer> charCount = new HashMap<>();
        char c;
        int vCount = -1;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (vCount == -1 && c != 'a') {
                continue;

            }
            int value = charCount.get(c) == null ? 0 : charCount.get(c) + 1;
            if (value == 0) {

                if (c == v[vCount + 1]) {
                    value = vCount >= 0 ? charCount.get(v[vCount]) + 1 : 1;
                    vCount++;
                }

                charCount.put(c, value);

            } else {
                charCount.put(c, value);
            }
        }

        int count = 0 ;
        for (int i = 0 ; i < v.length; i++) {
            count += charCount.get(v[i]).intValue();
        }
        System.out.println(charCount);
        return count;
    }


}
