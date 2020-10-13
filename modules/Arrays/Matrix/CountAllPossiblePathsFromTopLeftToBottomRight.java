package Arrays.Matrix;

public class CountAllPossiblePathsFromTopLeftToBottomRight {

//    https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
    //@TODO Combinatorics solution

    public static void main(String[] args) {
        System.out.println(countPossiblePaths(2, 2));
        System.out.println(countPossiblePaths(2, 3));
        System.out.println(countPossiblePaths(3, 3));

        System.out.println(countPossiblePathsRecursive2(2, 2));
        System.out.println(countPossiblePathsRecursive2(2, 3));
        System.out.println(countPossiblePathsRecursive2(3, 3));

        System.out.println(countPossiblePathsRecursive3(0, 0, 2, 2));
        System.out.println(countPossiblePathsRecursive3(0, 0, 2, 3));
        System.out.println(countPossiblePathsRecursive3(0, 0, 3, 3));

        System.out.println(countPossiblePathDPV2(2, 2));
        System.out.println(countPossiblePathDPV2(2, 3));
        System.out.println(countPossiblePathDPV2(3, 3));

    }

    public static int countPossiblePaths(int m, int n) {
        return countPossiblePathsRecursive(0, 0, m, n);
    }

    public static int countPossiblePathsRecursive(int i, int j, int m, int n) {
        if (i > m - 1 || j > n - 1)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        return countPossiblePathsRecursive(i, j + 1, m, n) + countPossiblePathsRecursive(i + 1, j, m, n);
    }

    //thinking backwards
    public static int countPossiblePathsRecursive2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return countPossiblePathsRecursive2(m, n - 1) + countPossiblePathsRecursive2(m - 1, n);
        //+countPossiblePathsRecursive2(m-1,n-1) --> required when diagonal movements are allowed
    }

    public static int countPossiblePathsRecursive3(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1)
            return 1;

        return countPossiblePathsRecursive(i, j + 1, m, n) + countPossiblePathsRecursive(i + 1, j, m, n);
    }

    public static int countPossiblePathDP(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1 ; j < n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }

    public static int countPossiblePathDPV2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1 ; j < n; j++)
                dp[j] += dp[j-1];
        }
        return dp[n-1];
    }


}
