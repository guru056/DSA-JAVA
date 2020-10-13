package Strings;

import Utils.StringUtils;

import java.util.Stack;
//https://www.geeksforgeeks.org/reverse-individual-words/
//https://www.geeksforgeeks.org/reverse-individual-words-with-o1-extra-space
//https://leetcode.com/problems/reverse-words-in-a-string-iii
public class ReverseIndividualWords {

    public static void main(String[] args) {
        String str = "   Hello    World   ";
        System.out.println(reverseIndividualWords(str));
        System.out.println(reverseIndividualWordsV2(str));
    }

    /**
     * Time Complexity - O(N) where N is the character count
     * @param str
     * @return
     */
    public static String reverseIndividualWords(String str) { //393ms
        int n = str.length();
        Stack<Character> st = new Stack<>();
        String resultString = "";

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ') {
                st.push(str.charAt(i));
            } else if (!st.isEmpty()) {
                while (!st.isEmpty()) {
                    resultString += st.pop();
                }
                resultString += " ";
            }
        }
        while (!st.isEmpty()) {
            resultString += st.pop();
        }
        return resultString;
    }

    public static String reverseIndividualWordsV2(String str) { //557 ms
        int n = str.length();
        int start = 0;
        int end = 0;
        String resultString = "";

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                if (start < end) {
                    resultString += StringUtils.swapSubstring(str, start, end-1) + " ";
                }
                start = i + 1;
                end = start;
            } else {
                end++;
            }
        }
        if (start < end)
            resultString += StringUtils.swapSubstring(str, start, end - 1);
        return resultString;
    }
}
