package DynamicProgramming;

import Utils.ArrayUtils;

import java.util.Arrays;


//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
//https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
public class MinimumNumberOfCoins {

    public static void main(String[] args) {
        int[] coins = {5,10,25};
        int sum = 30;
        printMinCoins(coins,sum);

        int[] coins1 = {6,5};
        int sum1 = 11;
        printMinCoins(coins1,sum1);

        int[] coins2 = {8,7,7,7};
        int sum2 = 5;
        printMinCoins(coins2,sum2);
    }

    public static void printMinCoins(int[] coins, int sum)
    {
        System.out.println(minCoinsRecursive(coins, coins.length, sum));
        System.out.println(minCoinsDP(coins, sum));
    }

    public static int minCoinsGreedy(int[] coins, int sum)
    {
        int n = coins.length;
        Arrays.sort(coins);
        ArrayUtils.reverse(coins,0,coins.length-1);

        int i = 0 ;
        int numCoins = 0;
        while (i < n && sum > 0){
            if (coins[i] <= sum){
                numCoins += sum / coins[i];
                sum =  sum % coins[i] ;
            }
            i++;
        }
        return numCoins;
    }

    public static int minCoinsRecursive(int[] coins, int n, int sum)
    {
        if (sum == 0 )
            return 0;

        if (n == 0)
            return Integer.MAX_VALUE;

        int minCoinsIncluding = Integer.MAX_VALUE;
        if (coins[n-1] <= sum){
            int maxPossibleCount = sum / coins[n-1];
            int minLocal;
            for (int i = 1 ; i <= maxPossibleCount; i++){
                minLocal = minCoinsRecursive(coins, n-1, sum - i*coins[n-1]);
                if (minLocal != Integer.MAX_VALUE && i + minLocal < minCoinsIncluding){
                    minCoinsIncluding = i + minLocal;
                }
            }
        }
        int minCoinsExcluding = minCoinsRecursive(coins, n-1, sum);

        return Math.min(minCoinsIncluding, minCoinsExcluding);
    }

    public static int minCoinsDP(int[] coins, int sum)
    {
        int n = coins.length;

        int[] dp = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= sum; i++)
        {
            for (int j = 0 ; j < n; j++)
            {
                if (coins[j] <= i){
                    int remainingSum = dp[i-coins[j]];
                    if (remainingSum != Integer.MAX_VALUE && 1 + remainingSum < dp[i])
                        dp[i] = 1 + remainingSum;
                }
            }
        }
        return dp[sum];
    }
}
