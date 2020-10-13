package Strings;

import java.util.Arrays;

//https://www.geeksforgeeks.org/longest-common-prefix-using-sorting/
//https://www.geeksforgeeks.org/longest-common-prefix-using-word-by-word-matching/
//https://www.geeksforgeeks.org/longest-common-prefix-using-character-by-character-matching/
//https://www.geeksforgeeks.org/longest-common-prefix-using-divide-and-conquer-algorithm/
//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"apple", "ape", "april"};
        String[] arr1 = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String[] arr2 = {"ca","a"};
        System.out.println(longestCommonPrefix(arr));
        System.out.println(longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix(arr2));
    }

    public static String longestCommonPrefix(String[] arr)
    {
        String smallestString = minimumLengthString(arr);

        int lastIndex = smallestString.length();
        while (lastIndex > 0 ) {
            String currentString = smallestString.substring(0, lastIndex);
            boolean mismatchFound = false;
            for (int i = 0 ; i < arr.length; i++) {
                if (!arr[i].startsWith(currentString)) {
                    mismatchFound = true;
                }
            }
            if (!mismatchFound) {
                return currentString;
            }
            lastIndex--;
        }
        return "";
    }

    //by sorting
    public static String longestCommonPrefixV2(String[] arr)
    {
        if (arr.length == 0 )
            return "";
        if (arr.length == 1)
            return arr[0];

        Arrays.sort(arr);
        String resultString = "";

        //find longest common prefix of first and last strings after sorting
        return longestCommonPrefixForTwoStrings(arr[0], arr[arr.length-1]);
    }

    //word by word match
    public static String longestCommonPrefixV3(String[] arr)
    {
        if (arr.length == 0)
            return "";
        if (arr.length == 1)
            return arr[0];
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix = longestCommonPrefixForTwoStrings(arr[i], prefix);
        }
        return prefix;
    }

    //character by character matching
    public static String longestCommonPrefixV4(String[] arr)
    {
        String smallestString = minimumLengthString(arr);
        String resultString = "";
        for (int i = 0 ; i < smallestString.length(); i++) {
            char currentChar = arr[0].charAt(i);
            for (int j = 1 ; j < arr.length; j++) {
                if (arr[j].charAt(i) != currentChar)
                    return resultString;
            }
            resultString += currentChar;
        }
        return resultString;
    }

    public static String longestCommonPrefixV5(String[] arr)
    {
        return longestCommonPrefixRecursive(arr, 0, arr.length-1);
    }

    private static String longestCommonPrefixRecursive(String[] arr, int low, int high)
    {
        if (low == high)
            return arr[low];
        if (low > high)
            return "";
        int mid = (low + high) / 2;
        String left = longestCommonPrefixRecursive(arr, low, mid);
        String right = longestCommonPrefixRecursive(arr, mid + 1, high);
        return longestCommonPrefixForTwoStrings(left, right);
    }

    private static String longestCommonPrefixForTwoStrings(String str1, String str2)
    {
        String resultString = "";
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            resultString += str1.charAt(i);
        }
        return resultString;
    }

    private static String minimumLengthString(String[] arr)
    {
        if (arr.length == 0)
            return "";

        String smallestString = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < smallestString.length()) {
                smallestString = arr[i];
            }
        }
        return smallestString;
    }

}
