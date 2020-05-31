package DynamicProgramming;

public class MinimumJumps {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr1 = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(minJumps(arr, 0, arr.length));
        System.out.println(minJumpsDP(arr));
        System.out.println(minJumps(arr1, 0, arr1.length));
        System.out.println(minJumpsDP(arr1));
    }
    /**
     * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
     *                {}
     * Output: 3 (1-> 3 -> 8 ->9)
     * @param arr
     * @return
     */
    public static int minJumps(int[] arr, int i,int n)
    {
        if (i == n-1)
            return 0;
        if ( arr[i] == 0)
            return Integer.MAX_VALUE;

        int maxStepCount = arr[i];
        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= maxStepCount && i + j < n; j++){
            int minJumpsJ = minJumps(arr, i + j, n);
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
}
