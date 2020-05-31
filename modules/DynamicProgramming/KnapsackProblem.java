package DynamicProgramming;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
//https://www.geeksforgeeks.org/space-optimized-dp-solution-0-1-knapsack-problem/
public class KnapsackProblem {


    public static void main(String[] args) {
//        int[] value = {60,100,120};
        int[] value = {10,15,40};
//        int[] weight = {10,20,30};
        int[] weight = {2,6,3};
//        int W = 50;
        int W = 6;

        System.out.println(getMaxValueKnapsackRecursive( weight,value,W,weight.length ));
        System.out.println(getMaxValueKnapsackDPOptimised( weight,value,W ));
        System.out.println(getMaxValueKnapsackDPOptimisedV1( weight,value,W ));
        System.out.println(getMaxValueKnapsack( weight,value,W ));
    }
    /**
     * val = {60,100,120}
     * wt  = {10,20,30}
     * W = 50
     *
     *
     * @param weight
     * @param value
     * @param W
     * @return
     */
    public static int getMaxValueKnapsackRecursive(int[] weight, int[] value, int W, int n)
    {
        if (n == 0 || W == 0)
            return 0;

        int weightInclusive = Integer.MIN_VALUE;
        if (weight[n-1] <= W){
            weightInclusive = value[n-1] + getMaxValueKnapsackRecursive(weight, value, W - weight[n-1], n-1);
        }
        int weightExclusive = getMaxValueKnapsackRecursive(weight, value, W, n - 1);

        if (weightInclusive == Integer.MIN_VALUE && weightExclusive == Integer.MAX_VALUE)
            return 0;
        return Math.max(weightInclusive, weightExclusive);
    }

    public static int getMaxValueKnapsack(int[] weight, int[] value, int W)
    {
        int n = weight.length;
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i <= n; i++){
            for (int j = 0 ; j <= W; j++){
                if (weight[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j] , value[i-1] + dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[n][W];
    }

    public static int getMaxValueKnapsackDPOptimisedV1(int[] weight, int[] value, int W)
    {
        int n = weight.length;
        int[][] dp = new int[2][W+1];
        int index = 0;
        for (int i = 1; i <= n; i++){
            index = i & 1;
            for (int j = 0 ; j <= W; j++){
                if (weight[i-1] > j){
                    dp[index][j] = dp[1-index][j];
                } else{
                    dp[index][j] = Math.max(dp[1-index][j] , value[i-1] + dp[1-index][j-weight[i-1]]);
                }
            }
        }
        return dp[index][W];
    }


    public static int getMaxValueKnapsackDPOptimised(int[] weight, int[] value, int W)
    {
        int n = weight.length;
        int[] dp = new int[W+1];

        for (int i = 0; i < n; i++){
            for (int w = W; w >= weight[i]; w--){
                dp[w] = Math.max(dp[w], value[i] + dp[w - weight[i]]);
            }
        }
        return dp[W];
    }

}
