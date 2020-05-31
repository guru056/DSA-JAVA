package DynamicProgramming;

//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class RodCuttingProblem {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(getMaxValueByCuttingRod(arr,arr.length));
    }
    public static int getMaxValueByCuttingRod(int[] prices, int length)
    {
        int[] dp = new int[length + 1];

        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            int maxVal = prices[i-1];
            for (int j = i-1 ; j >= i/2; j--) {
                maxVal = Math.max(maxVal, dp[j] + dp[i-j]);
            }
            dp[i] = maxVal;
        }

        return dp[length];
    }
}
