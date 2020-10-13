package DynamicProgramming;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
public class MinimumJumps {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr1 = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(minJumpsRecursive(arr, 0, arr.length));
        System.out.println(minJumpsDP(arr));
        System.out.println(minJumpsRecursive(arr1, 0, arr1.length));
        System.out.println(minJumpsDP(arr1));
    }
    /**
     * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
     *                {}
     * Output: 3 (1-> 3 -> 8 ->9)
     * @param arr
     * @return
     */
    public static int minJumpsRecursive(int[] arr, int i, int n)
    {
        if (i == n-1)
            return 0;
        if ( arr[i] == 0)
            return Integer.MAX_VALUE;

        int maxStepCount = arr[i];
        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= maxStepCount && i + j < n; j++){
            int minJumpsJ = minJumpsRecursive(arr, i + j, n);
            if (minJumpsJ != Integer.MAX_VALUE){
                minJumps = Math.min(minJumps, 1 + minJumpsJ);
            }
        }
        return minJumps;
    }

    public static int minJumpsDP(int[] arr)
    {
        int n = arr.length;
        int[] dp = new int[n];

        /**
         * dp[i] stores the number of jumps required to reach end of array starting from i
         */
        dp[n-1] = 0; // jumps required to reach end from n-1 (end) = 0
        for (int i = n-2; i >=0; i--)
        {
            if (arr[i] == 0){
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            int minVal = findMin(dp, i+1,i+arr[i]);
            if (minVal != Integer.MAX_VALUE){
                dp[i] = Math.max(dp[i], 1 + minVal);
            } else {
                dp[i] = Integer.MAX_VALUE;
            }

        }
        return dp[0];
    }

    private static int findMin(int[] dp, int startIndex, int endIndex)
    {
        int minVal = Integer.MAX_VALUE;
        for (int i = startIndex;i <= endIndex && i < dp.length ; i++) {
            minVal = Math.min(minVal, dp[i]);
        }
        return minVal;
    }

    public static int minJumpsRecursiveV2(int[] arr, int n)
    {
        if (n == 0 )
            return 0;

        int min = Integer.MAX_VALUE;
        int k = n - 1;
        while (k >= 0) {
            if (arr[k] != 0 && k + arr[k] >= n) {
                int minJumpsFromK = minJumpsRecursiveV2(arr, k);
                if (minJumpsFromK != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + minJumpsFromK);
                }
            }
            k--;
        }
        return min;
    }

    public static int minJumpsDPV2(int[] arr)
    {
        int n = arr.length;
        if(n == 0 || (arr[0] == 0 && n > 1) )
            return Integer.MAX_VALUE;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int j;
        for (int i = 1; i < n; i++) {
            for (j = i - 1; j >=0; j--) {
                if (j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[n-1];
    }

    public static int minJumpsOptimized(int[] arr)
    {
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;


        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jump;

            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0 ){
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }
        return -1;
    }
}
