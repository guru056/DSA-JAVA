package Strings;

import java.util.*;

//https://leetcode.com/problems/implement-strstr/
//https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
public class ImplementStrStr {

    public static void main(String[] args) {
        String str = "helloll";
        String needle = "ll";
        String str1 = "aaaaa";
        String needle1 = "bba";
        String text = "THIS IS A TEST TEXT";
        String pat = "TEST";
        System.out.println(StrStr(str, needle));
        System.out.println(StrStrNaive(str, needle));
        System.out.println(StrStrNaiveV2(str, needle));
        System.out.println(StrStr(text, pat));
//        System.out.println(StrStr(str1, needle1));
//        String str = "ABCAB";
//        String str1 = "ACABACACD";
//        System.out.println(Arrays.toString(preProcess(str)));
//        System.out.println(Arrays.toString(preProcess(str1)));
    }

    public static int strStr(String string, String needle) {
        if (needle.length() == 0 || string.length() == 0 || needle.length() > string.length())
            return -1;

        for (int i = 0; i < string.length(); i++) {
            if (
                    string.charAt(i) == needle.charAt(0) &&
                            string.substring(i, i + needle.length() <= string.length() ? i + needle.length() : string.length()).equals(needle)
            )
                return i;
        }
        return -1;
    }

    public static int[] preProcess(String pattern) {
        int n = pattern.length();
        int[] LPS = new int[n]; // Longest Prefix Suffix

        LPS[0] = 0;
        int LPSLengthSoFar = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(LPSLengthSoFar) == pattern.charAt(i)) {
                LPSLengthSoFar++;
                LPS[i] = LPSLengthSoFar;
                i++;
            } else if (LPSLengthSoFar == 0) {  //current char doesn't match with first character and LPSLengthSoFar is also 0
                LPS[i] = 0;
                i++;
            } else {
                LPSLengthSoFar = LPS[LPSLengthSoFar - 1];
            }
        }
        return LPS;
    }

    public static List<Integer> StrStr(String string, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int n = string.length();
        int m = pattern.length();
        if (m > n || m == 0 || n == 0)
            return indices;

        int[] LPS = preProcess(pattern);
        int j = 0;
        int i = 0;
        while (i < n) {

            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                indices.add(i - j);
                j = LPS[j - 1];
            } else if (i < n && string.charAt(i) != pattern.charAt(j)) { //there is a mismatch after j matches
                if (j != 0)
                    j = LPS[j - 1];
                else
                    i++;
            }
        }
        return indices;
    }

    public static List<Integer> StrStrNaive(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m > n || m == 0 || n == 0) {
            return indices;
        }

        for (int i = 0; i <= n - m; i++) {
            int index = i;
            int j = 0;
            while (index < n && j < m && text.charAt(index) == pattern.charAt(j)) {
                index++;
                j++;
            }
            if (j == m) {
                indices.add(index - j);
            }
        }
        return indices;
    }

    public static List<Integer> StrStrNaiveV2(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m > n || m == 0 || n == 0) {
            return indices;
        }

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == m) {
                indices.add(i);
            }
        }
        return indices;
    }
}
