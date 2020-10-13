package Strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutation-in-string
//https://leetcode.com/problems/find-all-anagrams-in-a-string
public class PermutationInString {

    public static void main(String[] args) {
        String searchString = "a";
        String str = "ab";
        System.out.println(hasPermutation(searchString,str));
        System.out.println(findAllAnagrams("cbaebabacd", "abc"));
    }

    /**
     *
     * @param searchString
     * @param str
     * @return true if str contains any permutation of searchString
     */
    public static boolean hasPermutation(String searchString, String str) {

        int n = str.length();
        int m = searchString.length();

        int[] hashSearchStr = new int[26];
        for (int i = 0; i < m; i++) {
            hashSearchStr[searchString.charAt(i) - 'a']++;
        }

        int[] hashStr = new int[26];
        for (int i = 0; i < n; i++) {
            hashStr[str.charAt(i) - 'a']++;
            if (i - m >= 0) {
                hashStr[str.charAt(i-m)-'a']--;
            }
            if (i >= m - 1 && checkEqualFrequency(hashSearchStr, hashStr)){ // call checkEqualFrequency only if window size is greater than m-1, ab, bac -> Example test case for i >= m-1
                return true;
            }
        }
        return false;
    }

    public static boolean checkEqualFrequency(int[] hash1, int[] hash2) {
        for (int i = 0 ; i < hash1.length; i++) {
            if (hash1[i] != hash2[i])
                return false;
        }
        return true;
    }

    public static List<Integer> findAllAnagrams(String str, String patt) {
        List<Integer> indices = new ArrayList<>();
        int n = str.length();
        int m = patt.length();

        int[] hashSearchStr = new int[26];
        for (int i = 0; i < m; i++) {
            hashSearchStr[patt.charAt(i) - 'a']++;
        }

        int[] hashStr = new int[26];
        for (int i = 0; i < n; i++) {
            hashStr[str.charAt(i) - 'a']++;
            if (i - m >= 0) {
                hashStr[str.charAt(i-m)-'a']--;
            }
            if (i >= m - 1 && checkEqualFrequency(hashSearchStr, hashStr)){ // call checkEqualFrequency only if window size is greater than m-1, ab, bac -> Example test case for i >= m-1
                indices.add(i-m+1);
            }
        }
        return indices;
    }
}
