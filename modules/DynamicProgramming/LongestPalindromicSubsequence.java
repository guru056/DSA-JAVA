package DynamicProgramming;

//https://leetcode.com/problems/longest-palindromic-subsequence/
//https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
//@todo https://www.geeksforgeeks.org/longest-palindrome-subsequence-space/
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        System.out.println(lps(str));
    }

    /**
     * ALTERNATE APPROACH - LPS = LCS(str, reverse(str))
     * @param str
     * @return
     */
    public static int lps(String str) {
        int n = str.length();

        int[][] dp = new int[n][n];

        for (int i = 0 ; i < n; i++) { // length 1 sequences
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = str.charAt(i) == str.charAt(i+1) ? 2: 1;
        }

        for (int L = 3; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
