package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/space-optimized-solution-lcs/
//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
//https://www.geeksforgeeks.org/printing-longest-common-subsequence/
//https://www.geeksforgeeks.org/printing-longest-common-subsequence-set-2-printing
public class LongestCommonSubsequence {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
//        String X = "ABCDGH";
//        String Y = "DGHAEBCKR";
//        String X = "398397970";
//        String Y = "3399917206";
//        String X = "AGGTAB";
//        String Y = "GXTXAYB";
//        String X = "AATCC";
//        String Y = "ACACG";
        String X = "inmi";
        String Y = "invi";
        printLongestCommonSubsequenceLength(X,Y);
    }
    public static void printLongestCommonSubsequenceLength(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();
        System.out.println(lcsLengthRecursive(X,Y,m,n));
        System.out.println(lcsLengthDP(X,Y));
        System.out.println(lcsLengthSimplifiedDP(X,Y));
        System.out.println(lcsLengthDPV2(X,Y));
        System.out.println(getLcsDP(X,Y));
        System.out.println(getAllLcs(X,Y));
    }

    public static int lcsLengthRecursive(String X, String Y, int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m-1) == Y.charAt(n-1))
            return 1 + lcsLengthRecursive(X,Y,m-1,n-1);
        else
            return Math.max(
                    lcsLengthRecursive(X,Y,m-1,n),
                    lcsLengthRecursive(X,Y,m,n-1)
            );
    }

    public static int lcsLengthDP(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        if (m == 0 || n == 0 )
            return 0;

        int[][] dp = new int[m][n];

        dp[0][0] = X.charAt(0) == Y.charAt(0) ? 1 : 0;

        for (int i = 1 ; i < m ; i++){
            dp[i][0] = X.charAt(i) == Y.charAt(0) ? 1 : Math.max(dp[i-1][0], 0);
        }
        for (int i = 1 ; i < n ; i++){
            dp[0][i] = Y.charAt(i) == X.charAt(0) ? 1 : Math.max(dp[0][i-1], 0);
        }

        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = X.charAt(i) == Y.charAt(j)
                            ? (1 + dp[i-1][j-1])
                            : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static int lcsLengthSimplifiedDP(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        if (m == 0 || n == 0 )
            return 0;

        int[][] dp = getDPForLCS(X,Y);
        return dp[m][n];
    }

    /**
     * space optimised version
     * @param X
     * @param Y
     * @return
     */
    public static int lcsLengthDPV2(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        if (m == 0 || n == 0 )
            return 0;

        int[][] dp = new int[2][n+1];
        int index = 0;
        for (int i = 1; i <= m ; i++){
            index = i & 1;
            for (int j = 1; j <= n; j++){
                dp[index][j] = X.charAt(i-1) == Y.charAt(j-1)
                        ? (1 + dp[1-index][j-1])
                        : Math.max(dp[1-index][j], dp[index][j-1]);
            }
        }

        return dp[index][n];
    }

    public static String getLcsDP(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        String lcs = "";
        int[][] dp = getDPForLCS(X,Y);

        int i = m;
        int j = n;
        while (i > 0 && j > 0){
            if (X.charAt(i-1) == Y.charAt(j-1)){
                lcs = X.charAt(i-1) + lcs;
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else{
                j--;
            }
        }
        return lcs;
    }

    public static Set<String> getAllLcs(String X, String Y)
    {
        int[][] dp = getDPForLCS(X,Y);
        int m = X.length();
        int n = Y.length();
        return getAllLcsRecursive(X,Y,m, n, dp);
    }

    /**
     * 1. If X.chatAt(m-1) == Y.chatAt(n-1)
     *      ->  If the last characters of X and Y are same ,
     *          then the character must be present in all LCS of substring X[0…i-1] and Y[0..j-1].
     * 2. If top of current dp cell is larger than left one or vice versa, LCs is obtained by
     *    recursing over the larger value
     * 3. If both top and left are same, there is a lcs in both directions.
     * Taking set here instead of list because same strings will be added in different recursions.
     * This can be observed practically.
     * @param X
     * @param Y
     * @param m
     * @param n
     * @param dp
     * @return set of longest common subsequences for strings X[0..m-1] and Y[0..n-1]
     */
    public static Set<String> getAllLcsRecursive(String X, String Y, int m, int n, int[][] dp)
    {
        Set<String> resultSet = new HashSet<>();
        if (m == 0 || n == 0){
            resultSet.add("");
            return resultSet;
        }

        if (X.charAt(m-1) == Y.charAt(n-1)){
            Set<String> set = getAllLcsRecursive(X,Y,m-1,n-1,dp);
            for (String s: set){
                resultSet.add(s + X.charAt(m-1));
            }
        } else if (dp[m-1][n] > dp[m][n-1]){
            return getAllLcsRecursive(X,Y,m-1,n,dp);
        } else if (dp[m][n-1] > dp[m-1][n]){
            return getAllLcsRecursive(X,Y,m,n-1,dp);
        } else{
            Set<String> set1 = getAllLcsRecursive(X,Y,m-1,n,dp);
            Set<String> set2 = getAllLcsRecursive(X,Y,m,n-1,dp);
            resultSet.addAll(set1);
            resultSet.addAll(set2);
        }
        return resultSet;

    }

    private static int[][] getDPForLCS(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m ; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = X.charAt(i-1) == Y.charAt(j-1)
                        ? (1 + dp[i-1][j-1])
                        : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp;
    }
}
