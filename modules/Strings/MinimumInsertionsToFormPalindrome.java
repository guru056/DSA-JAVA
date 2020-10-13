package Strings;

//https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinimumInsertionsToFormPalindrome {

    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "aa";
        String str3 = "abcd";
        String str4 = "abcda";
        String str5 = "abcde";
//        String str6 = "tldjbqjdogipebqsohdypcxjqkrqltpgviqtqz"; //TLE in recursive code

        printMinInsertionsRequired(str1);
        printMinInsertionsRequired(str2);
        printMinInsertionsRequired(str3);
        printMinInsertionsRequired(str4);
        printMinInsertionsRequired(str5);
    }

    public static void printMinInsertionsRequired(String str) {
        System.out.println(minimumInsertionsRequiredRecursiveUtil(str));
        System.out.println(minimumInsertionsRequiredRecursiveV2(str));
        System.out.println(minimumRecursionsRequiredDP(str));
        System.out.println(minInsertionsDPV2(str));
        System.out.println();
    }

    public static int minimumInsertionsRequiredRecursiveUtil(String str) {
        return minimumInsertionsRequiredRecursive(str, 0, str.length() - 1);
    }

    public static int minimumInsertionsRequiredRecursive(String str, int i, int j) {
        if (i > j)
            return Integer.MAX_VALUE;
        if (i == j)
            return 0;
        if (j - i == 1)
            return str.charAt(i) == str.charAt(j) ? 0 : 1;
        if (str.charAt(i) == str.charAt(j)) {
            return minimumInsertionsRequiredRecursive(str, i + 1, j - 1);
        }
        return 1 + Math.min(
                minimumInsertionsRequiredRecursive(str, i, j - 1),
                minimumInsertionsRequiredRecursive(str, i + 1, j)
        );
    }

    //cleaner solution
    //s.substring() is O(N), so dont use this!!
    public static int minimumInsertionsRequiredRecursiveV2(String str) {
        if (str.length() == 0 || str.length() == 1)
            return 0;
        if (str.length() == 2)
            return str.charAt(0) == str.charAt(1) ? 0 : 1;
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return minimumInsertionsRequiredRecursiveV2(str.substring(1, str.length() - 1));
        }
        return 1 + Math.min(
                minimumInsertionsRequiredRecursiveV2(str.substring(0, str.length() - 1)),
                minimumInsertionsRequiredRecursiveV2(str.substring(1))
        );
    }

    public static int minimumRecursionsRequiredDP(String str) {
        String reverse = "";
        int n = str.length();
        for (int i = 0; i < str.length(); i++) {
            reverse += str.charAt(n - 1 - i);
        }

        int lcsLength = lcsLength(str, reverse);
        return n - lcsLength;
    }

    private static int lcsLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ?
                        1 + dp[i - 1][j - 1] : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }

    public static int minInsertionsDPV2(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = 0;
            dp[i][i + 1] = str.charAt(i) == str.charAt(i + 1) ? 0 : 1;
        }
        dp[n - 1][n - 1] = 0;

        for (int L = 3; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = str.charAt(i) == str.charAt(j) ?
                        dp[i + 1][j - 1] :
                        1 + Math.min(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][n - 1];
    }
}
