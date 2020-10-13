package Misc;


import java.util.Arrays;

public class LeetCodeRough {

    public static int knapsack(int[] wt, int[] val, int W) {
        int[] dp = new int[W+1];
        int n = wt.length;

        for (int i = 0 ; i < n; i++) {
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j-wt[i]]);
            }
        }
        return dp[W];
    }

    public static int knapsackV2(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }
}
