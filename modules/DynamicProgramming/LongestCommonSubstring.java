package DynamicProgramming;

//https://www.geeksforgeeks.org/print-longest-common-substring/
//https://www.interviewbit.com/problems/longest-common-substring/#
//https://www.geeksforgeeks.org/longest-common-substring-dp-29/
//https://www.geeksforgeeks.org/longest-common-substring-space-optimized-dp-solution/
public class LongestCommonSubstring {

    public static void main(String[] args) {
//        String X = "interviewbit";
//        String Y = "intermission";
        String X = "inmi";
        String Y = "invi";
        printLongestCommonSubstringLength(X,Y);
    }
    /**
     * Input : X = “abcdxyz”, y = “xyzabcd”
     * Output : 4
     * The longest common substring is “abcd” and is of length 4.
     * @param X
     * @param Y
     * @return
     */
    public static void printLongestCommonSubstringLength(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();
        System.out.println(lcsLengthRecursive(X,Y,m,n,0));
        System.out.println(lcsLengthDP(X,Y));
        System.out.println(lcsLengthDPSimplified(X,Y));
        System.out.println(lcsLengthDPV2(X,Y));
        System.out.println(getLcsDP(X,Y));
    }

    public static int lcsLengthRecursive(String X, String Y, int m, int n, int count)
    {
        if (m == 0 || n == 0)
            return count;
        if (X.charAt(m-1) == Y.charAt(n-1))
            count =  lcsLengthRecursive(X,Y,m-1,n-1, count + 1);
        count = Math.max(
                    count,
                    Math.max(
                        lcsLengthRecursive(X,Y,m-1,n,0),
                        lcsLengthRecursive(X,Y,m,n-1,0)
                    )
            );
        return count;
    }

    public static int lcsLengthDP(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        if (m == 0 || n == 0 )
            return 0;

        int[][] dp = new int[m][n];

        dp[0][0] = X.charAt(0) == Y.charAt(0) ? 1 : 0;

        int result = 0;
        for (int i = 1 ; i < m ; i++){
            dp[i][0] = X.charAt(i) == Y.charAt(0) ? 1 :0;
            result = Math.max(result, dp[i][0]);
        }
        for (int i = 1 ; i < n ; i++){
            dp[0][i] = Y.charAt(i) == X.charAt(0) ? 1 : 0;
            result = Math.max(result, dp[0][i]);
        }
        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n; j++){
                if (X.charAt(i) == Y.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(result, dp[i][j]);
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static int lcsLengthDPSimplified(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        if (m == 0 || n == 0 )
            return 0;

        int[][] dp = new int[m+1][n+1];
        int result = 0;
        for (int i = 1; i <= m ; i++){
            for (int j = 1; j <= n; j++){
                if (X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(result, dp[i][j]);
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        return result;
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
        int result = 0;
        int index = 0;
        for (int i = 1; i <= m ; i++){
            index = i & 1;
            for (int j = 1; j <= n; j++){
                if (X.charAt(i-1) == Y.charAt(j-1)){
                    dp[index][j] = 1 + dp[1-index][j-1];
                    result = Math.max(result, dp[index][j]);
                } else{
                    dp[index][j] = 0;
                }
            }
        }
        return result;
    }

    public static String getLcsDP(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        if (m == 0 || n == 0 )
            return "";

        int[][] dp = new int[m+1][n+1];
        int result = 0;
        int lastIndex = 0;
        for (int i = 1; i <= m ; i++){
            for (int j = 1; j <= n; j++){
                if (X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(result, dp[i][j]);
                    if (result == dp[i][j])
                        lastIndex = i;
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        if (result != 0){
            return X.substring(result - lastIndex ,lastIndex);
        }
        return "";
    }
}
