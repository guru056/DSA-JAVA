package DynamicProgramming;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 3, 4, 3};
        printMatrixChain(arr);

        int[] arr1 = {40, 20, 30, 10, 30};
        printMatrixChain(arr1);

        int[] arr2 = {10, 20, 30, 40, 30};
        printMatrixChain(arr2);

        int[] arr3 = {10, 20, 30};
        printMatrixChain(arr3);
    }

    public static void printMatrixChain(int[] p) {
        System.out.println(matrixChainRecursiveUtil(p));
        System.out.println(matrixChainRecursiveUtilV2(p));
        System.out.println(matrixChainDP(p));
        System.out.println();
    }
    public static int matrixChainRecursiveUtil(int[] p) {
        return matrixChainRecursive(p, 1, p.length-1);
    }

    public static int matrixChainRecursiveUtilV2(int[] p) {
        int[][] dp = new int[p.length][p.length];
        return matrixChainRecursiveV2(p, 1, p.length-1, dp);
    }

    public static int matrixChainRecursive(int[] p, int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) { // k == j will lead to this call: f(p,i,j)
            int count = matrixChainRecursive(p, i, k)
                        + matrixChainRecursive(p, k + 1, j)
                        + p[i-1] * p[k] * p[j];
            min = Math.min(count, min);
        }
        return min;
    }

    /**
     * O(N3) solution with recursion
     * @param p
     * @param i
     * @param j
     * @param dp
     * @return
     */
    public static int matrixChainRecursiveV2(int[] p, int i, int j, int[][] dp) { //Recursion + DP Solution
        if (i == j)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) { // k == j will lead to this call: f(p,i,j)
            int count = matrixChainRecursive(p, i, k)
                    + matrixChainRecursive(p, k + 1, j)
                    + p[i-1] * p[k] * p[j];
            min = Math.min(count, min);
        }
        dp[i][j] = min;
        return min;
    }

    public static int matrixChainDP(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) { // chains of length 1
            dp[i][i] = 0;
        }

        for (int L = 2; L < n; L++) { // consider all chain lengths starting from 2
            for (int i = 1; i < n - L + 1; i++) { // last reachable index for each i and given length L is n - L + 1
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j && j < n; k++) { //try placing brackets at different positions from i to j-1
                    int cost = dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j];
                    dp[i][j] = Math.min(dp[i][j], cost); // take the minimum cost
                }
            }
        }

        return dp[1][n-1];
    }
}
