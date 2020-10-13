package DynamicProgramming;

import java.util.Arrays;

//https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum  = 4;
        System.out.println(countWaysToMakeChangeDP(coins,sum));
    }

    public static int countWaysToMakeChangeRecursive(int[] coins, int m, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (m <= 0 && sum > 0)
            return 0;
        //exclude + include at least one
        return countWaysToMakeChangeRecursive(coins, m, sum ) +
                countWaysToMakeChangeRecursive(coins, m-1, sum - coins[m-1]);
    }

    /**
     * Select first coin
     * For each sum fill what could be the maximum number fo ways to form this sum
     * Select second coin
     * Since this second coin is selected, we need to find how many ways can we form sum-secondCoinVal
     * using the remaining coins. [this is available in dp]
     * @param coins
     * @param sum
     * @return
     */
    public static int countWaysToMakeChangeDP(int[] coins, int sum)
    {
        int m = coins.length;

        int[] dp = new int[sum+1];
        dp[0] = 1; // base case

        for (int i = 0; i < m ; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[sum];
    }
}
