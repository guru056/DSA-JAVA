package DynamicProgramming;

//https://www.geeksforgeeks.org/edit-distance-dp-5/
public class EditDistance {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(minEditDistanceRecursive(str1,str2,str1.length(),str2.length()));
        System.out.println(minEditDistanceDP(str1,str2));
        System.out.println(minEditDistanceDPV2(str1,str2));
    }


    /**
     * Given two strings str1 and str2 and below operations that can performed on str1.
     * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
     *
     * - Insert
     * - Remove
     * - Replace
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    public static int minEditDistanceRecursive(String str1, String str2, int m, int n)
    {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return minEditDistanceRecursive(str1, str2, m-1, n-1);
        }

        return 1 + Math.min(
                Math.min(
                        minEditDistanceRecursive(str1, str2, m, n - 1), //Insert
                        minEditDistanceRecursive(str1, str2, m - 1, n) //Remove
                ),
                minEditDistanceRecursive(str1, str2, m - 1, n - 1) //Replace
        );
    }

    public static int minEditDistanceDP(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++ ) {
            for (int j = 0 ;j <= n; j++ ) {

                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;

                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(
                                    dp[i][j-1], //insert
                                    dp[i-1][j] //remove
                            ),
                            dp[i-1][j-1] //replace
                    );
                }
            }
        }
        return dp[m][n];
    }


    public static int minEditDistanceDPV2(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[2][n+1];
        int index = 0;
        for (int i = 0; i <= m; i++ ) {
            for (int j = 0 ;j <= n; j++ ) {
                index = i & 1;
                if (i == 0) dp[index][j] = j;
                else if (j == 0) dp[index][j] = i;

                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[index][j] = dp[1-index][j-1];
                else {
                    dp[index][j] = 1 + Math.min(
                            Math.min(
                                    dp[index][j-1], //insert
                                    dp[1-index][j] //remove
                            ),
                            dp[1-index][j-1] //replace
                    );
                }
            }
        }
        return dp[index][n];
    }
}
