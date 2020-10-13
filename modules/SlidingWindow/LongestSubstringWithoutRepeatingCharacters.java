package SlidingWindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str1 = "ABDEFGABEF";
        String str2 = "BBBB";
        String str3 = "GEEKSFORGEEKS";
        String str4 = "G";
        String str5 = "GE";
        String str6 = "GEE";
        String str7 = "EE";
        String str8 = "aab";


        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str1));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str2));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str3));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str4));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str5));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str6));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str7));
        System.out.println(longestSubstringWithoutRepeatingCharactersLength(str8));
    }
    public static int longestSubstringWithoutRepeatingCharactersLength(String str)
    {
        str = str.toLowerCase();
        int n = str.length();

        int[] charCount = new int[26];
        Arrays.fill(charCount, -1);
        int len = 0;
        int right = 0;
        int left = 0;
        while (right < n ) {
            if (charCount[str.charAt(right)-'a'] != -1) {
                left = Math.max(left, charCount[str.charAt(right)-'a'] + 1);
            }
            len = Math.max(len, right - left + 1);
            charCount[str.charAt(right)-'a'] = right;
            right++;
        }
        return len;
    }
}
