package Strings;

//https://www.geeksforgeeks.org/minimum-number-appends-needed-make-string-palindrome/
public class MinimumAppendsToFormPalindrome {

    public static void main(String[] args) {
        String str1 = "abede";
        String str2 = "aabb";

        System.out.println(minAppendsRequired(str1));
        System.out.println(minAppendsRequired(str2));
    }
    /**
     * @param str
     * @return
     */
    public static int minAppendsRequired(String str) {
        int appendCount = 0;
        for (int i = 0 ; i < str.length(); i++) {
            if (CheckPalindrome.isPalindrome(str, i, str.length()-1))
                return appendCount;
            appendCount++;
        }
        return appendCount;
    }
}
