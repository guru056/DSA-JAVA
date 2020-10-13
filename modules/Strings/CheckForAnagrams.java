package Strings;

//https://leetcode.com/problems/valid-anagram/
//https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
public class CheckForAnagrams {


    public static boolean checkForAnagrams(String str1, String str2)
    {
        int[] charCount = new int[26];
        for(int i = 0 ; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            charCount[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean checkForAnagramsV2(String str1, String str2)
    {
        if (str1.length() != str2.length())
            return false;

        int[] charCount = new int[26];
        for(int i = 0 ; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0)
                return false;
        }
        return true;
    }

}
