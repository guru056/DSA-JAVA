package Strings;

import java.util.Arrays;

//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
//https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
//https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-4/
//https://algs4.cs.princeton.edu/53substring/Manacher.java.html
//https://medium.com/hackernoon/manachers-algorithm-explained-longest-palindromic-substring-22cb27a5e96f
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "gekeg";
        String str1 = "Geegs";
        String str2 = "g";
        String str3 = "forgeeksskeegfor";
        String str4 = "ac";
        String str5 = "abcda";
        String str6 = "babadada";
        String str7 = "222020221";
        String str8 = "22202022";
        String str9 = "2020";
        String str10 = "babaddtattarrattatddetartrateedredividerb";
        printLongestPalindromicSubstring(str);
        printLongestPalindromicSubstring(str1);
        printLongestPalindromicSubstring(str2);
        printLongestPalindromicSubstring(str3);
        printLongestPalindromicSubstring(str4);
        printLongestPalindromicSubstring(str5);
        printLongestPalindromicSubstring(str6);
        printLongestPalindromicSubstring(str7);
        printLongestPalindromicSubstring(str8);
        printLongestPalindromicSubstring(str9);
        printLongestPalindromicSubstring(str10);
    }

    public static void printLongestPalindromicSubstring(String str) {
        System.out.println(lps(str));
        System.out.println(lpsV2(str));
        System.out.println(lpsV3(str));
        System.out.println(lpsV4(str));
        System.out.println();
    }

    public static String lps(String str) {
        int n = str.length();
        if (n == 0)
            return "";

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int startIndex = 0;

        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                startIndex = i;
            }

        }

        for (int L = 3; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        return str.substring(startIndex, startIndex + maxLen);
    }

    public static String lpsV2(String str) {
        int n = str.length();
        if (n == 0)
            return "";
        if (n == 1)
            return str;

        int startIndex = 0;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {

            //odd length palindromes
            int low = i - 1;
            int high = i + 1;
            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    startIndex = low;
                }
                low--;
                high++;
            }

            //even length palindromes
            low = i;
            high = i + 1;
            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    startIndex = low;
                }
                low--;
                high++;
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }

    //Manacher’s Algorithm
    public static String lpsV3(String str) {
        String s = getModifiedString(str);
        int n = s.length();
        int[] LPS = new int[n];

        int center = 0;
        int right = 0;
        int maxLen = 0;
        int resultCenter = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                LPS[i] = Math.min(LPS[mirror], right - i); // stores the minimum LPS length centered at i
            }

            int high = i + (1 + LPS[i]);
            int low = i - (1 + LPS[i]);

            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                LPS[i]++;
                low--;
                high++;
            }

            if (i + LPS[i] > right) {
                center = i;
                right = i + LPS[i];
            }
            if (LPS[i] > maxLen) {
                resultCenter = i;
                maxLen = LPS[i];
            }
        }
        return str.substring((resultCenter - maxLen) / 2, (resultCenter + maxLen) / 2);
    }

    public static String lpsV4(String str) {
        int n = str.length();
        n = 2 * n + 1;
        int[] LPS = new int[n];

        int center = 0;
        int right = 0;
        int maxLen = 0;
        int resultCenter = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                LPS[i] = Math.min(LPS[mirror], right - i);
            }

            int high = i + (1 + LPS[i]);
            int low = i - (1 + LPS[i]);

            while (low >= 0 && high < n && (high % 2 == 0 || str.charAt(low / 2) == str.charAt(high / 2))) {
                LPS[i]++;
                low--;
                high++;
            }

            if (i + LPS[i] > right) {
                center = i;
                right = i + LPS[i];
            }
            if (LPS[i] > maxLen) {
                resultCenter = i;
                maxLen = LPS[i];
            }
        }
        return str.substring((resultCenter - maxLen ) / 2, (resultCenter + maxLen) / 2);
    }

    private static String getModifiedString(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append("#").append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
}
