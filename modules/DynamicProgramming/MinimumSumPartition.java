package DynamicProgramming;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
public class MinimumSumPartition {


    public static int minimumSumPartitionRecursive(int[] arr, int n, int sumCalculated, int sumTotal)
    {
        if (n == 0)
            Math.abs((sumTotal - sumCalculated) - sumCalculated);

        return Math.min(
                minimumSumPartitionRecursive(arr,n-1,sumCalculated,sumTotal),
                minimumSumPartitionRecursive(arr,n-1,sumCalculated + arr[n-1], sumTotal)
        );
    }

    /**
     * get the dp corresponding to subset sum problem with sum = sum of all elements in array.
     * Using the dp array, find the sum which is possible and is closest to totalSum/2
     * @param arr
     * @return
     */
    public static int minimumSumPartitionDP(int[] arr)
    {
        int sum = ArrayUtils.getSum(arr);
        int n = arr.length;

        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean include = j - arr[i-1] < 0 ? false: dp[i-1][j-arr[i-1]];
                dp[i][j] = dp[i-1][j] || include;
            }
        }

        int minDiff  = Integer.MAX_VALUE;
        for (int j = sum/2; j >=0; j--) {
            if (dp[n][j]) {
                minDiff = (sum - j) - j;
                break;
            }
        }
        return minDiff;
    }
}
