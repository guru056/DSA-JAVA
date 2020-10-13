package Strings;

import java.util.Arrays;

//https://www.geeksforgeeks.org/reverse-words-in-a-given-string/
//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s1 = "   the sky   is blue   " ;
        String s2 = "   the   " ;
        String s3 = "  hello world!  " ;
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));
//        System.out.println(reverseWords(s3).length());

        System.out.println(reverseWordsV2(s1));
        System.out.println(reverseWordsV2(s2));
        System.out.println(reverseWordsV2(s3));
    }

    /**
     * Iterate character by character
     * Time complexity - O(N) - N is total number of characters
     * @param str
     * @return
     */
    public static String reverseWords(String str)
    {
        String localString = "";
        String resultString = "";
        str =  str.trim();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ' ){
                if(!localString.equals(""))
                    resultString += localString + " ";
                localString = "";
            } else {
                localString = str.charAt(i) + localString;
            }
        }

        resultString += localString;

        if (resultString.length() > 0 && resultString.charAt(resultString.length()-1) == ' ') {
            resultString = resultString.substring(0,resultString.length()-1);
        }
        return resultString;
    }

    /**
     * Time complexity = O(W) , W is the word length.
     * @param str
     * @return
     */
    public static String reverseWordsV2(String str) {
        if (str.length() == 0)
            return "";

        String[] strings = str.split(" ");
        str = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {
                str += strings[i] + " ";
            }
        }

        if (str.length() > 0 && str.charAt(str.length()-1) == ' ') //str.length() > 0 condition for case like " "
            str = str.substring(0, str.length()-1);
        return str;
    }
}
